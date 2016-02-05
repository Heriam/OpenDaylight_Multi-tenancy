package driver.vtndatamodel;

import driver.IMessagable;
import org.json.JSONObject;

/**
 * Created by Hao on 1/13/16.
 * This section describes the data showing vBridge interface information.
 * Meaning of each attribute is given below.

 description
     Specify the string showing interface description.
     There are no restrictions on the permissible characters or length of the string.
     Can be omitted.
 enabled
     Specify whether interface is to be enabled or not.
     Specify true for enabling it and false for disabling it.
     Can be omitted.
 name
     Interface name gets configured.
 state
     Value showing the interface state gets configured.
     1 gets configured when interface is in UP state.
     0 gets configured when interface is in DOWN state.
     -1 gets configured when interface is in UNKNOWN state.
 entityState
     Status of the network elements mapped to interface gets configured. If Port mapping is configured on the interface, then the status of the physical port of the mapped switch gets configured.
     If the mapped network elements are operating, then 1 gets configured.
     If the mapped network elements are not operating, then 0 gets configured.
     If network elements are not mapped to interface, then -1 gets configured.

 *Further, the status of network elements are configured irrespective of whether interface is enabled or not. E.g., even if the interface is disabled, 1 will be configured in entityState if the mapped network elements are operating.
 */

public class InterfaceInfo extends JSONObject implements IMessagable{
    private String description;
    private boolean enabled;
    private String name;
    private String state;
    private String entityState;

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

    public InterfaceInfo(){}

    public InterfaceInfo(String name, boolean enabled){
        this.description = "This is interface "+name;
        this.enabled = enabled;
        this.name = name;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEntityState() {
        return entityState;
    }

    public void setEntityState(String entityState) {
        this.entityState = entityState;
    }

    @Override
    public String toString() {
        return "{" +
                "\"description\":\"" + description + '\"' +
                ", \"enabled\":" + enabled +
                ", \"name\":\"" + name + '\"' +
                ", \"state\":\"" + state + '\"' +
                ", \"entityState\":\"" + entityState + '\"' +
                '}';
    }
}
