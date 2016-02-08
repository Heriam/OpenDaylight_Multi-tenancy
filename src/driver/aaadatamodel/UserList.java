package driver.aaadatamodel;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Hao on 2/5/16.
 */
public class UserList extends JSONObject {

    private ArrayList<UserInfo> users;

    public ArrayList<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserInfo> users) {
        this.users = users;
    }

    public String toString() {
        return "{\"users\":"+users+"}";
    }



}
