package tenantmgr.mapper;

import driver.Mappable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hao on 2/19/16.
 */
public class Mapper{

    protected String urlSYSRT = "controller/nb/v2/";
    protected String urlVTN = "controller/nb/v2/vtn/default/vtns/";
    protected String urlAUTHRT = "auth/v1/";                             // with subdir domains, users, roles
    protected String RESTCONFROOT = "restconf/config/";                 //with subdir authorization-schema:simple-authorization or domain-authorization
    protected String IFDIR = "/interfaces/";
    protected String BRIDGEDIR = "/vbridges/";
    protected String PORTMAP = "/portmap";
    protected String MACMAPDIR = "/macmap/";
    protected String VLANMAP = "/vlanmaps";
    protected String dirVTN = "vtn/default/vtns/";

    protected String POST = "create";
    protected String PUT = "update";
    protected String GET = "read";
    protected String DELETE = "delete";

    protected String sysType = "system";
    protected String servType = "serv";
    protected String vtnType = "vtn";

    protected String vtnResource = "vtn";
    protected String firewallResource = "firewall";
    protected String topoResource = "topo";

    protected String adminDOM = "admin";
    protected String tent1DOM = "tenant1";
    protected String tent2DOM = "tenant2";


    protected Map<String, String> typeMap;
    protected Map<String, String> rsrcMap;
    protected List<String> mthdList;


    public void mapRequest(Mappable message){
        patchURL(message);

    }


    public void patchURL(Mappable message){
        String servType = message.getServID().split(":")[0];
        int domainID = message.getToken().getDomainId();
        String rootUrl = typeMap.get(servType)+domainID+"/";
        message.setURL(rootUrl);
    }


    public void iniServTypeMap(){
        typeMap = new HashMap<>();
        typeMap.put(sysType, urlVTN);
        typeMap.put(vtnType, urlVTN);
        typeMap.put(servType, urlVTN);
    }








}
