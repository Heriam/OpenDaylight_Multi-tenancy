package driver.vtndatamodel;


import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Hao on 1/13/16.
 * vlanmaps shows list of VLAN mapping information. This is used for sending VLAN mapping information list to REST client.
 */
public class VlanMapList extends JSONObject{




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
