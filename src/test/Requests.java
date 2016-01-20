package test;

import driver.Requester;
import driver.datamodel.*;

public class Requests{

    public static void main(String[] args) {



//      Define a VTN Data
        VTNInfo vtnHao = new VTNInfo("Tenant_Hao", "300","0");

//      Define a Bridge Data
        BridgeInfo br1Hao = new BridgeInfo("Bridge1", "600");

//      Set vlan mapping: map vlan100 of Switch 3 to Virtual Bridge
        VlanMapInfo vlanMapBr1_100 = new VlanMapInfo();
        vlanMapBr1_100.setId("Br1_100");
        vlanMapBr1_100.setVlan("100");
        vlanMapBr1_100.setNode(new TypeIdInfo("OF", "3"));

//

//      Create a client for a tenant
        Requester req = new Requester("8282/controller/nb/v2/vtn/default/vtns");
//        req.Post(vtnHao,vtnHao.getName());
          req.Post(br1Hao,br1Hao.getName());


//        req.Put(vlanMap, "/default/vtns/Tenant_Hao/vbridges/bridge1/");
//          System.out.println(req.Get("").getEntity(VTNList.class));
//        System.out.println(req.Get("/default/vtns/Tenant_Hao/vbridges").getEntity(BridgeList.class));
//        System.out.println(req.Get("/default/vtns/Tenant_Hao/vbridges/bridge1/interfaces").getEntity(InterfaceList.class));
//        System.out.println(req.Get("/default/vtns/Tenant_Hao/vbridges/bridge1/interfaces/int1/portmap").getEntity(PortMapInfo.class));
    }
}
