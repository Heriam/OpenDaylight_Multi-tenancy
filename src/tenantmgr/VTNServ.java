package tenantmgr;

import aaa.authn.VTNAuthNToken;
import com.sun.jersey.api.client.ClientResponse;
import driver.Mappable;

/**
 * Created by Hao on 2/21/16.
 */
public interface VTNServ {

    VTNAuthNToken loginReq(String username, String password);
    void logoutReq(VTNAuthNToken token);

    static VTNServ getTentMgr(){
         return new TentMgr();
    }

    ClientResponse getResponse(Mappable request);

}
