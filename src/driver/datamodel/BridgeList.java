package driver.datamodel;

import java.util.ArrayList;

/**
 * Created by Hao on 1/13/16.
 */
public class BridgeList{
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
