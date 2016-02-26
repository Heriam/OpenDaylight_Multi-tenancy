package driver.vtndatamodel;

import com.owlike.genson.annotation.JsonProperty;
import org.json.JSONObject;

/**
 * Created by Hao on 2/26/16.
 */
public class Destination extends JSONObject implements Serializable {

    private String terminal;

    @JsonProperty(value = "interface")
    private String Interface;

    public Destination(){}
    public Destination(String terminal, String Interface){
        this.terminal = terminal;
        this.Interface = Interface;
    }



    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getInterface() {
        return Interface;
    }

    public void setInterface(String anInterface) {
        Interface = anInterface;
    }


    @Override
    public String toString() {
        return "Destination{" +
                "terminal='" + terminal + '\'' +
                ", Interface='" + Interface + '\'' +
                '}';
    }
}
