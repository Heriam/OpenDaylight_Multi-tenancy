package driver.datamodel;

import org.json.JSONArray;
import java.util.ArrayList;

/**
 * Created by Hao on 1/16/16.
 */
public class MacHostInfo extends JSONArray{
    private ArrayList<MacInfo> machost;

    public ArrayList<MacInfo> getMachost() {
        return machost;
    }

    public void setMachost(ArrayList<MacInfo> machost) {
        this.machost = machost;
    }

    public String toString() {
        return "{\"machost\":"+machost+"}";
    }
}
