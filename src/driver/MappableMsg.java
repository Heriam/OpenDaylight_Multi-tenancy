package driver;

import org.json.JSONObject;

/**
 * Created by Hao on 2/5/16.
 */
public class MappableMsg implements Mappable {

    private JSONObject body;
    private String URL;
    private String Auth;
    private String msgType;
    private String servID;
    private boolean option = false;
    private int priority;
    private String userID;

    public MappableMsg(){}
    public MappableMsg(JSONObject body, String URL, String Auth){
        this.setBody(body);
        this.setURL(URL);
        this.setAuth(Auth);
    }

    @Override
    public String getUserID() {
        return userID;
    }

    @Override
    public boolean setUserID(String userID) {
        try {
        String[] userDomainPair = userID.split(":");
        if(userDomainPair.length>2) {
            throw new RuntimeException("Failed : Userid field not match");
        }} catch (Exception e) {
            e.printStackTrace();
            return false;
    }
        this.userID = userID;
        return true;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }


    @Override
    public String getServID() {
        return servID;
    }

    @Override
    public void setServID(String servID) {
        this.servID = servID;
    }

    @Override
    public String getMsgType() {
        return msgType;
    }
    @Override
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    @Override
    public boolean isOption() {
        return option;
    }

    @Override
    public void setOption(boolean option) {
        this.option = option;
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
