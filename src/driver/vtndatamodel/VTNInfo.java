package driver.vtndatamodel;

import org.json.JSONObject;

/*
 Created by Hao on 08/01/16. Info shows the configuration information for VTN. Meaning of each attribute is given below.
 description
 Specify the string that shows the description of VTN.
 There are no restrictions on the permissible characters or length of the string.
 Can be omitted.
 idleTimeout
 Specify in seconds the timeout value you want to set in idle_timeout of flow entries configured by VTN. Flow entries configured by VTN in switch will get deleted if it is not referred for the specified seconds.
 Can be omitted.
 Allowed range for value is between 0 or more and 65535 or less.
 0 shows infinite time.
 If a negative value is specified, then the specified value is ignored and it will be treated as if it is omitted.
 hardTimeout
 Specify in seconds the timeout value you want to set in hard_timeout of flow entries configured by VTN. Flow entries configured by VTN in switch will get deleted after the specified time period.
 Can be omitted.
 Allowed range for value is between 0 or more and 65535 or less.
 0 shows infinite time.
 If a negative value is specified, then the specified value is ignored and it will be treated as if it is omitted.
 Further, if a value greater than 0 is configured in both idleTimeout and hardTimeout, then the value specified in hardTimeout must be greater than the value in idleTimeout.


 */
public class VTNInfo extends JSONObject {
    private String description;
    private String name;
    private String hardTimeout;
    private String idleTimeout;



    public VTNInfo(){}

    public VTNInfo(String name, String idleTimeout, String hardTimeout){
        this.name = name;
        this.hardTimeout = hardTimeout;
        this.idleTimeout = idleTimeout;
        this.description = "This is " + name + "\'s virtual network.";
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