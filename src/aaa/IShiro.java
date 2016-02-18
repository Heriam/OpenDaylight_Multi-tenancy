package aaa;

import driver.Mappable;

/**
 * Created by Hao on 2/12/16.
 */
public interface IShiro {
    boolean isAuthenticated(Mappable request);
    boolean isAuthorized(Mappable request);
    String generateKey(Mappable request);

    static IShiro New(){
        return new Shiro();
    }

}
