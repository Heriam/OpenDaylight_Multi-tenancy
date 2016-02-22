package tenantmgr.mapper;

import aaa.authn.VTNAuthNToken;
import driver.Mappable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hao on 2/19/16.
 */
public class Mapper implements IMap{

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

    protected int adminDOM = 0;
    protected int tent1DOM = 1;
    protected int tent2DOM = 2;
    protected String adminUsr = "admin";
    protected String tent1Usr = "tenant1";
    protected String bossUsr = "boss";
    protected String gust1Usr = "guest1";
    protected String tent2Usr = "tenant2";
    protected String gust2Usr = "guest2";


    protected Map<String, String> typeMap;
    protected Map<String, String> rsrcMap;
    protected List<String> mthdList;
    protected Map<String, Integer> domainMap;


    public Mapper(){
        iniServTypeMap();
        iniDomainMap();
    }


    public VTNAuthNToken addDomainID(VTNAuthNToken token){
        String username = token.getUsername();
        char[] password = token.getPassword();
        int domainID = domainMap.get(username);
        return new VTNAuthNToken(username, password, domainID);
    }

    // URL = servType Root + DomainID
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

    public void iniDomainMap(){
        domainMap = new HashMap<>();
        domainMap.put(adminUsr, adminDOM);
        domainMap.put(bossUsr, adminDOM);
        domainMap.put(tent1Usr, tent1DOM);
        domainMap.put(gust1Usr, tent1DOM);
        domainMap.put(tent2Usr, tent2DOM);
        domainMap.put(gust2Usr, tent2DOM);
    }








}
