package aaa;


import driver.Mappable;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;


/**
 * Created by Hao on 2/12/16.
 */
public class Shiro implements IShiro{

    Subject subject;

    public Shiro(){
        Factory<SecurityManager> factory;
        SecurityManager securityManager;
        factory = new IniSecurityManagerFactory("file:/Users/Hao/IdeaProjects/multi-tenancy/shiro/shiro.ini");
        securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        subject = SecurityUtils.getSubject();
    }



    @Override
    public boolean isAuthenticated(Mappable request) {
        UsernamePasswordToken token = request.getToken();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return false;
        }
        boolean authc = subject.isAuthenticated();
        subject.logout();
        return authc;
    }

    @Override
    public boolean isAuthorized(Mappable request) {
        UsernamePasswordToken token = request.getToken();
        String ServID = request.getServID();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return false;
        }
        boolean authz = subject.isPermitted(ServID);
        subject.logout();
        return authz;
    }

    @Override
    public String generateKey(Mappable request){
        String username = request.getToken().getUsername();
        char[] password = request.getToken().getPassword();
        int domainID = request.getToken().getDomainId();
        String join = username+password+domainID;
        String joinkey;
        try {
            subject.login(request.getToken());
            if (subject.isAuthenticated()) {
                joinkey = Base64.encodeToString(join.getBytes());
            } else {
                joinkey = null;
            }
            subject.logout();
            return joinkey;
        } catch (AuthenticationException e) {
            return null;
        }
    }
}





