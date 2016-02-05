package driver.vtndatamodel;

import driver.IMessagable;
import org.json.JSONObject;

/**
 * Created by Hao on 1/13/16.
 * This section describes the data showing VLAN mapping information.
 *
 *Meaning of each attribute is given below.
     vlan
         Specify the VLAN ID to be mapped by using numerical value.
         Allowed range for value is between 0 or more and 4095 or less.
         0 implies untagged ethernet frame.
         If omitted, it will be treated as if 0 is specified.

 The element node shows the Node information corresponding to the switch that is to be mapped. If the element node is omitted, then all the switches are mapped.
 Meaning of elements inside node is given below.
     type
         Specify the string showing the type of Node.
         Specify OF for OpenFlow switch.
     id
         Specify the string showing the identifier of Node.
         Specify the string representation of DPID for OpenFlow switch.
 *
 */
public class VlanMapInfo extends JSONObject implements IMessagable{
    private String id;
    private String vlan;
    TypeIdInfo node;

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

    public VlanMapInfo(){}

    public VlanMapInfo(String id, String vlan, TypeIdInfo node){
        this.id = id;
        this.vlan = vlan;
        this.node = node;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVlan() {
        return vlan;
    }

    public void setVlan(String vlan) {
        this.vlan = vlan;
    }

    public TypeIdInfo getNode() {
        return node;
    }

    public void setNode(TypeIdInfo node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + '\"' +
                ", \"vlan\":\"" + vlan + '\"' +
                ", \"node\":" + node +
                '}';
    }
}
