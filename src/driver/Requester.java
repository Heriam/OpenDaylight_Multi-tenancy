package driver;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by Hao on 2/5/16.
 */
public class Requester implements IRequestODL {
    String ODLIP = "http://172.23.225.48:8282";
    String JSON = "application/json";
    private static final Client client =  Client.create();
    private static WebResource webResource;
    private static ClientResponse response;

    public Requester(){
        webResource = client.resource(ODLIP);}

    public void Post(IMessagable message) throws RuntimeException{
        try {
            response = webResource.path(message.getURL())
                    .header("Content-Type", JSON)
                    .header("Authorization", message.getAuth())
                    .post(ClientResponse.class, message.getBody());

            if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
                throw new RuntimeException("Failed : HTTP error " + response.getStatus() + ": "+response.getEntity(String.class));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ClientResponse Get( IMessagable message) throws RuntimeException{
        try {
            response = webResource.path(message.getURL())
                    .header("Content-Type", JSON)
                    .header("Accept", JSON)
                    .header("Authorization", message.getAuth())
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

    public void Put(IMessagable message) throws RuntimeException{
        try{
            response = webResource.path(message.getURL())
                    .header("Content-Type", JSON)
                    .header("Authorization", message.getAuth())
                    .put(ClientResponse.class, message.getBody());

            if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
                throw new RuntimeException("Failed : HTTP error " + response.getStatus() + ": "+response.getEntity(String.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }}

    public void Delete(IMessagable message) throws RuntimeException{
        try{
            response = webResource.path(message.getURL())
                    .header("Content-Type", JSON)
                    .header("Authorization", message.getAuth())
                    .delete(ClientResponse.class);
            if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
                throw new RuntimeException("Failed : HTTP error " + response.getStatus() + ": "+response.getEntity(String.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
