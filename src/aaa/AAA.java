package aaa;


import java.util.Base64;

/**
 * Created by Hao on 2/6/16.
 */
public abstract class AAA implements IAuthorizable{

    private String userAdmin = "admin";
    private String pswdAdmin = "admin";
    private String usernameAndPassword = userAdmin + ":" + pswdAdmin;
    String adminAuth = "Basic " + Base64.getEncoder().encodeToString( usernameAndPassword.getBytes());
    static String authUrl = "restconf/config/authorization-schema:domain-authorization/domains/";
    static String domainUrl = "auth/v1/domains/";
    static String roleUrl = "auth/v1/roles/";
    static String userUrl = "auth/v1/roles/";
    static String vtnUrl = "controller/nb/v2/vtn/default/vtns/";
}

