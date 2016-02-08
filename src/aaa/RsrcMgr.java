package aaa;

import aaa.IAAAServ.IAuthorizable;
import driver.IMappable;
import driver.aaadatamodel.RoleInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hao on 2/7/16.
 * Operation authorization is role specific
 * Verify if a user is granted with the role to do a specific CRED operation on a specific resource.
 */
public class RsrcMgr extends AuthZ implements IAuthorizable.IverifyRsrc{

        List<String> allOperation;
        List<String> allPath;

    public RsrcMgr() {
        allOperation = new ArrayList<>();
        allOperation.add(GET);//0      GUEST 3, VISITOR 4
        allOperation.add(PUT);//1
        allOperation.add(POST);//2
        allOperation.add(DELETE);//3   TENANT 2, ADMIN 1

        allPath = new ArrayList<>();
        allPath.add(vtnUrl); //0     VISITOR 4
        allPath.add(servUrl);  //1
        allPath.add(domainUrl);  //2   TENANT  2
        allPath.add(roleUrl);  //3
        allPath.add(userUrl);  //4   GUEST 3
        allPath.add(allUrl);  //5    ADMIN 1
    }

    @Override
    public boolean canOperaonRsrc(IMappable request){
        String method = request.getMsgType();
        String requestedUrl = request.getURL();
        ArrayList<RoleInfo> roleList = listRolebyUser(request);
        if(roleList!=null){

            if(roleList.isEmpty()){
                if(isAllowedtoDoonUrl(VISITORROLE, method, requestedUrl)){
                    return true;
                }
            } else{
                for (  RoleInfo role  : roleList) {
                    if(isAllowedtoDoonUrl(role.getRoleid(), method, requestedUrl)){
                        return true;
                    }
                }
            }
        }
        return false;
    }


//  verify if a role is allowed to do the requested Operation on the requested URL
    private boolean isAllowedtoDoonUrl(int roleID, String requestMethod, String requestUrl) {

        List<String> roleOpera = getRoleOperation(roleID);
        List<String> roleUrl = getRoleUrl(roleID);
        if((roleOpera!=null && roleUrl!=null)){
            if (roleOpera.contains(requestMethod)) {
                for (String allowedUrl : roleUrl) {
                    if (requestUrl.startsWith(allowedUrl)) {
                        return true;
                }
            }
            return false;
        }}
        return false;
    }

//  get a list of allowed operation according to roleID
    private List<String> getRoleOperation(int roleID){
        switch(roleID){
            case ADMINROLE:
            case TENANTROLE:
                return allOperation;
            case GUESTROLE:
            case VISITORROLE:
                return allOperation.subList(0, 1);
            default:
                return null;
        }
    }
    
//  get a list of allowed url according to roleID
    private List<String> getRoleUrl(int roleID){
        switch(roleID){
            case ADMINROLE:
                return allPath;
            case GUESTROLE:
                return allPath.subList(0, allPath.size()-1);
            case TENANTROLE:
                return allPath.subList(0, 3);
            case VISITORROLE:
                return allPath.subList(0, 1);
            default:
                return null;
        }
    }

    public List<String> getAllOperation() {
        return allOperation;
    }

    public void setAllOperation(List<String> allOperation) {
        this.allOperation = allOperation;
    }

    public List<String> getAllPath() {
        return allPath;
    }

    public void setAllPath(List<String> allPath) {
        this.allPath = allPath;
    }
}
