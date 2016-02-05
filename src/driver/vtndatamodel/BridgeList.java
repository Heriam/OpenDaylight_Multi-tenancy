package driver.vtndatamodel;

import driver.IMessagable;

import java.util.ArrayList;

/**
 * Created by Hao on 1/13/16.
 * vbridges shows the list of vBridge information.
 */
public class BridgeList implements IMessagable{

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

    private ArrayList<BridgeInfo> vbridge;

    public ArrayList<BridgeInfo> getVbridge() {
        return vbridge;
    }

    public void setVbridge(ArrayList<BridgeInfo> vbridge) {
        this.vbridge = vbridge;
    }


    @Override
    public String toString() {
        return "{\"vbridge\":"+vbridge+"}";
    }

}
