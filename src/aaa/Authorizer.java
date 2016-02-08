package aaa;

import aaa.IAAAServ.IAuthorizable;
import driver.IMappable;

/**
 * Created by Hao on 2/6/16.
 */
public class Authorizer implements IAuthorizable{

    @Override
    public boolean isAuthorized(IMappable request) {
        return (new RsrcMgr().canOperaonRsrc(request))&&(new ServMgr().canUseServ(request));
    }

}
