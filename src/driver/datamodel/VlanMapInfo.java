package driver.datamodel;

import org.json.JSONObject;

/**
 * Created by Hao on 1/13/16.
 */
public class VlanMapInfo extends JSONObject{
    private String id;
    private String vlan;
    TypeIdInfo node;

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
