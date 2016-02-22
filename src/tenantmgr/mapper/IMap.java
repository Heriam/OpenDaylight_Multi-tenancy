package tenantmgr.mapper;

import aaa.authn.VTNAuthNToken;
import driver.Mappable;

/**
 * Created by Hao on 2/21/16.
 */
public interface IMap {

    VTNAuthNToken addDomainID(VTNAuthNToken token);
    void patchURL(Mappable message);

    static IMap getMapper(){
        return new Mapper();
    }
}
