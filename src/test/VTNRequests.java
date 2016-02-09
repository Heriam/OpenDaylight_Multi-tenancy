package test;

import aaa.authz.AuthZ;
import driver.Mappable;
import driver.MappableMsg;
import driver.ToODL;
import driver.vtndatamodel.*;

import java.util.Base64;
import java.util.List;

public class VTNRequests {

    public static void main(String[] args) {

          String userAdmin = "admin";
          String pswdAdmin = "admin";

          String usernameAndPassword = userAdmin + ":" + pswdAdmin;
          String adminAuth = "Basic " + Base64.getEncoder().encodeToString( usernameAndPassword.getBytes());
          System.out.println(adminAuth);


//      Define a VTN Data
          Mappable vtnHao = new MappableMsg(new VTNInfo("Tenant_esd", "300","0"), "auth/v1/users/", adminAuth);
          vtnHao.setServID("Create");
          vtnHao.setMsgType("Get");
          vtnHao.setUserID("3:1");
 //         ToODL.VTN().Post(vtnHao);
          System.out.println(vtnHao.getUserID() + " " + vtnHao.getMsgType() + " " + vtnHao.getURL()+ ": " + AuthZ.editRsrc(vtnHao));
          System.out.println(vtnHao.getUserID() + " VTN Service " + vtnHao.getServID() + ": " + AuthZ.useServ(vtnHao));
          System.out.println("Authorization Result: " + AuthZ.fullAuth(vtnHao));

//          System.out.println(getNull().contains("1"));
//          System.out.println(ToODL.Get(vtnHao).getEntity(VTNInfo.class));


//      Define a Bridge Data
          Mappable br1Hao = new MappableMsg(new BridgeInfo("bridge1", "600"), "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3", adminAuth);
//          ToODL.Post(br1Hao);
          System.out.println(ToODL.VTN().Get(br1Hao).getEntity(BridgeInfo.class));


//      Define a Interface Data
          Mappable int1Br1 = new MappableMsg(new InterfaceInfo("int1", true), "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3/interfaces/int1", adminAuth);
//          ToODL.Post(int1Br1);
          System.out.println(ToODL.VTN().Get(int1Br1).getEntity(InterfaceInfo.class));


//      Set vlan mapping: map vlan100 of Switch 3 to Virtual Bridge
          Mappable vlanMapBr1_100 = new MappableMsg(new VlanMapInfo("Br1", "100", new TypeIdInfo("3")), "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3/vlanmaps", adminAuth);
//          ToODL.Post(vlanMapBr1_100);
          System.out.println(ToODL.VTN().Get(vlanMapBr1_100).getEntity(VlanMapList.class));


//      Set port mapping: vlan 120 port 3 of switch 3 ---> vbridge1 int1
          Mappable vlan120_s3eth3 = new MappableMsg(new PortMapInfo("120", new TypeIdInfo("3"), new PortMap_portInfo("s3-eth3", "3")),
                  "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3/interfaces/int1/portmap",
                  adminAuth);
          ToODL.VTN().Put(vlan120_s3eth3);
          System.out.println(ToODL.VTN().Get(vlan120_s3eth3).getEntity(PortMapInfo.class));


//      Set Mac mapping
          Mappable macMap = new MappableMsg(new MacMapInfo(), "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge1/macmap", adminAuth);
//          ToODL.Put(macMap);
          System.out.println(ToODL.VTN().Get(macMap).getEntity(MacMapInfo.class));




    }
      public static List<String> getNull() {
            return null;
      }
}
