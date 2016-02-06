package driver.aaadatamodel;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Hao on 2/5/16.
 */
public class RoleList extends JSONObject {

    private ArrayList<RoleInfo> roles;

    public ArrayList<RoleInfo> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<RoleInfo> roles) {
        this.roles = roles;
    }

    public String toString() {
        return "{\"roles\":"+roles+"}";
    }

}
