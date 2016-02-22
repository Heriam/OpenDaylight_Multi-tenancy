package tenantmgr;

import aaa.IShiro;
import aaa.authn.VTNAuthNToken;
import com.sun.jersey.api.client.ClientResponse;
import driver.Mappable;
import driver.ToODL;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hao on 2/18/16.
 */
public class TentMgr extends Mapper implements VTNServ{

    Map<VTNAuthNToken, Subject> tokenSubMap;

    public TentMgr(){
        super();
        tokenSubMap = new HashMap<>();
    }
    Subject userSubject;
    @Override
    public VTNAuthNToken loginReq(String username, String password){
        VTNAuthNToken token = Mapper.getToken(username,password);
        if (token==null){
            throw new AuthenticationException("Authentication Failure: User is not Regiestered");
        }
        this.userSubject = IShiro.New().userLogin(token);
        if(userSubject!=null){
            userSubject.getSession().setAttribute("domainID", token.getDomainId());
            tokenSubMap.put(token, userSubject);
            return token;
        } else {
            throw new AuthenticationException("Authentication Failure: User is not Regiestered");
        }
    }


    @Override
    public void logoutReq(VTNAuthNToken token){
        userSubject.logout();
        tokenSubMap.remove(token);
    }

    @Override
    public ClientResponse getResponse(Mappable request){
        if(IShiro.New().isAuthorized(request)) {
            Mappable mappedReq = Mapper.mapReq(request);
            return ToODL.Send(mappedReq);
        } else{
            throw new AuthorizationException("Authorization Failure : Requested Service is Not Permitted");
        }
    }



}
