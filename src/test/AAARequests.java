package test;


import driver.IMappable;
import driver.MappableMsg;
import driver.ODLDriver;
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
        IMappable userJue = new MappableMsg(new UserInfo("hao.jiang", "931026"), "auth/v1/users", adminAuth);
//        ODLDriver.Post(userJue);
        System.out.println(ODLDriver.Get(userJue).getEntity(UserList.class));


        //Create a Domain
        IMappable domainJue = new MappableMsg(new DomainInfo("hao.jiang"), "auth/v1/domains", adminAuth);
//        ODLDriver.Post(domainJue);
        System.out.println(ODLDriver.Get(domainJue).getEntity(DomainList.class));


        //Create a Role
        IMappable rolePartner = new MappableMsg(new RoleInfo("Partner", "Partner role"), "auth/v1/roles", adminAuth);
//        ODLDriver.Post(rolePartner);
        System.out.println(ODLDriver.Get(rolePartner).getEntity(RoleList.class));

        IMappable servRestConf = new MappableMsg(new PolicyInfo("admin", "*", "RestConfService"),
                                               "/restconf/config/authorization-schema:simple-authorization/policies/RestConfService",
                                               adminAuth);
//        ODLDriver.Put(servRestConf);
        System.out.println(ODLDriver.Get(servRestConf).getEntity(PolicyList.class));




    }
}
