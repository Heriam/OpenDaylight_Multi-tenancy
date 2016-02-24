package tenantmgr;

import aaa.authn.VTNAuthNToken;
import com.sun.jersey.api.client.ClientResponse;
import driver.Mappable;
import driver.vtndatamodel.Serializable;

/**
 * Created by Hao on 2/21/16.
 */
public interface VTNServ {

    VTNAuthNToken loginReq(String username, String password);
    void logoutReq(VTNAuthNToken token);

    static VTNServ getTentMgr(){
         return new TentMgr();
    }

    Serializable getResponse(Mappable request);

}
