package driver.vtndatamodel;

import driver.IMessagable;
import org.json.JSONObject;

/**
 * Created by Hao on 1/13/16.
 * This section describes the data showing Port mapping configuration information.
 */
public class PortMap_portInfo extends JSONObject implements IMessagable{
    private String name;
    private String type;
    private String id;

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

    public PortMap_portInfo(){}
    public PortMap_portInfo (String name, String id){
        this.type = "OF";
        this.name = name;
        this.id = id;
    }

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
