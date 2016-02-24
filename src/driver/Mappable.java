package driver;

import aaa.authn.VTNAuthNToken;
import org.json.JSONObject;


/**
 * Created by Hao on 2/5/16.
 */
public interface Mappable {

    void setOption(boolean option);
    boolean isOption();

    JSONObject getBody();
    void setBody(JSONObject body);

    VTNAuthNToken getToken();
    void setToken(VTNAuthNToken token);

    String getURL();
    void setURL(String URL);

    String getMsgType();
    void setMsgType(String msgType);

    String getServID();
    void setServID(String servID);

    int getStatus();
    void setStatus(int Status);
}
