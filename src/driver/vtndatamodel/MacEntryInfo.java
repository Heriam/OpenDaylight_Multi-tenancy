package driver.vtndatamodel;

import org.json.JSONObject;

/**
 *
 * ####   Waiting for Test   ####
 *
 * Created by Hao on 2/5/16.
 *
 * This section describes the data that shows the MAC address information learned in MAC address table of vBridge.
 * macentry shows the MAC address information learned inside [OpenDaylight_Virtual_Tenant_Network_(VTN):VTN_Manager:Specification#vBridge.macTable|MAC address table]].
 * This is used to return MAC address information inside MAC address table to REST client.
 *
 * Meaning of each attribute is as follows.

 address
     String showing the learned MAC address gets configured.
     String wherein hexadecimal notation of each octet inside MAC address are concatenated by ':' gets configured.
 vlan
     VLAN ID configured inside the Ethernet frame, where MAC address is detected, gets configured.
     0 implies that VLAN tag was not detected.

 Element node shows the Node information corresponding to switch where MAC address is detected.
   Meaning of elements inside node is as follows.
     type
          String showing the type of `Node` gets configured.
         OF gets configured for OpenFlow switches.
     id
         String showing the identifier of Node gets configured.
         String representation of DPID gets configured for OpenFlow switches.

 Element port shows the NodeConnector information corresponding to physical port of switch where MAC address is detected.
   Meaning of attributes of element port is as follows.
     type
         String showing the type of NodeConnector gets configured.
          OF gets configured for OpenFlow switches.
     id
          String showing the identifier of NodeConnector gets configured.
          String representation of port number gets configured for OpenFlow switches.

 Element inetAddresses shows the IP address information configured in the Ethernet frame where MAC address was detected.

 If multiple IP address corresponding to MAC address are detected, then the information for all the IP addresses that were detected gets configured.
 If no IP address is detected, element inetAddresses is omitted.
 One or more than one inetAddress elements are configured inside the element inetAddresses. String representation of the detected IP address gets configured in the attribute address of each inetAddress element.
 *
 *
 */
public class MacEntryInfo extends JSONObject {


    private String address;
    private String vlan;
    private TypeIdInfo node;
    private TypeIdInfo port;
    private MacListInfo inetAddresses;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public TypeIdInfo getPort() {
        return port;
    }

    public void setPort(TypeIdInfo port) {
        this.port = port;
    }

    public MacListInfo getInetAddresses() {
        return inetAddresses;
    }

    public void setInetAddresses(MacListInfo inetAddresses) {
        this.inetAddresses = inetAddresses;
    }

    @Override
    public String toString() {
        return "{" +
                "\"address\":\"" + address + '\"' +
                "\"vlan\":\"" + vlan + '\"' +
                ", \"node\":" + node +
                ", \"port\":" + port +
                ", \"inetAddresses\":" + inetAddresses +
                '}';
    }

}
