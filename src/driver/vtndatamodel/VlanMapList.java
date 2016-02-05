package driver.vtndatamodel;


import driver.IMessagable;

import java.util.ArrayList;

/**
 * Created by Hao on 1/13/16.
 * vlanmaps shows list of VLAN mapping information. This is used for sending VLAN mapping information list to REST client.
 */
public class VlanMapList implements IMessagable{

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


    private ArrayList<VlanMapInfo> vlanmap;

    public ArrayList<VlanMapInfo> getVlanmap() {
        return vlanmap;
    }

    public void setVlanmap(ArrayList<VlanMapInfo> vlanmap) {
        this.vlanmap = vlanmap;
    }

    @Override
    public String toString() {
        return "{\"vlanmap\":"+vlanmap+"}";
    }
}
