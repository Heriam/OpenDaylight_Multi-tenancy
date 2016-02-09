package aaa;

import com.sun.jersey.api.client.ClientResponse;
import driver.Mappable;
import driver.MappableMsg;
import driver.ToODL;
import driver.aaadatamodel.DomainPolicyList;
import driver.aaadatamodel.PolicyInfo;
import driver.aaadatamodel.RoleInfo;
import driver.aaadatamodel.RoleList;

import java.util.ArrayList;
import java.util.Base64;

/**
 * Created by Hao on 2/7/16.
 */
public abstract class AAA{

    private static final String userAdmin = "admin";
    private static final String pswdAdmin = "admin";
    private static final String usernameAndPassword = userAdmin + ":" + pswdAdmin;
    private static String adminAuth = "Basic " + Base64.getEncoder().encodeToString( usernameAndPassword.getBytes());

    protected static final String GET = "Get";
    protected static final  String PUT = "Put";
    protected static final String POST = "Post";
    protected static final String DELETE = "Delete";

    protected static final int ADMINROLE = 1;
    protected static final int TENANTROLE = 2;
    protected static final int GUESTROLE = 3;
    protected static final int VISITORROLE = 4;

    protected static final String servUrl = "restconf/config/authorization-schema:domain-authorization/domains/";
    protected static final String domainUrl = "auth/v1/domains/";
    protected static final String roleUrl = "auth/v1/roles/";
    protected static final String userUrl = "auth/v1/users/";
    protected static final String vtnUrl = "controller/nb/v2/vtn/default/vtns/";
    protected static final String allUrl = "";

    protected static ArrayList<RoleInfo> listRolebyUser(Mappable request) throws RuntimeException{

            int domainID = Mappable.getDomainID(request);
            int userID = Mappable.getUserID(request);

            Mappable roleReq = new MappableMsg(null, domainUrl + domainID + "/users/" + userID + "/roles/", adminAuth);

            ClientResponse response = ToODL.AAA().Get(roleReq);
            if (response!=null) {
                RoleList roleList = response.getEntity(RoleList.class);
                return roleList.getRoles();
            }
        return null;

    }

    protected static ArrayList<PolicyInfo> listPolicybyDomain(Mappable request) {
            int domainID = Mappable.getDomainID(request);

            Mappable servReq = new MappableMsg(null, servUrl + domainID, adminAuth);

            ClientResponse response = ToODL.AAA().Get(servReq);
            if (response!=null) {
                DomainPolicyList domainPolicyList = response.getEntity(DomainPolicyList.class);
                return domainPolicyList.getDomains().get(0).getPolicies();
            }
        return null;

    }
}
