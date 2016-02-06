package test;

import aaa.AAAProxy;
import driver.IMappable;
import driver.MappableMsg;
import driver.ODLDriver;
import driver.vtndatamodel.*;
import aaa.IAuthorizable;

import java.util.Base64;

public class VTNRequests {

    public static void main(String[] args) {

          String userAdmin = "admin";
          String pswdAdmin = "admin";

          String usernameAndPassword = userAdmin + ":" + pswdAdmin;
          String adminAuth = "Basic " + Base64.getEncoder().encodeToString( usernameAndPassword.getBytes());
          System.out.println(adminAuth);




//      Define a VTN Data
          IMappable vtnHao = new MappableMsg(new VTNInfo("Tenant_Hao", "300","0"), "controller/nb/v2/vtn/default/vtns/Tenant_Hao", adminAuth);
          vtnHao.setDomainID("2");
          vtnHao.setServID(IAuthorizable.SERVREQ);
//          ODLDriver.Post(vtnHao);

          IAuthorizable aaaProxy = new AAAProxy();

          System.out.println(aaaProxy.isAuthorized(vtnHao));

          System.out.println(ODLDriver.Get(vtnHao).getEntity(VTNInfo.class));


//      Define a Bridge Data
          IMappable br1Hao = new MappableMsg(new BridgeInfo("bridge1", "600"), "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3", adminAuth);
//          ODLDriver.Post(br1Hao);
          System.out.println(ODLDriver.Get(br1Hao).getEntity(BridgeInfo.class));


//      Define a Interface Data
          IMappable int1Br1 = new MappableMsg(new InterfaceInfo("int1", true), "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3/interfaces/int1", adminAuth);
//          ODLDriver.Post(int1Br1);
          System.out.println(ODLDriver.Get(int1Br1).getEntity(InterfaceInfo.class));


//      Set vlan mapping: map vlan100 of Switch 3 to Virtual Bridge
          IMappable vlanMapBr1_100 = new MappableMsg(new VlanMapInfo("Br1", "100", new TypeIdInfo("3")), "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3/vlanmaps", adminAuth);
//          ODLDriver.Post(vlanMapBr1_100);
          System.out.println(ODLDriver.Get(vlanMapBr1_100).getEntity(VlanMapList.class));


//      Set port mapping: vlan 120 port 3 of switch 3 ---> vbridge1 int1
          IMappable vlan120_s3eth3 = new MappableMsg(new PortMapInfo("120", new TypeIdInfo("3"), new PortMap_portInfo("s3-eth3", "3")),
                  "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3/interfaces/int1/portmap",
                  adminAuth);
          ODLDriver.Put(vlan120_s3eth3);
          System.out.println(ODLDriver.Get(vlan120_s3eth3).getEntity(PortMapInfo.class));


//      Set Mac mapping
          IMappable macMap = new MappableMsg(new MacMapInfo(), "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge1/macmap", adminAuth);
//          ODLDriver.Put(macMap);
          System.out.println(ODLDriver.Get(macMap).getEntity(MacMapInfo.class));
    }
}
