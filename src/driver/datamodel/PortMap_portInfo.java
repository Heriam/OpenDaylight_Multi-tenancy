package driver.datamodel;

import org.json.JSONObject;

/**
 * Created by Hao on 1/13/16.
 */
public class PortMap_portInfo extends JSONObject{
    private String name;
    private String type;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{\"name\":\"" + name + '\"' +
                ", \"type\":\"" + type + '\"' +
                ", \"id\":\"" + id + '\"' +
                '}';
    }
}
