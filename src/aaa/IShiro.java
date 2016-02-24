package aaa;

import aaa.authn.VTNAuthNToken;
import driver.Mappable;
import org.apache.shiro.subject.Subject;

/**
 * Created by Hao on 2/12/16.
 */
public interface IShiro {

    static IShiro New(){
        return new Shiro();
    }

    Subject getLoginedUser(VTNAuthNToken token);
//    boolean isAuthorized(Mappable request);
//    String generateKey(VTNAuthNToken token);


}
