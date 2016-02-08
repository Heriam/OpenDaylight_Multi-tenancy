package aaa;

import driver.IMappable;

/**
 * Created by Hao on 2/8/16.
 */
public interface IAAAServ {

    boolean isValid(IMappable request);

    interface IAuthorizable{

        boolean isAuthorized(IMappable request);

        interface IverifyServ{
            boolean canUseServ(IMappable request);
        }

        interface IverifyRsrc{
            boolean canOperaonRsrc(IMappable request);
        }
    }

    interface IAuthenticatable{

        boolean isAuthenticated(IMappable request);
    }

}
