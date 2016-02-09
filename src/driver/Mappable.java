package driver;

import org.json.JSONObject;

/**
 * Created by Hao on 2/5/16.
 */
public interface Mappable {

    void setOption(boolean option);
    boolean isOption();

    boolean setUserID(String userID);
    String getUserID();

    JSONObject getBody();
    void setBody(JSONObject body);

    String getAuth();
    void setAuth(String auth);

    String getURL();
    void setURL(String URL);

    String getMsgType();
    void setMsgType(String msgType);

    String getServID();
    void setServID(String servID);

    int getPriority();
    void setPriority(int priority);

    static int getDomainID(Mappable message){
        return Integer.getInteger(message.getUserID().split(":")[1]);
    }

    static int getUserID(Mappable message){
        return Integer.getInteger(message.getUserID().split(":")[0]);
    }


}
