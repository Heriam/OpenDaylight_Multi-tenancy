package aaa;

import aaa.IAAAServ.IAuthorizable;
import driver.IMappable;
import driver.aaadatamodel.PolicyInfo;
import driver.aaadatamodel.RoleInfo;

import java.util.ArrayList;

/**
 * Created by Hao on 2/7/16.
 * Service profile is domain Specific
 * Verify if a specific service is granted to a Tenant/Domain/VTN
 * Verify if the role of user is authorized to do so.
 */
public class ServMgr extends AuthZ implements IAuthorizable.IverifyServ {

     public boolean canUseServ(IMappable request) {
        String requiredRole;
        ArrayList<PolicyInfo> policyList = listPolicybyDomain(request);
        ArrayList<RoleInfo> roleList = listRolebyUser(request);

        if(((policyList==null)||(policyList.isEmpty())||(roleList==null))) {
            return false;
        }

        for(PolicyInfo policy : policyList){
            if(policy.getService().equals(request.getServID())){
                for(RoleInfo role : roleList){
                    if(role.getName().equals(policy.getRole())){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
