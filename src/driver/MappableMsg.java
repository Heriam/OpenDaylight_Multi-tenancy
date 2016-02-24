package driver;

import aaa.authn.VTNAuthNToken;
import driver.vtndatamodel.Serializable;
import org.json.JSONObject;


/**
 * Created by Hao on 2/5/16.
 */
public class MappableMsg implements Mappable, Serializable {

    private JSONObject body;
    private String URL;
    private VTNAuthNToken Auth;
    private String msgType;
    private String servID;
    private boolean option = false;
    private int status;

    public MappableMsg(){}
    public MappableMsg(JSONObject body, String URL, VTNAuthNToken Auth){
        this.setBody(body);
        this.setURL(URL);
        this.setToken(Auth);
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
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
    public VTNAuthNToken getToken() {
        return Auth;
    }

    @Override
    public void setToken(VTNAuthNToken auth) {
        Auth = auth;
    }

    @Override
    public String toString() {
        return "MappableMsg{" +
                "body=" + body +
                ", URL='" + URL + '\'' +
                ", Auth=" + Auth +
                ", msgType='" + msgType + '\'' +
                ", servID='" + servID + '\'' +
                ", option=" + option +
                ", status=" + status +
                '}';
    }
}
