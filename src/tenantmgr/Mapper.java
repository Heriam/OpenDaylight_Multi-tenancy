package tenantmgr;

import aaa.authn.VTNAuthNToken;
import driver.Mappable;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hao on 2/19/16.
 */
public abstract class Mapper {

    protected static final String urlSYSRT = "controller/nb/v2/";
    protected static final String urlVTN = "controller/nb/v2/vtn/default/vtns/";
    protected static final String urlAUTHRT = "auth/v1/";                             // with subdir domains, users, roles
    protected static final String urlServAuth = "restconf/config/authorization-schema:domain-authorization/domains/";                 //with subdir authorization-schema:simple-authorization or domain-authorization
    protected static final String IFDIR = "/interfaces/";
    protected static final String BRIDGEDIR = "/vbridges/";
    protected static final String PORTMAP = "/portmap";
    protected static final String MACMAPDIR = "/macmap/";
    protected static final String VLANMAP = "/vlanmaps";
    protected static final String dirVTN = "vtn/default/vtns/";

    protected static final String POST = "create";
    protected static final String PUT = "update";
    protected static final String GET = "read";
    protected static final String DELETE = "delete";

    protected static final String sysType = "system";
    protected static final String servType = "serv";
    protected static final String vtnType = "vtn";
    protected static final String aaodlType = "aaa";
    protected static final String restconfType = "rest";

    protected static final String vtnResource = "vtn";
    protected static final String firewallResource = "firewall";
    protected static final String topoResource = "topo";

    protected static final int adminDOM = 0;
    protected static final int tent1DOM = 1;
    protected static final int tent2DOM = 2;
    protected static final String adminUsr = "admin";
    protected static final String tent1Usr = "tenant1";
    protected static final String bossUsr = "boss";
    protected static final String gust1Usr = "guest1";
    protected static final String tent2Usr = "tenant2";
    protected static final String gust2Usr = "guest2";


    protected static Map<String, String> typeMap;
    protected static Map<String, String> rsrcMap;
    protected static List<String> mthdList;
    public static Map<String, Integer> domainMap;

    //Map Token
    public static VTNAuthNToken getToken(String username, String password){
        domainMap = new HashMap<>();
        domainMap.put(adminUsr, adminDOM);
        domainMap.put(bossUsr, adminDOM);
        domainMap.put(tent1Usr, tent1DOM);
        domainMap.put(gust1Usr, tent1DOM);
        domainMap.put(tent2Usr, tent2DOM);
        domainMap.put(gust2Usr, tent2DOM);
        if(username!=null&&domainMap.containsKey(username)) {
            int domainID = domainMap.get(username);
            return new VTNAuthNToken(username, password, domainID);
        } else {
            return null;
        }
    }

    //Map Url
    public static Mappable mapReq(Mappable request){
        typeMap = new HashMap<>();
        typeMap.put(sysType, urlVTN);
        typeMap.put(vtnType, urlVTN);
        typeMap.put(servType, urlServAuth);
        typeMap.put(aaodlType, urlAUTHRT);
        if(request.getServID()!=null) {
            String servType = request.getServID().split(":")[0];
            int domainID = request.getToken().getDomainId();
            String userUrl = request.getURL();
            if(typeMap.containsKey(servType)) {
                String rootUrl = typeMap.get(servType) + (domainID==0 ? "" : request.getToken().getUsername() + "/");
                request.setURL(rootUrl + userUrl);
                return request;
            }
        }
        return null;
    }
}
