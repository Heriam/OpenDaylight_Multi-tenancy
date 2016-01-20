package driver.datamodel;

import org.json.JSONObject;

/**
 * Created by Hao on 1/12/16.
 */
public class ODLVersion extends JSONObject{

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

