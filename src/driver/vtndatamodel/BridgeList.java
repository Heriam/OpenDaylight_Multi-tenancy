package driver.vtndatamodel;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Hao on 1/13/16.
 * vbridges shows the list of vBridge information.
 */
public class BridgeList extends JSONObject{

    private ArrayList<BridgeInfo> vbridge;

    public ArrayList<BridgeInfo> getVbridge() {
        return vbridge;
    }

    public void setVbridge(ArrayList<BridgeInfo> vbridge) {
        this.vbridge = vbridge;
    }


    @Override
    public String toString() {
        return "{\"vbridge\":"+vbridge+"}";
    }

}
