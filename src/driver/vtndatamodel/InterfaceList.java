package driver.vtndatamodel;

import com.owlike.genson.annotation.JsonProperty;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Hao on 1/13/16.
 * interfaces shows the list of vBridge interface information. This is used for returning vBridge interface information list to REST client.
 */
public class InterfaceList extends JSONObject implements Serializable{


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
