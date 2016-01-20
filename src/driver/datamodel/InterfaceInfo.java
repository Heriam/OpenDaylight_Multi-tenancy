package driver.datamodel;

import org.json.JSONObject;

/**
 * Created by Hao on 1/13/16.
 */
public class InterfaceInfo extends JSONObject{
    private String description;
    private boolean enabled;
    private String name;
    private String state;
    private String entityState;

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
                ", \"enabled\":\"" + enabled + '\"' +
                ", \"name\":\"" + name + '\"' +
                ", \"state\":\"" + state + '\"' +
                ", \"entityState\":\"" + entityState + '\"' +
                '}';
    }
}
