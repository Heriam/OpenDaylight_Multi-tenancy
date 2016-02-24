package driver.aaadatamodel;

import driver.vtndatamodel.Serializable;
import org.json.JSONObject;

/**
 * Created by Hao on 2/6/16.
 */
public class PolicyInfo extends JSONObject implements Serializable{

    private String authorization;
    private String role;
    private String resource;
    private String service;
    private String action;

    public PolicyInfo(){}

    public PolicyInfo(String role, String resourcePath, String serviceName){
        this.role = role;
        this.resource = resourcePath;
        this.service = serviceName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
            return "{" +
                    "\"role\":\"" + role + '\"' +
                    ", \"resource\":\"" + resource + '\"' +
                    ", \"service\":\"" + service + '\"' +
                    ", \"authorization\":\"" + authorization + '\"' +
                    ", \"action\":\"" + action + '\"' +
                    '}';
    }


}
