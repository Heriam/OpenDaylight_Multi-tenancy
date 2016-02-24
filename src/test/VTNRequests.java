package test;



import aaa.IShiro;
import aaa.authn.VTNAuthNToken;
import com.sun.deploy.net.HttpResponse;
import com.sun.jersey.api.client.ClientResponse;
import driver.Mappable;
import driver.MappableMsg;
import driver.ToODL;
import driver.vtndatamodel.BridgeInfo;
import driver.vtndatamodel.Serializable;
import org.apache.shiro.subject.Subject;
import org.json.JSONObject;
import rest.TentProxy;
import tenantmgr.VTNServ;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VTNRequests {


      private static Subject currentUser;

      public static void main(String[] args) throws IOException {




            String admin = "admin";
            String t1 = "tenant1";
            String t2 = "tenant2";
            String g1 = "guest1";
            String g2 = "guest2";
            String boss = "boss";

            String s1 = "vtn:topo:create";
            String s2 = "vtn:topo:read";
            String s3 = "vtn:topo:update";
            String s4 = "vtn:topo:delete";

            String s5 = "system:vtn:create";
            String s6 = "system:vtn:read";
            String s7 = "system:vtn:update";
            String s8 = "system:vtn:delete";

            String s9 = "serv:firewall:create";
            String sa = "serv:firewall:read";
            String sb = "serv:firewall:update";
            String sc = "serv:firewall:delete";


            VTNAuthNToken adminAuth = new VTNAuthNToken(admin, admin, 0);
            VTNAuthNToken t1Auth = new VTNAuthNToken(t1, t1, 1);
            VTNAuthNToken g1Auth = new VTNAuthNToken(g1, g1, 1);
            VTNAuthNToken t2Auth = new VTNAuthNToken(t2, t2, 2);
            VTNAuthNToken g2Auth = new VTNAuthNToken(g2, g2, 2);
            VTNAuthNToken bossAuth = new VTNAuthNToken(boss, boss, 0);

            List<VTNAuthNToken> userTokenList = new ArrayList<>();
            userTokenList.add(adminAuth);
            userTokenList.add(bossAuth);
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

            List<String> authZResult = new ArrayList<>();

            for (VTNAuthNToken token: userTokenList) {
                  currentUser = IShiro.New().getLoginedUser(token);
                  if (currentUser!=null) {
                        for (String service : servList) {
                              if (currentUser.isPermitted(service)) {
                                    String entryAuthZ = "Domain " + token.getDomainId() + ": " + token.getUsername() + ": " + service;
                                    authZResult.add(entryAuthZ);
                              }
                        }
                        currentUser.logout();
                  }

            }


            for (String i: authZResult){
                  System.out.println(i);
            }

//            MappableMsg{body={"hardTimeout":"0","idleTimeout":"300","description":"1"}, URL='1', Auth=null, msgType='create', servID='vtn:topo', option=false, status=0}

            VTNAuthNToken token = VTNServ.getTentMgr().loginReq("admin", "admin");
            String json = null;
            JSONObject jsonObject = (json == null || json.isEmpty()) ? null : new JSONObject(json);
            Mappable request = new MappableMsg(jsonObject, "tenant1", token);
            request.setMsgType("read");
            request.setServID("serv:firewall");

            TentProxy tentProxy = new TentProxy();
            Serializable response = VTNServ.getTentMgr().getResponse(request);
            System.out.println(response.toString());










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
}
