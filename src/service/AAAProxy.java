package service;

import com.sun.jersey.api.client.ClientResponse;
import driver.IMappable;
import driver.MappableMsg;
import driver.ODLDriver;
import tenant.Tenant;

import java.util.Base64;

/**
 * Created by Hao on 2/6/16.
 */
public class AAAProxy implements IAuthorizable{

    private String userAdmin = "admin";
    private String pswdAdmin = "admin";
    private String usernameAndPassword = userAdmin + ":" + pswdAdmin;
    private String adminAuth = "Basic " + Base64.getEncoder().encodeToString( usernameAndPassword.getBytes());
    private String authUrl = "restconf/config/authorization-schema:domain-authorization/domains/";
    private String domainUrl = "auth/v1/domains/";
    private String roleUrl = "auth/v1/roles/";
    private String userUrl = "auth/v1/roles/";







    public boolean isAuthorized(IMappable request) {
        String requestPath = request.getURL();
        String domainID = request.getDomainID();
        String auth = request.getAuth();
        String msgType = request.getMsgType();
        String servType = request.getServID();

        switch (servType){
            case CREATE:
                IMappable serviceReq = new MappableMsg(null, authUrl+domainID+"/policies/"+servType, adminAuth);
                try{
                    ClientResponse response = ODLDriver.Get(serviceReq);
                    int status = response.getStatus();
                    if (status==200){
                        return true;}
                    else if(status==404){
                        return false;}
                    else {
                        throw new RuntimeException("Failed : HTTP error " + status + ": " + response.getEntity(String.class));

                    }} catch (RuntimeException e){
                        e.printStackTrace();
                    return false;
                }

            case CREDTOPO:



        }

        return false;
    }


    public int getPriority(Tenant tenant) {
        return 0;
    }


}

