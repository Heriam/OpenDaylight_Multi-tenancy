package test;

import driver.Requester;
import driver.datamodel.*;

public class Requests{

    public static void main(String[] args) {

//      Create a client for a tenant
          Requester req = new Requester("8282/controller/nb/v2/vtn/default/vtns");


//      Define a VTN Data
          VTNInfo vtnHao = new VTNInfo("Tenant_Hao", "300","0");
//        req.Post(vtnHao,vtnHao.getName());
          System.out.println(req.Get("").getEntity(VTNList.class));


//      Define a Bridge Data
          BridgeInfo br1Hao = new BridgeInfo("bridge1", "600");
//        req.Post(br1Hao, vtnHao.getName()+"/vbridges/"+br1Hao.getName());
          System.out.println(req.Get(vtnHao.getName()+"/vbridges").getEntity(BridgeList.class));


//      Define a Interface Data
          InterfaceInfo int1Br1 = new InterfaceInfo("int1", true);
//        req.Post(int1Br1, vtnHao.getName()+"/vbridges/"+br1Hao.getName()+"/interfaces/"+int1Br1.getName());
          System.out.println(req.Get(vtnHao.getName()+"/vbridges/"+br1Hao.getName()+"/interfaces").getEntity(InterfaceList.class));


//      Set vlan mapping: map vlan100 of Switch 3 to Virtual Bridge
          VlanMapInfo vlanMapBr1_100 = new VlanMapInfo("Br1", "100", new TypeIdInfo("3"));
//        req.Post(vlanMapBr1_100, vtnHao.getName()+"/vbridges/"+br1Hao.getName()+"/vlanmaps");
          System.out.println(req.Get(vtnHao.getName()+"/vbridges/"+br1Hao.getName()+"/vlanmaps").getEntity(VlanMapList.class));


//      Set port mapping: vlan 120 port 3 of switch 3 ---> vbridge1 int1
          PortMapInfo vlan120_s3eth3 = new PortMapInfo("120", new TypeIdInfo("3"), new PortMap_portInfo("s3-eth3", "3"));
          req.Put(vlan120_s3eth3, vtnHao.getName()+"/vbridges/"+br1Hao.getName()+"/interfaces/"+int1Br1.getName()+"/portmap");
          System.out.println(req.Get(vtnHao.getName()+"/vbridges/"+br1Hao.getName()+"/interfaces/"+int1Br1.getName()+"/portmap").getEntity(PortMapInfo.class));


//      Set Mac mapping
          MacInfo allowMac1 = new MacInfo("f6:e3:28:04:37:3f", 0);
          MacInfo allowMac2 = new MacInfo("6a:ed:f9:9c:b8:5c", 0);
          MacHostInfo macHostInfo = new MacHostInfo();
          macHostInfo.addMachost(allowMac1);
          macHostInfo.addMachost(allowMac2);
          macHostInfo.getMachost().add(allowMac2);
          req.Put(macHostInfo, vtnHao.getName()+"/vbridges/"+br1Hao.getName()+"macmap/allow");

    }
}
