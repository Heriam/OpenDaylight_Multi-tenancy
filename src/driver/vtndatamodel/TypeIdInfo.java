package driver.vtndatamodel;

import org.json.JSONObject;

/**
 * Created by Hao on 1/13/16.
 * This is a common used Type-ID data strucdture
 */
public class TypeIdInfo extends JSONObject implements Serializable {
    private String type;
    private String id;



    public TypeIdInfo(){}

    public TypeIdInfo(String id){
        this.id = id;
        this.type = "OF";
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
