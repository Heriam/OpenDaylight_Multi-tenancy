package driver.aaadatamodel;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Hao on 2/5/16.
 */
public class DomainList extends JSONObject{

    private ArrayList<DomainInfo> domains;

    public ArrayList<DomainInfo> getDomains() {
        return domains;
    }

    public void setDomains(ArrayList<DomainInfo> domains) {
        this.domains = domains;
    }

    public String toString() {
        return "{\"domains\":"+domains+"}";
    }

}
