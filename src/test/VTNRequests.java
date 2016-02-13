package test;


import aaa.IShiro;
import aaa.realms.VTNAuthNToken;
import driver.Mappable;
import driver.MappableMsg;

import java.util.ArrayList;
import java.util.List;

public class VTNRequests {

    public static void main(String[] args) {
          String admin = "admin";
          String t1 = "tenant1";
          String t2 = "tenant2";
          String g1 = "guest1";
          String g2 = "guest2";

          String s1 = "vtn:topo:create";
          String s2 = "vtn:topo:read";
          String s3 = "vtn:topo:update";
          String s4 = "vtn:topo:delete";

          String s5 = "sys:vtn:create";
          String s6 = "sys:vtn:read";
          String s7 = "sys:vtn:update";
          String s8 = "sys:vtn:delete";

          String s9 = "serv:firewall:create";
          String sa = "serv:firewall:read";
          String sb = "serv:firewall:update";
          String sc = "serv:firewall:delete";


          VTNAuthNToken adminAuth = new VTNAuthNToken(admin, admin, 1);
          VTNAuthNToken t1Auth = new VTNAuthNToken(t1, t1, 1);
          VTNAuthNToken g1Auth = new VTNAuthNToken(g1, g1, 1);
          VTNAuthNToken t2Auth = new VTNAuthNToken(t2, t2, 1);
          VTNAuthNToken g2Auth = new VTNAuthNToken(g2, g2, 1);

          List<VTNAuthNToken> userTokenList = new ArrayList<>();
          userTokenList.add(adminAuth);
          userTokenList.add(t1Auth);
          userTokenList.add(g1Auth);
          userTokenList.add(t2Auth);
          userTokenList.add(g2Auth);

          List<String> servList = new ArrayList<>();
          servList.add(s1);
          servList.add(s2);
          servList.add(s3);
          servList.add(s4);
          servList.add(s5);
          servList.add(s6);
          servList.add(s7);
          servList.add(s8);
          servList.add(s9);
          servList.add(sa);
          servList.add(sb);
          servList.add(sc);


          for (VTNAuthNToken token: userTokenList) {
                System.out.println("---------I AM "+token.getUsername()+", IN DOMAIN "+token.getDomainId()+"----------");
                Mappable adminMsg = new MappableMsg(null,null,token);
                for (String service: servList){
                      adminMsg.setServID(service);
                      if(IShiro.getInstance().isAuthorized(adminMsg)){
                            System.out.println("I HAVE SERVICE: "+service);
                      }
                }
          }




////      Define a Bridge Data
//          Mappable br1Hao = new MappableMsg(new BridgeInfo("bridge1", "600"), "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3", adminAuth);
////          ToODL.Post(br1Hao);
//          System.out.println(ToODL.VTN().Get(br1Hao).getEntity(BridgeInfo.class));
//
//
////      Define a Interface Data
//          Mappable int1Br1 = new MappableMsg(new InterfaceInfo("int1", true), "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3/interfaces/int1", adminAuth);
////          ToODL.Post(int1Br1);
//          System.out.println(ToODL.VTN().Get(int1Br1).getEntity(InterfaceInfo.class));
//
//
////      Set vlan mapping: map vlan100 of Switch 3 to Virtual Bridge
//          Mappable vlanMapBr1_100 = new MappableMsg(new VlanMapInfo("Br1", "100", new TypeIdInfo("3")), "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3/vlanmaps", adminAuth);
////          ToODL.Post(vlanMapBr1_100);
//          System.out.println(ToODL.VTN().Get(vlanMapBr1_100).getEntity(VlanMapList.class));
//
//
////      Set port mapping: vlan 120 port 3 of switch 3 ---> vbridge1 int1
//          Mappable vlan120_s3eth3 = new MappableMsg(new PortMapInfo("120", new TypeIdInfo("3"), new PortMap_portInfo("s3-eth3", "3")),
//                  "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge3/interfaces/int1/portmap",
//                  adminAuth);
//          ToODL.VTN().Put(vlan120_s3eth3);
//          System.out.println(ToODL.VTN().Get(vlan120_s3eth3).getEntity(PortMapInfo.class));
//
//
////      Set Mac mapping
//          Mappable macMap = new MappableMsg(new MacMapInfo(), "controller/nb/v2/vtn/default/vtns/Tenant_Hao/vbridges/bridge1/macmap", adminAuth);
////          ToODL.Put(macMap);
//          System.out.println(ToODL.VTN().Get(macMap).getEntity(MacMapInfo.class));




    }
      public static List<String> getNull() {
            return null;
      }
}
