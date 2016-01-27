package driver.datamodel;

import org.json.JSONObject;

/**
 * Created by Hao on 1/13/16.
 */
public class BridgeInfo extends JSONObject {
    private String description;
    private String name;
    private String faults;
    private String state;
    private String ageInterval;


    public BridgeInfo(){}

    public BridgeInfo(String name, String ageInterval){
        this.name = name;
        this.ageInterval = ageInterval;
        this.description = "this is " + name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaults() {
        return faults;
    }

    public void setFaults(String faults) {
        this.faults = faults;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAgeInterval() {
        return ageInterval;
    }

    public void setAgeInterval(String ageInterval) {
        this.ageInterval = ageInterval;
    }

    @Override
    public String toString() {
        return "{" +
                "\"description\":\"" + description + '\"' +
                ", \"name\":\"" + name + '\"' +
                ", \"faults\":\"" + faults + '\"' +
                ", \"state\":\"" + state + '\"' +
                ", \"ageInterval\":\"" + ageInterval + '\"' +
                '}';
    }
}
