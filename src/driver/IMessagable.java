package driver;

import org.json.JSONObject;

/**
 * Created by Hao on 2/5/16.
 */
public interface IMessagable {

    JSONObject getBody();
    void setBody(JSONObject body);
    String getURL();
    String getAuth();
    void setURL(String URL);
    void setAuth(String auth);
}
