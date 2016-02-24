package driver.aaadatamodel;

import driver.vtndatamodel.Serializable;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Hao on 2/8/16.
 */
public class DomainPolicyList extends JSONObject implements Serializable{
    private ArrayList<DomainPolicies> domains;

    public ArrayList<DomainPolicies> getDomains() {
        return domains;
    }

    public void setDomains(ArrayList<DomainPolicies> domains) {
        this.domains = domains;
    }


    public String toString() {
        return "{\"domains\":"+domains+"}";
    }
}
