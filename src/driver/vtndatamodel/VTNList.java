package driver.vtndatamodel;


import java.util.ArrayList;

/**
 * Created by Hao on 08/01/16.
 * List shows a list of VTN information.
 */
public class VTNList{



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
