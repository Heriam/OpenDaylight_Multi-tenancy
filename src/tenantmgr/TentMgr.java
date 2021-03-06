package tenantmgr;


import aaa.IShiro;
import aaa.Shiro;
import aaa.authn.VTNAuthNToken;
import com.sun.jersey.api.client.ClientResponse;
import driver.Mappable;
import driver.ToODL;
import driver.vtndatamodel.Serializable;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.hamcrest.core.Is;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hao on 2/18/16.
 */
public class TentMgr extends Mapper implements VTNServ{

    private static final Logger log = LoggerFactory.getLogger(TentMgr.class);
    private static Subject currentSubject;
    public TentMgr(){
        super();
    }

    @Override
    public VTNAuthNToken loginReq(String username, String password) throws AuthenticationException{
        VTNAuthNToken token = Mapper.getToken(username,password);
        if (token==null){
            throw new AuthenticationException("Authentication Failure: User is not Regiestered in System");
        }
        try{
            log.info("~~~~~~~~AAA Authentication: "+username+" : "+password);
            currentSubject = IShiro.New().getLoginedUser(token);
            currentSubject.getSession().setAttribute("domainID", token.getDomainId());
            return token;
        } catch (RuntimeException e){
            throw new AuthenticationException("Authentication Failure: User is not Regiestered");
        }
    }


    @Override
    public void logoutReq(VTNAuthNToken token) throws AuthenticationException{
        if (currentSubject!=null && currentSubject.isAuthenticated())
            currentSubject.logout();
//        } else {
//            throw new AuthenticationException("Current User is not logined");
//        }
    }

    @Override
    public Serializable getResponse(Mappable request){
        if (currentSubject.isAuthenticated())currentSubject.logout();
        currentSubject.login(request.getToken());
        String servRequest = request.getServID()+":"+request.getMsgType();
        log.info("~~~~~~~~~~AAA Authorization: "+request);
        if(currentSubject.isPermitted(servRequest)) {
            Mappable mappedReq = Mapper.mapReq(request);
            return ToODL.Send(mappedReq);
        } else{
            throw new AuthorizationException("Authorization Failure : Requested Service is Not Permitted");
        }
    }



}
