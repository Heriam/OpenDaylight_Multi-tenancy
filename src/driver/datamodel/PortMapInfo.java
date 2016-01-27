package driver.datamodel;


import org.json.JSONObject;

/**
 * Created by Hao on 1/13/16.
 */
public class PortMapInfo extends JSONObject{
    private String vlan;
    private TypeIdInfo node;
    private TypeIdInfo mapped;
    private PortMap_portInfo port;

    public PortMapInfo(){}
    public PortMapInfo (String vlan, TypeIdInfo node, PortMap_portInfo port){
        this.vlan = vlan;
        this.node = node;
        this.port = port;
    }

    public String getVlan() {
        return vlan;
    }

    public void setVlan(String vlan) {
        this.vlan = vlan;
    }

    public TypeIdInfo getNode() {
        return node;
    }

    public void setNode(TypeIdInfo node) {
        this.node = node;
    }

    public TypeIdInfo getMapped() {
        return mapped;
    }

    public void setMapped(TypeIdInfo mapped) {
        this.mapped = mapped;
    }

    public PortMap_portInfo getPort() {
        return port;
    }

    public void setPort(PortMap_portInfo port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "{" +
                "\"vlan\":\"" + vlan + '\"' +
                ", \"node\":" + node +
                ", \"port\":" + port +
                ", \"mapped\":" + mapped +
                '}';
    }
}
