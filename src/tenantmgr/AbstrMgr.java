package tenantmgr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hao on 2/18/16.
 */
public abstract class AbstrMgr {

    protected String POST = "create";
    protected String PUT = "update";
    protected String GET = "read";
    protected String DELETE = "delete";

    protected String servVTN = "system:vtn";
    protected String servFIREWALL = "serv:firewall";
    protected String servTOPO = "vtn:topo";

    protected String adminDOM = "admin";
    protected String tent1DOM = "tenant1";
    protected String tent2DOM = "tenant2";

    protected List<String> vtnList;
    protected List<String> msgTypeList;
    protected List<String> servList;

    public AbstrMgr(){
        initVTN();
        initServ();
        iniMethod();
    }

    public void addVTNinList(String tenantName){
        this.vtnList.add(tenantName);
    }

    public void addServinList(String type, String service){
        this.servList.add(type+":"+service);
    }

    public void addMethodList(String method){
        this.msgTypeList.add(method);
    }

    private void initServ(){
        servList = new ArrayList<>();
        this.servList.add(servVTN);
        this.servList.add(servFIREWALL);
        this.servList.add(servTOPO);
    }

    private void initVTN(){
        vtnList = new ArrayList<>();
        this.vtnList.add(adminDOM);
        this.vtnList.add(tent1DOM);
        this.vtnList.add(tent2DOM);
    }

    private void iniMethod(){
        msgTypeList = new ArrayList<>();
        this.msgTypeList.add(POST);
        this.msgTypeList.add(PUT);
        this.msgTypeList.add(GET);
        this.msgTypeList.add(DELETE);
    }


    public List<String> getVtnList() {
        return vtnList;
    }

    public void setVtnList(List<String> vtnList) {
        this.vtnList = vtnList;
    }

    public List<String> getMsgTypeList() {
        return msgTypeList;
    }

    public void setMsgTypeList(List<String> msgTypeList) {
        this.msgTypeList = msgTypeList;
    }

    public List<String> getServList() {
        return servList;
    }

    public void setServList(List<String> servList) {
        this.servList = servList;
    }
}
