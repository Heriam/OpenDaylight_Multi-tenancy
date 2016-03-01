package driver;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import driver.aaadatamodel.*;
import driver.vtndatamodel.*;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hao on 2/5/16.
 */
public class ODLDriver implements ToODL {

    private static final Logger log = LoggerFactory.getLogger(ODLDriver.class);

    public static final String ODLIP = "192.168.0.102:";
    private static final String JSON = "application/json";
    private static Client client =  Client.create();
    private static WebResource webResource;
    private static ClientResponse response;
    private static String auth = "Basic YWRtaW46YWRtaW4=";

    public ODLDriver(){}
    public ODLDriver(int port){
        webResource = client.resource("http://"+ODLIP+port);
    }

    @Override
    public ClientResponse Post(Mappable message) throws RuntimeException{
        log.info("ODLDriver: ~~~~~~~~~POST: "+message.getBody()+"~~~~~~~~~~");
            response = webResource.path(message.getURL())
                    .header("Content-Type", JSON)
                    .header("Authorization", auth)
                    .post(ClientResponse.class, message.getBody());

            if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
                throw new RuntimeException("Failed : HTTP error " + response.getStatus() + ": "+response.getEntity(String.class));
            }


        return response;
    }

    @Override
    public ClientResponse Get(Mappable message) throws RuntimeException{
        log.info("ODLDriver: ~~~~~~~~~GET: "+message.getBody()+"~~~~~~~~~~");
            response = webResource.path(message.getURL())
                    .header("Content-Type", JSON)
                    .header("Accept", JSON)
                    .header("Authorization", auth)
                    .get(ClientResponse.class);

            if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
                throw new RuntimeException("Failed : HTTP error " + response.getStatus() + ": "+response.getEntity(String.class));
            }

        return response;
    }

    @Override
    public ClientResponse Put(Mappable message) throws RuntimeException{
        log.info("ODLDriver: ~~~~~~~~~PUT: "+message.getBody()+"~~~~~~~~~~");
            response = webResource.path(message.getURL())
                    .header("Content-Type", JSON)
                    .header("Authorization", auth)
                    .put(ClientResponse.class, message.getBody());

            if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
                throw new RuntimeException("Failed : HTTP error " + response.getStatus() + ": "+response.getEntity(String.class));
            }
        return response;
    }

    @Override
    public ClientResponse Delete(Mappable message) throws RuntimeException{
        log.info("ODLDriver: ~~~~~~~~~DELETE: "+message.getBody()+"~~~~~~~~~~");
            response = webResource.path(message.getURL())
                    .header("Content-Type", JSON)
                    .header("Authorization", auth)
                    .delete(ClientResponse.class);
            if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
                throw new RuntimeException("Failed : HTTP error " + response.getStatus() + ": "+response.getEntity(String.class));
            }
        return response;
    }

    @Override
    public Serializable CommitRequest(Mappable request){
        try{
            ClientResponse response;
            Mappable message = HandleSpecialCases(request);
            log.info("Commit Request: " + message);
            switch (message.getMsgType()) {
                case "create":
                    response = Post(message);
                    return new ResponseMsgPOJO(response.getStatus() + " " + response.getEntity(String.class));
                case "update":
                    response = Put(message);
                    return new ResponseMsgPOJO(response.getStatus() + " " + response.getEntity(String.class));
                case "delete":
                    response = Delete(message);
                    return new ResponseMsgPOJO(response.getStatus() + " " + response.getEntity(String.class));
                case "read":
                    return goForGET(message);
                default:
                    throw new RuntimeException("Request Error : No Method Match");
            }
        } catch (RuntimeException e){
                return new ResponseMsgPOJO(e.getMessage());
            }
    }

    private Serializable goForGET(Mappable message) throws RuntimeException{
        List<String> urlList= new ArrayList<>();
        for (String element : message.getURL().split("/")){
            urlList.add(element);
        }
        List<String> ServTypeID = urlList.subList(urlList.size()-2,urlList.size());
        String rsrcID = ServTypeID.get(ServTypeID.size()-1);

        if (ServTypeID.contains("version")) {
            return Get(message).getEntity(ODLVersion.class);
        } else if (ServTypeID.contains("vtns")) {
            if (rsrcID.equals("vtns")) {
                return Get(message).getEntity(VTNList.class);
            } else {
                return Get(message).getEntity(VTNInfo.class);
            }
        } else if (ServTypeID.contains("vbridges")) {
            if (rsrcID.equals("vbridges")) {
                return Get(message).getEntity(BridgeList.class);
            } else {
                return Get(message).getEntity(BridgeInfo.class);
            }
        } else if (ServTypeID.contains("interfaces")) {
            if (rsrcID.equals("interfaces")) {
                return Get(message).getEntity(InterfaceList.class);
            } else {
                return Get(message).getEntity(BridgeInfo.class);
            }
        } else if (ServTypeID.contains("portmap")) {
            return Get(message).getEntity(PortMapInfo.class);
        } else if (ServTypeID.contains("macmap")) {
            return Get(message).getEntity(MacMapInfo.class);
        } else if (ServTypeID.contains("vlanmaps")) {
            return Get(message).getEntity(VlanMapList.class);
        } else if (message.getURL().startsWith("auth")&&ServTypeID.contains("domains")) {
            if (rsrcID.equals("domains")) {
                return Get(message).getEntity(DomainList.class);
            } else {
                return Get(message).getEntity(DomainInfo.class);
            }
        } else if (ServTypeID.contains("users")) {
            if (rsrcID.equals("users")) {
                return Get(message).getEntity(UserList.class);
            } else {
                return Get(message).getEntity(UserInfo.class);
            }
        } else if (ServTypeID.contains("roles")) {
            if (rsrcID.equals("roles")) {
                return Get(message).getEntity(RoleList.class);
            } else {
                return Get(message).getEntity(RoleInfo.class);
            }
        } else if (message.getURL().startsWith("restconf")&&ServTypeID.contains("domains")) {
            return Get(message).getEntity(DomainPolicies.class);
        } else if (ServTypeID.contains("policies")) {
            return Get(message).getEntity(PolicyList.class);
        } else
            throw new RuntimeException("Request Failure : No POJO Matched ");
    }


    private Mappable HandleSpecialCases(Mappable request){
        if(request.getURL().endsWith("portmap")){
            JSONObject oldBody = request.getBody();
            String vlan = Integer.toString(oldBody.getInt("vlan"));
            JSONObject node = oldBody.getJSONObject("node");
            String nodeID = node.getString("id");
            JSONObject port = oldBody.getJSONObject("port");
            String portID = port.getString("id");
            String portName = port.getString("name");
            PortMapInfo newBody = new PortMapInfo(vlan, new TypeIdInfo(nodeID), new PortMap_portInfo(portName, portID));
            request.setBody(newBody);
            return request;
        } else if(request.getURL().contains("flowfilters")){
            Redirect newRedirect;
            JSONObject oldBody = request.getBody();
            int oldIndex = oldBody.getInt("index");
            String oldCondition = oldBody.getString("condition");
            JSONObject oldFilterType = oldBody.getJSONObject("filterType");
            JSONObject oldDrop = oldFilterType.has("drop")? oldFilterType.getJSONObject("drop"): null;
            if (oldFilterType.has("redirect")) {
                boolean oldOutput = oldFilterType.getJSONObject("redirect").getBoolean("output");
                JSONObject oldDestination = oldFilterType.getJSONObject("redirect").getJSONObject("destination");
                String terminal = oldDestination.getString("terminal");
                String Interface = oldDestination.getString("interface");
                Destination newDestination = new Destination(terminal, Interface);
                newRedirect = new Redirect(newDestination, oldOutput);
            } else {
                newRedirect = null;
            }
            FlowFilterInfo flowFilter= new FlowFilterInfo(oldIndex,oldCondition, new FilterType(oldDrop, newRedirect));
            request.setBody(flowFilter);
            return request;
        } else{
            return request;
        }
    }
}
