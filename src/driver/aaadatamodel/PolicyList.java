package driver.aaadatamodel;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Hao on 2/6/16.
 */
public class PolicyList extends JSONObject {

    private ArrayList<PolicyInfo> policies;

    public ArrayList<PolicyInfo> getPolicies() {
        return policies;
    }

    public void setPolicies(ArrayList<PolicyInfo> policies) {
        this.policies = policies;
    }

    public String toString() {
        return "{\"policies\":"+policies+"}";
    }

}
