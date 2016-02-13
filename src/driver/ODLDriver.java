package driver;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by Hao on 2/5/16.
 */
public class ODLDriver implements ToODL {
    private static final String ODLIP = "http://192.168.0.5:";
    private static final String JSON = "application/json";
    private static Client client =  Client.create();
    private static WebResource webResource;
    private static ClientResponse response;
    private static String auth = "Basic YWRtaW46YWRtaW4=";

    public ODLDriver(){}
    public ODLDriver(int port){
        webResource = client.resource(ODLIP+port);
    }
    @Override
    public void Post(Mappable message) throws RuntimeException{
        try {
            response = webResource.path(message.getURL())
                    .header("Content-Type", JSON)
                    .header("Authorization", auth)
                    .post(ClientResponse.class, message.getBody());

            if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
                throw new RuntimeException("Failed : HTTP error " + response.getStatus() + ": "+response.getEntity(String.class));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public ClientResponse Get( Mappable message){
        try{
            response = webResource.path(message.getURL())
                    .header("Content-Type", JSON)
                    .header("Accept", JSON)
                    .header("Authorization", auth)
                    .get(ClientResponse.class);

            if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
                throw new RuntimeException("Failed : HTTP error " + response.getStatus() + ": "+response.getEntity(String.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }
    @Override
    public void Put(Mappable message) throws RuntimeException{
        try{
            response = webResource.path(message.getURL())
                    .header("Content-Type", JSON)
                    .header("Authorization", auth)
                    .put(ClientResponse.class, message.getBody());

            if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
                throw new RuntimeException("Failed : HTTP error " + response.getStatus() + ": "+response.getEntity(String.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void Delete(Mappable message) throws RuntimeException{
        try{
            response = webResource.path(message.getURL())
                    .header("Content-Type", JSON)
                    .header("Authorization", auth)
                    .delete(ClientResponse.class);
            if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
                throw new RuntimeException("Failed : HTTP error " + response.getStatus() + ": "+response.getEntity(String.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
