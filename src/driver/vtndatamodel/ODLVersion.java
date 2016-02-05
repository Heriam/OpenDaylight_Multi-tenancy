package driver.vtndatamodel;

import driver.IMessagable;
import org.json.JSONObject;

/**
 * Created by Hao on 1/12/16.
 * This section describes the container independent REST API provided by VTN Manager.
 * version shows version information of VTN Manager. It is used for returning version information of VTN Manager to REST client.
 * It retrieves the version information of VTN Manager.
 * Meaning of each attribute is as follows.

 api
     Value showing the API version of VTN Manager will get configured.
     API version will be a value equal to or greater than 1, and it is incremented if API of VTN Manager is changed.
     Current VTN Manager will return 1 as API version.
 *
 *
 */
public class ODLVersion extends JSONObject implements IMessagable{

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

    private int api;
    private ODLBundle bundle;

    public int getApi() {
        return api;
    }

    public void setApi(int api) {
        this.api = api;
    }

    public ODLBundle getBundle() {
        return bundle;
    }

    public void setBundle(ODLBundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public String toString() {
        return "{\"api\":" + api +
                ", \"bundle\":" + bundle + "}";
    }
}

