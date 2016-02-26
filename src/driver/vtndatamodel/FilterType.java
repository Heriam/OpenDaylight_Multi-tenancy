package driver.vtndatamodel;


import org.json.JSONObject;

/**
 * Created by Hao on 2/26/16.
 */
public class FilterType extends JSONObject implements Serializable {

    private JSONObject drop;
    private Redirect redirect;

    public FilterType(){}



    public Redirect getRedirect() {
        return redirect;
    }

    public void setRedirect(Redirect redirect) {
        this.redirect = redirect;
    }

    public FilterType(JSONObject drop, Redirect redirect){
        this.drop = drop;
        this.redirect = redirect;
    }


    public JSONObject getDrop() {
        return drop;
    }

    public void setDrop(JSONObject drop) {
        this.drop = drop;
    }

    @Override
    public String toString() {
        return "FilterType{" +
                "drop=" + drop +
                ", redirect=" + redirect +
                '}';
    }
}
