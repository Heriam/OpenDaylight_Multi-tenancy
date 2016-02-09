package test;


import driver.Mappable;
import driver.MappableMsg;
import driver.ToODL;
import driver.aaadatamodel.*;

import java.util.Base64;


/**
 * Created by Hao on 2/5/16.
 */
public class AAARequests {
    public static void main(String[] args) {

        String userAdmin = "admin";
        String pswdAdmin = "admin";

        String usernameAndPassword = userAdmin + ":" + pswdAdmin;
        String adminAuth = "Basic " + Base64.getEncoder().encodeToString( usernameAndPassword.getBytes());


        //Create a User
        Mappable userJue = new MappableMsg(new UserInfo("hao.jiang", "931026"), "auth/v1/users", adminAuth);
//        ToODL.VTN().Post(userJue);
        System.out.println(ToODL.VTN().Get(userJue).getEntity(UserList.class));


        //Create a Domain
        Mappable domainJue = new MappableMsg(new DomainInfo("hao.jiang"), "auth/v1/domains", adminAuth);
//        ToODL.VTN().Post(domainJue);
        System.out.println(ToODL.VTN().Get(domainJue).getEntity(DomainList.class));


        //Create a Role
        Mappable rolePartner = new MappableMsg(new RoleInfo("Partner", "Partner role"), "auth/v1/roles", adminAuth);
//        ToODL.VTN().Post(rolePartner);
        System.out.println(ToODL.VTN().Get(rolePartner).getEntity(RoleList.class));

        Mappable servRestConf = new MappableMsg(new PolicyInfo("admin", "*", "RestConfService"),
                                               "/restconf/config/authorization-schema:simple-authorization/policies/RestConfService",
                                               adminAuth);
//        ToODL.VTN().Put(servRestConf);
        System.out.println(ToODL.VTN().Get(servRestConf).getEntity(PolicyList.class));



    }
}
