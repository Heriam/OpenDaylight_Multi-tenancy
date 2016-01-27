package driver.datamodel;

import org.json.JSONObject;

/**
 * Created by Hao on 1/13/16.
 * Not Realized Yet
 */
public class VlanMapInfo extends JSONObject{
    private String id;
    private String vlan;
    TypeIdInfo node;

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
