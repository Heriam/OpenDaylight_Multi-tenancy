package driver.vtndatamodel;


import org.json.JSONObject;

/**
 * Created by Hao on 1/13/16.
 * portmapconf shows the Port mapping configuration information for vBridge interface.
 * This is used to send configuration information to controller during configuration of Port mapping by REST client.
 * Meaning of each attribute is given below.

 vlan
     Specify the VLAN ID to be mapped by using numerical value.
     Allowed range for value is between 0 or more and 4095 or less.
     0 implies untagged ethernet frame.
     If omitted, it will be treated as if 0 is specified.

 node element shows the Node information corresponding to the switch that is mapped to interface. It is necessary to include one node element in portmapconf.
   Meaning of elements inside node is given below.
     type
         Specify the string showing Node type.
         Specify OF for OpenFlow switch.
     id
         Specify the string showing the identifier of Node.
         Specify the string representation of DPID while specifying OpenFlow switch.

 port element shows the condition for identifying physical ports of the switch specified in the element node. It is necessary to include one node element in portmapconf.
   Meaning of port attributes is given below.
     name
         Show port name of switch.
         It is necessary to specify a character string with 1 or more characters.
         If the attribute name is omitted, then it is necessary to specify both type and id attributes.
     type
         Specify the string that shows the type of NodeConnector.
         Specify OF for physical port of OpenFlow switch.
         It should be specified along with the attribute id.
         If the attribute type is omitted, then it is necessary to specify the attribute name.
     id
         Specify the string representing identifier of NodeConnector.
         Specify the string representation of port number for physical port of OpenFlow switch.
         It should be specified along with the attribute type.
         If the attribute id is omitted, then it is necessary to specify the attribute name.

 Actual physical port of switch that gets mapped to vBridge interface is decided as follows.

 If the attribute name is configured in the element port, then out of the physical ports in the switch specified in the element node,the physical port that has the specified port name will get mapped.
 If the attributes type and id are configured in the element port, then out of the physical ports in the switch specified in the element node, the physical port corresponding to the specified NodeConnector will get mapped.
 If all the attributes are configured in the element port, then out of the physical ports in the switch specified in the element node, the physical port that meets all the condition will get mapped.
 I.e., Port mapping will be enabled only if the specified port name is configured for the specified NodeConnector.


 Details given in the elements node and port of portmapconf, which was specified during port mapping configuration, will get configured in node element and port element respectively.

 mapped element shows the NodeConnector information corresponding to physical port of the switch which is actually mapped. If there are no physical ports that meet the condition mentioned in portmapconf, then the element mapped is omitted.
   Meaning of attributes of the element mapped is as follows.
     type
         String showing the type of NodeConnector gets configured.
         OF is configured in case of OpenFlow switch.
     id
         String showing the identifier of NodeConnector gets configured.
         String representation of port number is configured for OpenFlow switch.

 *
 */
public class PortMapInfo extends JSONObject implements Serializable{
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
