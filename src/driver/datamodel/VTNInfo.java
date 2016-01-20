package driver.datamodel;

import org.json.JSONObject;

/**
 * Created by Hao on 08/01/16.
 */
public class VTNInfo extends JSONObject{
    private String description;
    private String name;
    private String hardTimeout;
    private String idleTimeout;

    public VTNInfo(){}

    public VTNInfo(String name, String idleTimeout, String hardTimeout){
        this.name = name;
        this.hardTimeout = hardTimeout;
        this.idleTimeout = idleTimeout;
        this.description = "This is" + name + "\'s virtual network.";
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

    public String getHardTimeout() {
        return hardTimeout;
    }

    public void setHardTimeout(String hardTimeout) {
        this.hardTimeout = hardTimeout;
    }

    public String getIdleTimeout() {
        return idleTimeout;
    }

    public void setIdleTimeout(String idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    @Override
    public String toString() {

        if (description!=null) {
            return "{" +
                    "\"description\":\"" + description + '\"' +
                    ", \"name\":\"" + name + '\"' +
                    ", \"hardTimeout\":\"" + hardTimeout + '\"' +
                    ", \"idleTimeout\":\"" + idleTimeout + '\"' +
                    '}';
        } else{
            return "{" +
                    "\"name\":\"" + name + '\"' +
                    ", \"hardTimeout\":\"" + hardTimeout + '\"' +
                    ", \"idleTimeout\":\"" + idleTimeout + '\"' +
                    '}';
        }
    }
}