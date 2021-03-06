package driver.vtndatamodel;

import org.json.JSONObject;

/**
 * Created by Hao on 1/16/16.
 * Note: MAC mapping will not be activated just by configuring it, a two end communication needs to be establihed to activate Mac Mapping.
 */
public class MacInfo extends JSONObject implements Serializable{


    //-------------------------------------------------------------------------------------

    private String address;
    private int vlan;
    int needVlan;

    public MacInfo(){}
    public MacInfo(String address, int vlan){
        this.address = address;
        this.vlan = vlan;
        this.needVlan = 1;
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
        if(needVlan!=0)
            return "{\"address\":\"" + address + '\"' +
                    ", \"vlan\":\"" + vlan + '\"' +
                    '}';
        else
            return  "{\"address\":\"" + address + '\"' +
                    '}';
    }

}
