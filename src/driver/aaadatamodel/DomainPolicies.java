package driver.aaadatamodel;


import com.owlike.genson.annotation.JsonProperty;
import driver.vtndatamodel.Serializable;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Hao on 2/8/16.
 */
public class DomainPolicies extends JSONObject implements Serializable{

    @JsonProperty(value = "domain-name")
    private String domainname;

    private ArrayList<PolicyInfo> policies;

    public String getDomainname() {
        return domainname;
    }

    public void setDomainname(String domainname) {
        this.domainname = domainname;
    }

    public ArrayList<PolicyInfo> getPolicies() {
        return policies;
    }

    public void setPolicies(ArrayList<PolicyInfo> policies) {
        this.policies = policies;
    }

    @Override
    public String toString() {
        return "{" +
                "\"domain-name\":\"" + domainname + '\"' +
                ", \"policies\":" + policies +
                '}';
    }
}
