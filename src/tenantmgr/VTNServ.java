package tenantmgr;

/**
 * Created by Hao on 2/21/16.
 */
public interface VTNServ {

    boolean loginReq(String username, String password);
    void logoutReq();

    static VTNServ getTentMgr(){
         return new TentMgr();
    }
}
