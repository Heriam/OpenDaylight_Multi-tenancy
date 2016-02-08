package aaa;

import com.sun.jersey.api.client.ClientResponse;
import driver.IMappable;
import driver.MappableMsg;
import driver.ODLDriver;
import driver.aaadatamodel.DomainPolicyList;
import driver.aaadatamodel.PolicyInfo;
import driver.aaadatamodel.RoleInfo;
import driver.aaadatamodel.RoleList;

import java.util.ArrayList;
import java.util.Base64;

/**
 * Created by Hao on 2/7/16.
 */
public abstract class AuthZ {

    private static String userAdmin = "admin";
    private static String pswdAdmin = "admin";
    private static String usernameAndPassword = userAdmin + ":" + pswdAdmin;
    private static String adminAuth = "Basic " + Base64.getEncoder().encodeToString( usernameAndPassword.getBytes());

    static final int ADMINROLE = 1;
    static final int TENANTROLE = 2;
    static final int GUESTROLE = 3;
    static final int VISITORROLE = 4;

    static final String AAAPORT = "8181";

    public static final String servUrl = "restconf/config/authorization-schema:domain-authorization/domains/";
    public static final String domainUrl = "auth/v1/domains/";
    public static final String roleUrl = "auth/v1/roles/";
    public static final String userUrl = "auth/v1/users/";
    public static final String vtnUrl = "controller/nb/v2/vtn/default/vtns/";
    public static final String allUrl = "";

    public static final String GET = "Get";
    public static final String PUT = "Put";
    public static final String POST = "Post";
    public static final String DELETE = "Delete";


    public  static ArrayList<RoleInfo> listRolebyUser(IMappable request) {
        try{
            String[] userDomainPair = request.getUserID().split(":");
            if(userDomainPair.length>2) {
                throw new RuntimeException("Failed : Userid field not match");
            }
            String domainID = userDomainPair[1];
            String userID = userDomainPair[0];

            IMappable roleReq = new MappableMsg(null, domainUrl + domainID + "/users/" + userID + "/roles/", adminAuth);

            ClientResponse response = ODLDriver.Get(roleReq);
            if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
                throw new RuntimeException("Authorization Failed, Error " + response.getStatus() + ": Invalid UserID");
            }

            RoleList roleList = response.getEntity(RoleList.class);
            return roleList.getRoles();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<PolicyInfo> listPolicybyDomain(IMappable request) {
        try{
            String[] userDomainPair = request.getUserID().split(":");
            if(userDomainPair.length>2){
                throw new RuntimeException("Failed : Userid field not match");
            }
            String domainID = userDomainPair[1];

            IMappable servReq = new MappableMsg(null, servUrl + domainID, adminAuth);

            ClientResponse response = ODLDriver.Get(servReq);
            if (!(response.getStatus() == 201 || response.getStatus() == 200)) {
                throw new RuntimeException("Authorization Failed, Error " + response.getStatus() + ": Invalid DomainID");
            }
            DomainPolicyList domainPolicyList = response.getEntity(DomainPolicyList.class);
            return domainPolicyList.getDomains().get(0).getPolicies();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
