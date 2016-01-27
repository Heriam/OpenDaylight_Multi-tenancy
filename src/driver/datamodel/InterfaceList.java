package driver.datamodel;

import com.owlike.genson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by Hao on 1/13/16.
 */
public class InterfaceList{

    @JsonProperty(value = "interface")
    private ArrayList<InterfaceInfo> interfaceField;

    public ArrayList<InterfaceInfo> getInterfaceField() {
        return interfaceField;
    }

    public void setInterfaceField(ArrayList<InterfaceInfo> interfaceField) {
        this.interfaceField = interfaceField;
    }

    public String toString() {
        return "{\"interface\":"+interfaceField+"}";
    }
}
