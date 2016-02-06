package driver;

import org.json.JSONObject;

/**
 * Created by Hao on 2/5/16.
 */
public interface IMappable {

    void setOption(boolean option);
    boolean isOption();

    void setUserID(int userID);
    int getUserID();

    JSONObject getBody();
    void setBody(JSONObject body);

    String getAuth();
    void setAuth(String auth);

    String getURL();
    void setURL(String URL);

    String getDomainID();
    void setDomainID(String domainID);

    String getMsgType();
    void setMsgType(String msgType);

    String getServID();
    void setServID(String servID);

    int getPriority();
    void setPriority(int priority);


}
