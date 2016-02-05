package driver.vtndatamodel;


import driver.IMessagable;

import java.util.ArrayList;

/**
 * Created by Hao on 08/01/16.
 * List shows a list of VTN information.
 */
public class VTNList implements IMessagable{

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

    private ArrayList<VTNInfo> vtn;

    public ArrayList<VTNInfo> getVtn() {
        return vtn;
    }

    public void setVtn(ArrayList<VTNInfo> vtn) {
        this.vtn = vtn;
    }

    @Override
    public String toString() {
        return "{\"vtn\":"+vtn+"}";
    }
}
