package driver;



import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONObject;

/**
 * Created by Hao on 06/01/16.
 */

public class Requester implements Request{

    private static final String json = "application/json";
    private static final String authZ = "Basic YWRtaW46YWRtaW4=";
    private static final String odlIP = "10.10.10.2";
    private static final Client client =  Client.create();
    private static WebResource webResource;
    private static ClientResponse response;

    public Requester(String requestURL){
        this.webResource = client.resource("http://"+odlIP+":"+requestURL);
    }

    public void Post(JSONObject payload, String requestPath) throws RuntimeException{
        try {
            response = webResource.path(requestPath)
                    .header("Content-Type", json)
                    .header("Authorization", authZ)
                    .post(ClientResponse.class, payload);

            if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
                throw new RuntimeException("Failed : HTTP error " + response.getStatus() + ": "+response.getEntity(String.class));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ClientResponse Get(String requestPath) throws RuntimeException{
        try {
            response = webResource.path(requestPath)
                    .header("Content-Type", json)
                    .header("Accept", json)
                    .header("Authorization", authZ)
                    .get(ClientResponse.class);

            if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
                throw new RuntimeException("Failed : HTTP error " + response.getStatus() + ": "+response.getEntity(String.class));
            }

            return response;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void Put(JSONObject payload, String requestPath) throws RuntimeException{
        try{
            response = webResource.path(requestPath)
                    .header("Content-Type", json)
                    .header("Authorization", authZ)
                    .put(ClientResponse.class, payload);

            if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
                throw new RuntimeException("Failed : HTTP error " + response.getStatus() + ": "+response.getEntity(String.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
    }}

    public void Delete(String requestPath) throws RuntimeException{
        try{
            response = webResource.path(requestPath)
                    .header("Content-Type", json)
                    .header("Authorization", authZ)
                    .delete(ClientResponse.class);
            if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
                throw new RuntimeException("Failed : HTTP error " + response.getStatus() + ": "+response.getEntity(String.class));
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }}
