package driver.vtndatamodel;

import driver.IMessagable;
import org.json.JSONObject;

/**
 * Created by Hao on 1/13/16.
 * This section describes the data showing vBridge information.
 * Meaning of each attribute is given below.
 description
     Specify the string that describes vBridge.
     There are no restrictions on the permissible characters or length of the string.
     Can be omitted.
 ageInterval
     Specify in seconds the interval of aging for MAC address table in vBridge.
     Can be omitted.
     Allowed range for value is between 10 or more and 1000000 or less.
     If a negative value is specified, then the specified value is ignored and it will be treated as if it is omitted.
 name
     vBridge name gets configured.
 faults
     Count of path faults detected inside vBridge gets configured. This shows the number of paths between the switches, constituting a vBridge, that could not be configured by VTN Manager because the paths were broken.
     0 gets configured when no path fault has been detected.
     Count of path fault is counted for each direction of path. E.g., if switch A and switch B are separated, then the path from switch A to switch B and path from switch B to switch A are treated as different and both are counted.
 state
     Value showing vBridge state gets configured.
     1 gets configured when vBridge is in UP state.
     0 gets configured when vBridge is in DOWN state.
     -1 gets configured when vBridge is in UNKNOWN state.

 */

public class BridgeInfo extends JSONObject implements IMessagable {
    private String description;
    private String name;
    private String faults;
    private String state;
    private String ageInterval;

    private String URL;
    private String Auth;
    @Override
    public String getURL() {
        return URL;
    }
    @Override
    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String getAuth() {
        return Auth;
    }
    @Override
    public void setAuth(String auth) {
        Auth = auth;
    }



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
