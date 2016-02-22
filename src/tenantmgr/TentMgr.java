package tenantmgr;

import aaa.IShiro;
import aaa.authn.VTNAuthNToken;
import org.apache.shiro.subject.Subject;
import tenantmgr.mapper.IMap;

/**
 * Created by Hao on 2/18/16.
 */
public class TentMgr implements VTNServ{

    IMap mapper = IMap.getMapper();
    Subject userSubject;
    @Override
    public boolean loginReq(String username, String password){
        VTNAuthNToken token = mapper.addDomainID(new VTNAuthNToken(username, password, -1));
        this.userSubject = IShiro.New().userLogin(token);
        if(userSubject==null){
            return false;
        }
        userSubject.getSession().setAttribute("domainID", token.getDomainId());
        return true;
    }


    @Override
    public void logoutReq(){
    }

}
