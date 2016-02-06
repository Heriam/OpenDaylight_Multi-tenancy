package driver;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by Hao on 2/5/16.
 */
public class ODLDriver {
    private static String ODLIP = "http://172.23.225.48:8282";
    private static final String JSON = "application/json";
    private static final Client client =  Client.create();
    private static WebResource webResource= client.resource(ODLIP);
    private static ClientResponse response;

    public static void Post(IMappable message) throws RuntimeException{
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

    public static ClientResponse Get( IMappable message){

            response = webResource.path(message.getURL())
                    .header("Content-Type", JSON)
                    .header("Accept", JSON)
                    .header("Authorization", message.getAuth())
                    .get(ClientResponse.class);

            return response;

    }

    public static void Put(IMappable message) throws RuntimeException{
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

    public static void Delete(IMappable message) throws RuntimeException{
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
