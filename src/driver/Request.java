package driver;

import com.sun.jersey.api.client.ClientResponse;
import org.json.JSONObject;

/**
 * Created by Hao on 06/01/16.
 */
public interface Request {
    void Post(JSONObject payload, String requestPath);
    ClientResponse Get(String requestPath);
    void Put(JSONObject payload, String requestPath);
    void Delete(String requestPath);
}
