package driver.datamodel;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by Hao on 08/01/16.
 */
public class VTNList extends JSONArray{
    private ArrayList<VTNInfo> vtn;

    public ArrayList<VTNInfo> getVtn() {
        return vtn;
    }

    public void setVtn(ArrayList<VTNInfo> vtn) {
        this.vtn = vtn;
    }

    @Override
    public String toString() {
        return "{\"vtn\":"+vtn+"}";
    }
}
