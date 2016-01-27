package driver.datamodel;


import java.util.ArrayList;

/**
 * Created by Hao on 1/13/16.
 */
public class VlanMapList{
    private ArrayList<VlanMapInfo> vlanmap;

    public ArrayList<VlanMapInfo> getVlanmap() {
        return vlanmap;
    }

    public void setVlanmap(ArrayList<VlanMapInfo> vlanmap) {
        this.vlanmap = vlanmap;
    }

    @Override
    public String toString() {
        return "{\"vlanmap\":"+vlanmap+"}";
    }
}
