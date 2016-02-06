package driver.aaadatamodel;

import org.json.JSONObject;

/**
 * Created by Hao on 2/5/16.
 */
public class RoleInfo extends JSONObject {

    private int roleid;
    private String name;
    private String description;


    public RoleInfo(){}

    public RoleInfo(String name, String description){
        this.name = name;
        this.description = description;
    }


    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                "\"roleid\":\"" + roleid + '\"' +
                ", \"name\":\"" + name + '\"' +
                ", \"description\":\"" + description + '\"' +
                '}';
    }

}
