package driver.datamodel;

import org.json.JSONObject;

import javax.crypto.Mac;

/**
 * Created by Hao on 1/16/16.
 */
public class MacInfo extends JSONObject{
    private String address;
    private int vlan;

    public MacInfo(){}
    public MacInfo(String address, int vlan){
        this.address = address;
        this.vlan = vlan;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getVlan() {
        return vlan;
    }

    public void setVlan(int vlan) {
        this.vlan = vlan;
    }

    public String toString() {
        return "{\"address\":\"" + address + '\"' +
                ", \"vlan\":\"" + vlan + '\"' +
                '}';
    }

}
