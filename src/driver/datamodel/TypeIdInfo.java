package driver.datamodel;

import org.json.JSONObject;

/**
 * Created by Hao on 1/13/16.
 */
public class TypeIdInfo extends JSONObject{
    private String type;
    private String id;

    public TypeIdInfo(String type, String id){
        this.id = id;
        this.type = type;
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

    public String toString() {
        return "{\"type\":\"" + type + '\"' +
                ", \"id\":\"" + id + '\"' +
                '}';
    }
}
