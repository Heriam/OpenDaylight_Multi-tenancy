package driver;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import driver.aaadatamodel.*;
import driver.vtndatamodel.*;
import org.json.JSONObject;

import javax.el.ELContext;
import javax.ws.rs.core.MultivaluedHashMap;
import java.lang.Class;

import java.util.*;

/**
 * Created by Hao on 2/5/16.
 */
public class ODLDriver implements ToODL {
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
    public Serializable CommitRequest(Mappable message){
        try{
            ClientResponse response;
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


}
