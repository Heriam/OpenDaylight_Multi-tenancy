package driver.vtndatamodel;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 *
 * ####   Waiting for Test   #####
 *
 * Created by Hao on 2/5/16.
 *
 * vBridge internally stores MAC address table. MAC address table stores the following information for each MAC address.

 Port of the physical switch where MAC address is detected
 VLAN ID inside the Ethernet frame
 Following information gets stored in the MAC address table when an input is detected from the physical network mapped to vBridge.

 Source MAC address of Ethernet frame
 Port of the physical switch that received Ethernet frame
 VLAN ID inside the Ethernet frame
 Further, if source MAC address information of Ethernet frame is registered in the MAC address table, and the physical switch port that received the Ethernet frame and VLAN ID is different from the information in MAC address table, then the information inside MAC address table is updated to the information of the received Ethernet frame.

 If a unicast packet is sent to vBridge and that packet is notified to OpenFlow controller, then VTN Manager checks that whether the destination MAC address is registered in the MAC address table. Following flow entry is configured on the related physical switches only when it is registered.

 VLAN ID inside Ethernet frame is overwritten with the VLAN ID stored inside the MAC address table.
 Route to port of the physical switch, which is stored inside MAC address table, is configured on each switch.
 If the destination MAC address is not stored inside the MAC address table, then this Ethernet frame is sent to all the physical networks mapped to vBridge.

 VLAN ID can be overwritten according to the setting of Port mapping and VLAN mapping.
 Only destination MAC address is used as the search key while searching inside MAC address table. Thus, it is necessary to configure vBridge in such a manner that Ethernet frames that have the same MAC address as the source address and different VLAN IDs configured do not flow to the same vBridge.

 For example, let us assume that the following vBridge and network devices are configured.

 Create a vBridge with the name bridge-1 and map VLAN ID 1 and 2 by using VLAN mapping.
 Configure A:1 and A:2 alias for network interface of host having the MAC address A, and allocate VLAN ID 1 and 2 to each of the aliases.
 If the above configurations are done, then Ethernet frames that have the source MAC address A and different VLAN IDs will be treated as an input of bridge-1.

 When data is sent from alias A:1, then Ethernet frames that have source MAC address as A and VLAN ID 1 will be input to bridge-1.
 When data is sent from alias A:2, then Ethernet frames that have source MAC address as A and VLAN ID 2 will be input to bridge-1.
 The behavior is not defined if the vBridge is configured in the above manner.
 *
 */
public class MacEntryList extends JSONObject{



    ArrayList<MacEntryInfo> macentry;

    public ArrayList<MacEntryInfo> getMacentry() {
        return macentry;
    }

    public void setMacentry(ArrayList<MacEntryInfo> macentry) {
        this.macentry = macentry;
    }

    public String toString() {
        return "{\"macentry\":"+macentry+"}";
    }

}
