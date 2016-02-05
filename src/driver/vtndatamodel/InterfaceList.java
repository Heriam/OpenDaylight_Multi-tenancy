package driver.vtndatamodel;

import com.owlike.genson.annotation.JsonProperty;
import driver.IMessagable;

import java.util.ArrayList;

/**
 * Created by Hao on 1/13/16.
 * interfaces shows the list of vBridge interface information. This is used for returning vBridge interface information list to REST client.
 */
public class InterfaceList implements IMessagable{

    private String URL;
    private String Auth;
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

    @JsonProperty(value = "interface")
    private ArrayList<InterfaceInfo> interfaceField;

    public ArrayList<InterfaceInfo> getInterfaceField() {
        return interfaceField;
    }

    public void setInterfaceField(ArrayList<InterfaceInfo> interfaceField) {
        this.interfaceField = interfaceField;
    }

    public String toString() {
        return "{\"interface\":"+interfaceField+"}";
    }
}
