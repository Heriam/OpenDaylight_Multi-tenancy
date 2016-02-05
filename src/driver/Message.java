package driver;

import org.json.JSONObject;

/**
 * Created by Hao on 2/5/16.
 */
public class Message implements IMessagable {

    private JSONObject body;
    private String URL;
    private String Auth;

    public Message(){}
    public Message(JSONObject body, String URL, String Auth){
        this.setBody(body);
        this.setURL(URL);
        this.setAuth(Auth);
    }

    @Override
    public JSONObject getBody() {
        return body;
    }

    @Override
    public void setBody(JSONObject body){
        this.body = body;
    }

    @Override
    public String getURL() {
        return URL;
    }
    @Override
    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String getAuth() {
        return Auth;
    }
    @Override
    public void setAuth(String auth) {
        Auth = auth;
    }
}
