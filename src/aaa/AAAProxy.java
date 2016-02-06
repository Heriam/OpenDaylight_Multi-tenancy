package aaa;

import com.sun.jersey.api.client.ClientResponse;
import driver.IMappable;
import driver.MappableMsg;
import driver.ODLDriver;
import driver.aaadatamodel.RoleInfo;
import driver.aaadatamodel.RoleList;
import org.json.JSONArray;

/**
 * Created by Hao on 2/6/16.
 */
public class AAAProxy extends AAA{
    public boolean isAuthorized(IMappable request) {



        return AuthService(request);

    }

//  Verify if a specific service is granted to a Tenant/Domain/VTN
    private boolean AuthService(IMappable request) {
        String domainID = request.getDomainID();
        String servID = request.getServID();

        IMappable serviceReq = new MappableMsg(null, authUrl+domainID+"/policies/"+servID, adminAuth);

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
    }

//  Verify if a user is granted to do a specific CRED operation
    private boolean AuthMethod(IMappable request){
        String dommainID = request.getDomainID();
        int userID = request.getUserID();
        String method = request.getMsgType();

        IMappable roleReq = new MappableMsg(null, domainUrl + dommainID + "/users/" + userID + "/roles/", adminAuth);

        try{
            RoleList roleList = ODLDriver.Get(roleReq).getEntity(RoleList.class);
            for (  RoleInfo role  :roleList.getRoles()) {
                if((role.getRoleid()>=3)
            }

        } catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }

        return false;
    }


}
