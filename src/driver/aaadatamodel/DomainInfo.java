package driver.aaadatamodel;

import org.json.JSONObject;

/**
 * Created by Hao on 2/5/16.
 */
public class DomainInfo extends JSONObject{

    private String domainid;
    private String name;
    private String description;
    private String enabled;


    public DomainInfo (){}

    public DomainInfo (String name){
        this.name = name;
        this.description = name + "'s domain";
        this.enabled = "true";
    }


    public String getDomainid() {
        return domainid;
    }

    public void setDomainid(String domainid) {
        this.domainid = domainid;
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

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "{" +
                "\"domainid\":\"" + domainid + '\"' +
                ", \"name\":\"" + name + '\"' +
                ", \"description\":\"" + description + '\"' +
                ", \"enabled\":\"" + enabled + '\"' +
                '}';
    }

}
