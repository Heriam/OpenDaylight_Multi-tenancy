package driver.vtndatamodel;


import driver.IMessagable;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Hao on 1/16/16.
 */
public class MacListInfo extends JSONObject implements IMessagable{

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
//-----------------------------------------------------------------------------------------


    private ArrayList<MacInfo> machost;
    private ArrayList<MacInfo> inetAddress;

    public ArrayList<MacInfo> getInetAddress() {
        return inetAddress;
    }

    public void setInetAddress(ArrayList<MacInfo> inetAddress) {
        this.inetAddress = inetAddress;
    }

    public ArrayList<MacInfo> getMachost() {
        return machost;
    }

    public void setMachost(ArrayList<MacInfo> machost) {
        this.machost = machost;
    }

    public void addMachost(String address, int vlan){ this.machost.add(new MacInfo(address, vlan));}

    public String toString() {
        if(machost!=null)
            return "{\"machost\":"+machost+"}";
        if(inetAddress!=null)
            return "{\"inetAddress\":"+inetAddress+"}";
        else
            return null;
    }




}
