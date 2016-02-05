package driver.vtndatamodel;


import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Hao on 1/16/16.
 */
public class MacListInfo extends JSONObject{

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
