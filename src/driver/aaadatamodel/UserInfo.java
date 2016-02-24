package driver.aaadatamodel;


import driver.vtndatamodel.Serializable;
import org.json.JSONObject;

/**
 * Created by Hao on 2/5/16.
 */
public class UserInfo extends JSONObject implements Serializable{

    private int userid;
    private String name;
    private String description;
    private String enabled;
    private String email;
    private String password;

    public UserInfo(){}
    public UserInfo(String name, String password){
        this.name = name;
        this.description = "This is the info of user " + name;
        this.enabled = "true";
        this.email = name.toLowerCase() + "@telecom-bretagne.eu";
        this.password = password;
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

    public String isEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
            return "{" +
                    "\"userid\":\"" + userid + '\"' +
                    ", \"name\":\"" + name + '\"' +
                    ", \"description\":\"" + description + '\"' +
                    ", \"enabled\":\"" + enabled + '\"' +
                    ", \"email\":\"" + email + '\"' +
                    ", \"password\":\"" + password + '\"' +
                    '}';
    }

}
