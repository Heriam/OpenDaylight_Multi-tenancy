package test;

import driver.IMessagable;
import driver.Requester;
import driver.vtndatamodel.*;

public class Requests{

    public static void main(String[] args) {


//      Create a client for a tenant
          Requester req = new Requester();


//      Define a VTN Data
          IMessagable vtnHao = new VTNInfo("Tenant_Hao", "300","0");
          vtnHao.setURL("controller/nb/v2/vtn/default/vtns/");
          vtnHao.setAuth("Basic YWRtaW46YWRtaW4=");
//          req.Post(vtnHao);
          System.out.println(req.Get(vtnHao).getEntity(VTNList.class));


//      Define a Bridge Data
          IMessagable br1Hao = new BridgeInfo("bridge1", "600");
          br1Hao.setAuth("Basic YWRtaW46YWRtaW4=");
          br1Hao.setURL("controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3");
//          req.Post(br1Hao);
          System.out.println(req.Get(br1Hao).getEntity(BridgeInfo.class));


//      Define a Interface Data
          IMessagable int1Br1 = new InterfaceInfo("int1", true);
          int1Br1.setAuth("Basic YWRtaW46YWRtaW4=");
          int1Br1.setURL("controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3/interfaces/int1");
//          req.Post(int1Br1);
          System.out.println(req.Get(int1Br1).getEntity(InterfaceInfo.class));


//      Set vlan mapping: map vlan100 of Switch 3 to Virtual Bridge
          IMessagable vlanMapBr1_100 = new VlanMapInfo("Br1", "100", new TypeIdInfo("3"));
          vlanMapBr1_100.setAuth("Basic YWRtaW46YWRtaW4=");
          vlanMapBr1_100.setURL("controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3/vlanmaps");
//          req.Post(vlanMapBr1_100);
          System.out.println(req.Get(vlanMapBr1_100).getEntity(VlanMapList.class));


//      Set port mapping: vlan 120 port 3 of switch 3 ---> vbridge1 int1
          IMessagable vlan120_s3eth3 = new PortMapInfo("120", new TypeIdInfo("3"), new PortMap_portInfo("s3-eth3", "3"));
          vlan120_s3eth3.setAuth("Basic YWRtaW46YWRtaW4=");
          vlan120_s3eth3.setURL("controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3/interfaces/int1/portmap");
          req.Put(vlan120_s3eth3);
          System.out.println(req.Get(vlan120_s3eth3).getEntity(PortMapInfo.class));


//      Set Mac mapping
          IMessagable macMap = new MacMapInfo();
          macMap.setAuth("Basic YWRtaW46YWRtaW4=");
          macMap.setURL("controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge1/macmap");
//          req.Put(macMap);
          System.out.println(req.Get(macMap).getEntity(MacMapInfo.class));
    }
}
