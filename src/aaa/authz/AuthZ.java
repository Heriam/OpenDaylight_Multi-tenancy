package aaa.authz;

import driver.Mappable;

/**
 * Created by Hao on 2/9/16.
 */
public interface AuthZ {

    default boolean canUseServ(Mappable request){
        return false;
    }
    default boolean canOperaonRsrc(Mappable request){return false;}

    static boolean useServ(Mappable request){
        return new ServMgr().canUseServ(request);
    }
    static boolean editRsrc(Mappable request){
        return new RsrcMgr().canOperaonRsrc(request);
    }
    static boolean fullAuth(Mappable request) {return editRsrc(request)&&useServ(request);}

}
