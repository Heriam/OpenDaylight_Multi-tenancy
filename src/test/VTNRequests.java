package test;

import driver.IMessagable;
import driver.Message;
import driver.Requester;
import driver.vtndatamodel.*;

public class VTNRequests {

    public static void main(String[] args) {

          String userAdmin = "admin";
          String pswdAdmin = "admin";

          String usernameAndPassword = userAdmin + ":" + pswdAdmin;
          String adminAuth = "Basic " + java.util.Base64.getEncoder().encodeToString( usernameAndPassword.getBytes());


//      Create a client for a tenant
          Requester req = new Requester();


//      Define a VTN Data
          IMessagable vtnHao = new Message(new VTNInfo("Vt", "300","0"), "controller/nb/v2/vtn/default/vtns/Vt", adminAuth);
//          req.Post(vtnHao);
          System.out.println(req.Get(vtnHao).getEntity(VTNInfo.class));


//      Define a Bridge Data
          IMessagable br1Hao = new Message(new BridgeInfo("bridge1", "600"), "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3", adminAuth);
//          req.Post(br1Hao);
          System.out.println(req.Get(br1Hao).getEntity(BridgeInfo.class));


//      Define a Interface Data
          IMessagable int1Br1 = new Message(new InterfaceInfo("int1", true), "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3/interfaces/int1", adminAuth);
//          req.Post(int1Br1);
          System.out.println(req.Get(int1Br1).getEntity(InterfaceInfo.class));


//      Set vlan mapping: map vlan100 of Switch 3 to Virtual Bridge
          IMessagable vlanMapBr1_100 = new Message(new VlanMapInfo("Br1", "100", new TypeIdInfo("3")), "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3/vlanmaps", adminAuth);
//          req.Post(vlanMapBr1_100);
          System.out.println(req.Get(vlanMapBr1_100).getEntity(VlanMapList.class));


//      Set port mapping: vlan 120 port 3 of switch 3 ---> vbridge1 int1
          IMessagable vlan120_s3eth3 = new Message(new PortMapInfo("120", new TypeIdInfo("3"), new PortMap_portInfo("s3-eth3", "3")),
                  "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3/interfaces/int1/portmap",
                  adminAuth);
          req.Put(vlan120_s3eth3);
          System.out.println(req.Get(vlan120_s3eth3).getEntity(PortMapInfo.class));


//      Set Mac mapping
          IMessagable macMap = new Message(new MacMapInfo(), "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge1/macmap", adminAuth);
//          req.Put(macMap);
          System.out.println(req.Get(macMap).getEntity(MacMapInfo.class));
    }
}
