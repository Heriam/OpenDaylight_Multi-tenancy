package driver.vtndatamodel;

import org.json.JSONObject;


/**
 * Created by Hao on 2/26/16.
 */
public class Redirect extends JSONObject implements Serializable {

    private Destination destination;
    private boolean output;

    public Redirect(){}
    public Redirect(Destination destination, boolean output ){
        this.destination = destination;
        this.output = output;
    }


    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public boolean isOutput() {
        return output;
    }

    public void setOutput(boolean output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "Redirect{" +
                "destination=" + destination +
                ", output=" + output +
                '}';
    }
}
