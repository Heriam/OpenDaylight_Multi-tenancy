package driver.datamodel;


import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Created by Hao on 1/16/16.
 */
public class MacHostInfo extends JSONObject {

    private ArrayList<MacInfo> machost;

    public ArrayList<MacInfo> getMachost() {
        return machost;
    }

    public void setMachost(ArrayList<MacInfo> machost) {
        this.machost = machost;
    }

    public void addMachost(MacInfo macInfo) { this.machost.add(macInfo); }

    public String toString() {
        return "{\"machost\":"+machost+"}";
    }
}
