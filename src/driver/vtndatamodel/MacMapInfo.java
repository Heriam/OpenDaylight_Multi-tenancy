package driver.vtndatamodel;


import driver.IMessagable;
import org.json.JSONObject;


/**
 * Created by Hao on 2/4/16.
 * When Deny is configured a broadcast message is sent to all the hosts connected to the vBridge ,
 * so a two end communication need not be establihed like allow ,
 * the hosts can communicate directly without any two way communication enabled.
 */
public class MacMapInfo extends JSONObject {


//---------------    ------------------    ----------------------     ----------------
    MacListInfo allow;
    MacListInfo deny;

    public MacListInfo getDeny() {
        return deny;
    }

    public void setDeny(MacListInfo deny) {
        this.deny = deny;
    }

    public MacListInfo getAllow() {
        return allow;
    }

    public void setAllow(MacListInfo allow) {
        this.allow = allow;
    }

    public String toString() {
        if(allow!=null&&deny!=null)
            return "{\"allow\":"+allow +
                    ", \"deny\":"+deny +
                    "}";
        else if(deny!=null)
            return "{\"deny\":"+deny+"}";
        else if(allow!=null)
            return "{\"allow\":"+allow+"}";
        else
            return null;
    }
}
