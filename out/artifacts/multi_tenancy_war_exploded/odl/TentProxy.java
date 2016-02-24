package rest;


import aaa.authn.VTNAuthNToken;
import com.sun.tools.internal.ws.processor.util.DirectoryUtil;
import driver.ODLDriver;
import driver.ResponseMsgPOJO;
import driver.vtndatamodel.Serializable;
import driver.Mappable;
import driver.MappableMsg;
import driver.vtndatamodel.*;
import org.apache.shiro.authc.AuthenticationException;
import org.json.JSONException;
import org.json.JSONObject;
import tenantmgr.VTNServ;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Hao on 2/20/16.
 */

@Path("/virnet")
public class TentProxy {

    static private VTNAuthNToken token;


    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void login(
            @FormParam("username") String username,
            @FormParam("password") String password,
            @Context HttpServletResponse response){


        try {
            token = VTNServ.getTentMgr().loginReq(username, password);

            updateFile(username);



            response.sendRedirect("/" + username + "/home.html");
        }catch (AuthenticationException e){
            try {
                response.sendRedirect("/index.html");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Path("/logout")
    @POST
    public void logout(
            @Context HttpServletResponse response){
                VTNServ.getTentMgr().logoutReq(token);
    }

    @Path("/cleanlogout")
    @POST
    public void cleanlogout(
            @Context HttpServletResponse response){
        VTNServ.getTentMgr().logoutReq(token);
        String filePath = "/Users/Hao/IdeaProjects/multi-tenancy/web/"+token.getUsername();
        File fp = new File(filePath);
        if (fp.exists()) {
            deleteFile(fp);
        }
    }


    @Path("/operation")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String getOutput(@FormParam("method") String method,
                           @FormParam("service") String service,
                           @FormParam("resource") String resource,
                           @FormParam("network") String network,
                           @FormParam("bridge") String bridge,
                           @FormParam("interface") String intface,
                           @FormParam("router") String router,
                           @FormParam("mapping") String mapping,
                           @FormParam("url") String url,
                           @FormParam("json") String json,
                           @Context HttpServletResponse webresponse) {
        String outputString;
        String requestString=null;

        try {
            JSONObject jsonObject = (json==null || json.isEmpty()) ? null : new JSONObject(json);
            Mappable request = new MappableMsg(jsonObject, url, token);
            request.setServID(service);
            request.setMsgType(method);
            requestString = request.toString();
            Serializable reqresponse = VTNServ.getTentMgr().getResponse(request);
            outputString = reqresponse.toString();

        } catch (RuntimeException e) {
            outputString = e.getMessage();
        }

        return "<html><head><title>Output</title>" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />" +
                "<style type=\"text/css\"></style></head><body>" +
                "<h3>Output</h3><hr><br>" +
                "<div>" +
                "<b>REQUEST:</b>"+
                "<textarea rows=\"5\" cols=\"110\" name=\"textarea\" >"+requestString+"</textarea><br><br>" +
                "<b>OUTPUT:</b>"+
                "<textarea rows=\"15\" cols=\"110\" name=\"textarea\" >"+outputString+"</textarea></div>" +
                "</body></html>";
    }



    public void frameTopPage(String username){
        StringBuilder sb = new StringBuilder();
        String filePath = "/Users/Hao/IdeaProjects/multi-tenancy/web/"+username+"/frameTop.html";
        File fp = new File(filePath);
        if (fp.exists()) {
            deleteFile(fp);// 目录存在的情况下删除。
        }
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream("/Users/Hao/IdeaProjects/multi-tenancy/web/"+username+"/frameTop.html"));
            sb.append("<html>");
            sb.append("<head>");
            sb.append("<title>Welcome Page</title>");
            sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            sb.append("<style type=\"text/css\">");
            sb.append("</style></head>");
            sb.append("<body>");
            sb.append("<div style=\"display: inline;\" align=\"center\">");
            sb.append("<br><h1>Welcome User :  " + token.getUsername() + " !</h1></div>");
            sb.append(
                    "<div align=\"right\">" +
                            (token.getDomainId()==0?
                                    "<button style=\"display: inline;\" onclick= \"window.parent.frames.frameOutput.location.href=\'http://"+ ODLDriver.ODLIP+"8181/index.html\';\">ODL DLUX</button>&nbsp;&nbsp;"+
                                    "<button style=\"display: inline;\" onclick= \"window.parent.frames.frameOutput.location.href=\'http://"+ ODLDriver.ODLIP+"8181/apidoc/explorer/index.html\';\">ODL APIs</button>&nbsp;&nbsp;"+
                                    "<button style=\"display: inline;\" onclick= \"window.parent.frames.frameOutput.location.href=\'../SFC.html\';\">SFC</button>&nbsp;&nbsp;" :"")+
                            "<button style=\"display: inline;\" onclick= \"window.parent.frames.frameOutput.location.href=\'../vtnjson.html\';\">JSON Ref</button>&nbsp;&nbsp;"+
                            "<form style=\"display: inline;\" id=\"form\" action=\"../odl/virnet/logout\" enctype=\"application/x-www-form-urlencoded\" method=\"post\">" +
                            "<button type=\"submit\" form=\"form\" name=\"username\" value=\""+username+ "\" onclick= \"jump()\">Logout</button></form>&nbsp;&nbsp;"+
                            "<form style=\"display: inline;\" id=\"form1\" action=\"../odl/virnet/cleanlogout\" enctype=\"application/x-www-form-urlencoded\" method=\"post\">" +
                            "<button type=\"submit\" form=\"form1\" name=\"username\" value=\""+username+ "\" onclick= \"jump1()\">Clean Logout</button></form>"+
                            "</div><hr><br>" +
                            "<fieldset>\n" +
                            "<legend>Tools: </legend>\n<br>" +

                            " <br><br> </fieldset>");
            sb.append("<script>\n" +
                    "function jump(){"+
                    "document.getElementById(\"form\").submit();"+
                    "top.location.href='../index.html';" +
                    "} </script>");
            sb.append("<script>\n" +
                    "function jump1(){"+
                    "document.getElementById(\"form1\").submit();"+
                    "top.location.href='../index.html';" +
                    "} </script>");
            sb.append("</body></html>");
            printStream.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void frameLeftPage(String username){
        StringBuilder sb = new StringBuilder();
        String filePath = "/Users/Hao/IdeaProjects/multi-tenancy/web/"+username+"/frameLeft.html";
        File fp = new File(filePath);
        if (fp.exists()) {
            deleteFile(fp);// 目录存在的情况下删除。
        }
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream("/Users/Hao/IdeaProjects/multi-tenancy/web/"+username+"/frameLeft.html"));
            sb.append("<html>");
            sb.append("<head>");
            sb.append("<title>Control Panel</title>");
            sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            sb.append("<style type=\"text/css\">");
            sb.append("</style></head>");
            sb.append("<body>");
            sb.append("<h3 style=\"display: inline;\">Control Panel</h3><hr><br>");
            sb.append("<form id=\"form\" target=\"frameOutput\" enctype=\"application/x-www-form-urlencoded\" action=\"../odl/virnet/operation\" method=\"post\">\n" +

                    "  <fieldset>\n" +
                    "    <legend>Operation:</legend>\n<br>" +
                    "<input type=\"radio\" name=\"method\" value=\"create\" />&nbsp;&nbsp;&nbsp;&nbsp;Create&nbsp;&nbsp;&nbsp;&nbsp;   " +
                    "<input type=\"radio\" name=\"method\" value=\"update\" />&nbsp;&nbsp;&nbsp;&nbsp;Update&nbsp;&nbsp;&nbsp;&nbsp;   " +
                    "<input type=\"radio\" name=\"method\" value=\"read\" checked=\"checked\" />&nbsp;&nbsp;&nbsp;&nbsp;Read&nbsp;&nbsp;&nbsp;&nbsp;   " +
                    "<input type=\"radio\" name=\"method\" value=\"delete\" />&nbsp;&nbsp;&nbsp;&nbsp;Delete&nbsp;&nbsp;&nbsp;&nbsp;   " +
                    " <br><br> </fieldset>\n<br><br>" +

                    "  <fieldset>\n" +
                    "  <legend>Service:</legend>\n<br>" +
                    "<input type=\"radio\" name=\"service\" value=\"vtn:topo\" checked=\"checked\"/>&nbsp;&nbsp;&nbsp;&nbsp;Basic VTN &nbsp;&nbsp;&nbsp;&nbsp;   " +
                    "<input type=\"radio\" name=\"service\" value=\"aaa:acl\" />&nbsp;&nbsp;&nbsp;&nbsp; ACL &nbsp;&nbsp;&nbsp;&nbsp;   " +
                    "<input type=\"radio\" name=\"service\" value=\"serv:firewall\" />&nbsp;&nbsp;&nbsp;&nbsp;Firewall &nbsp;&nbsp;&nbsp;&nbsp;   " +
                    "<input type=\"radio\" name=\"service\" value=\"serv:content\" />&nbsp;&nbsp;&nbsp;&nbsp; Content Filtering &nbsp;&nbsp;&nbsp;&nbsp;   " +
                    "<input type=\"radio\" name=\"service\" value=\"rest:conf\" />&nbsp;&nbsp;&nbsp;&nbsp; BYOC &nbsp;&nbsp;&nbsp;&nbsp;   " +
                    " <br><br> </fieldset>\n<br><br>" +

                    "  <fieldset>\n" +
                    "  <legend>Resource:</legend>\n<br>" +
                    "<input type=\"checkbox\" name=\"resource\" value=\"network\" />&nbsp;&nbsp;&nbsp;&nbsp; Network &nbsp;&nbsp;&nbsp;&nbsp;  " +
                    "<select name=\"network\">\n" +
                    "<option value=\"default\">Default</option>\n" +
                    "<option value=\"net1\">Network1</option>\n" +
                    "<option value=\"net2\">Network2</option>\n" +
                    "<option value=\"net3\">Network3</option>\n" +
                    "<option value=\"net4\">Network4</option>\n" +
                    "<option value=\"net5\">Network5</option>\n" +
                    "</select>&nbsp;&nbsp;&nbsp;&nbsp;<br>"+

                    "<input type=\"checkbox\" name=\"resource\" value=\"bridge\" />&nbsp;&nbsp;&nbsp;&nbsp; Bridge   &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;   " +
                    "<select name=\"bridge\">\n" +
                    "<option value=\"bridge1\">Bridge1</option>\n" +
                    "<option value=\"bridge2\">Bridge2</option>\n" +
                    "<option value=\"bridge3\">Bridge3</option>\n" +
                    "<option value=\"bridge4\">Bridge4</option>\n" +
                    "<option value=\"bridge5\">Bridge5</option>\n" +
                    "</select>&nbsp;&nbsp;&nbsp;&nbsp;<br>"+

                    "<input type=\"checkbox\" name=\"resource\" value=\"interface\" />&nbsp;&nbsp;&nbsp;&nbsp; Interface &nbsp;&nbsp;&nbsp;&nbsp;   " +
                    "<select name=\"interface\">\n" +
                    "<option value=\"int1\">Interface1</option>\n" +
                    "<option value=\"int2\">Interface2</option>\n" +
                    "<option value=\"int3\">Interface3</option>\n" +
                    "<option value=\"int4\">Interface4</option>\n" +
                    "<option value=\"int5\">Interface5</option>\n" +
                    "</select>&nbsp;&nbsp;&nbsp;&nbsp;<br>"+

                    "<input type=\"checkbox\" name=\"resource\" value=\"router\" />&nbsp;&nbsp;&nbsp;&nbsp; Router  &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;   " +
                    "<select name=\"router\">\n" +
                    "<option value=\"r1\">Router1</option>\n" +
                    "<option value=\"r2\">Router2</option>\n" +
                    "<option value=\"r3\">Router3</option>\n" +
                    "<option value=\"r4\">Router4</option>\n" +
                    "<option value=\"r5\">Router5</option>\n" +
                    "</select>&nbsp;&nbsp;&nbsp;&nbsp;<br>"+

                    "<input type=\"checkbox\" name=\"resource\" value=\"mapping\" />&nbsp;&nbsp;&nbsp;&nbsp; Mapping  &nbsp;&nbsp;&nbsp;&nbsp;   " +
                    "<select name=\"mapping\">\n" +
                    "<option value=\"portmap\">PortMap</option>\n" +
                    "<option value=\"macmap\">MacMap</option>\n" +
                    "<option value=\"vlanmaps\">VlanMap</option>\n" +
                    "</select>&nbsp;&nbsp;&nbsp;&nbsp;<br>"+

                    " <br> </fieldset>\n<br><br>" +

                    "  <fieldset>\n" +
                    "  <legend>Command:</legend>\n<br>" +
                    "URL: &nbsp;&nbsp;&nbsp;&nbsp;virtual_network/<input type=\"text\" name=\"url\" style=\"width:200px;\" /><br><br>" +
                    "JSON:&nbsp;&nbsp;&nbsp;&nbsp;<textarea rows=\"20\" cols=\"100\" form=\"form\" name=\"json\" ></textarea>" +
                    " <br><br> </fieldset>\n<br>" +
                    "<div align=\"center\">" +
                    "<button type=\"submit\" form=\"form\" name=\"username\" value=\""+username+"\" onclick=\"output()\">Commit</button>   &nbsp;&nbsp;&nbsp;&nbsp;   "+
                    "<button type=\"reset\" form=\"form\" >Reset</button>"+
                    "</div>"+
                    "</form>");
            sb.append("<div>");
            sb.append("<br/><br/>");
            sb.append("<script>\n" +
                    "function output(){"+
                    "document.getElementById(\"form\").submit();"+
//                    "location.reload(true);"+
//                    "setTimeout('window.parent.frames.frameOutput.location.replace(\"./updateoutput.html\")',5000);" +
                    "} </script>");
            sb.append("<br/><br/>");
            sb.append("</div></body></html>");
            printStream.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void frameOutputPage(String username){
        StringBuilder sb = new StringBuilder();
        String filePath = "/Users/Hao/IdeaProjects/multi-tenancy/web/"+username+"/output.html";
        File fp = new File(filePath);
        if (fp.exists()) {
            fp.deleteOnExit();
            fp.exists();
            deleteFile(fp);// 目录存在的情况下删除。
        }
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream("/Users/Hao/IdeaProjects/multi-tenancy/web/"+username+"/output.html"));
            sb.append("<html>");
            sb.append("<head>");
            sb.append("<title>Output</title>");
            sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            sb.append("<style type=\"text/css\">");
            sb.append("</style></head>");
            sb.append("<body>");
            sb.append("<h3>Output</h3><hr><br>");
            sb.append("<div>");
            sb.append("<b>REQUEST:</b>");
            sb.append("<textarea rows=\"5\" cols=\"110\" name=\"textarea\" ></textarea><br><br>");
            sb.append("<b>OUTPUT:</b><br><textarea rows=\"15\" cols=\"110\" name=\"textarea\" ></textarea></div>");
            sb.append("</body></html>");
            printStream.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void homePage(String username){
        StringBuilder sb = new StringBuilder();
        String filePath = "/Users/Hao/IdeaProjects/multi-tenancy/web/"+username+"/home.html";
        File fp = new File(filePath);
        if (fp.exists()) {
            deleteFile(fp);// 目录存在的情况下删除。
        }
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream("/Users/Hao/IdeaProjects/multi-tenancy/web/"+username+"/home.html"));
            sb.append("<html><head><title>\n" +
                    "VirNet Homepage" +
                    "  </title></head>");
            sb.append("<frameset rows=\"20%,80%\">");
            sb.append("<frame name = \"frameTop\" src=\"/"+username+"/frameTop.html\">");
            sb.append("<frameset cols=\"50%,50%\">");
            sb.append("<frame name = \"frameLeft\" src=\"/"+username+"/frameLeft.html\">");
            sb.append("<frame name = \"frameOutput\" src=\"/"+username+"/output.html\">");
            sb.append("</frameset>");
            sb.append("</frameset>");
            sb.append("</html>");
            printStream.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


//    public void updateOutput(String username, String jsonString){
//        StringBuilder sb = new StringBuilder();
//        String filePath = "/Users/Hao/IdeaProjects/multi-tenancy/web/"+username+"/updateoutput.html";
//        File fp = new File(filePath);
//        if (fp.exists()) {
//            fp.deleteOnExit();
//            fp.exists();
//            deleteFile(fp);// 目录存在的情况下删除。
//        }
//        try {
//            PrintStream printStream = new PrintStream(new FileOutputStream("/Users/Hao/IdeaProjects/multi-tenancy/web/"+username+"/updateoutput.html"));
//            sb.append("<html>");
//            sb.append("<head>");
//            sb.append("<title>Output</title>");
//            sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
//            sb.append("<style type=\"text/css\">");
//            sb.append("</style></head>");
//            sb.append("<body");
//            sb.append("<h3>Output</h3><hr><br>");
//            sb.append("<div>");
//            sb.append("<textarea rows=\"30\" cols=\"110\" name=\"textarea\" >"+jsonString+"</textarea></div>");
//            sb.append("<br/><br/>");
//            sb.append("<br/><br/>");
//            sb.append("</body></html>");
//            printStream.println(sb.toString());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    private void updateFile(String username) {
        String filePath = "/Users/Hao/IdeaProjects/multi-tenancy/web/" + username;
        File fp = new File(filePath);
        if (!fp.exists()) {
            fp.mkdirs();// 目录不存在的情况下，创建目录。
        }
        frameTopPage(username);
        frameLeftPage(username);
        frameOutputPage(username);
        homePage(username);
    }

    private void deleteFile(File file){
        if(file.exists()){
            file.setWritable(true);
            if(file.isFile()){
                file.delete();
            }else if(file.isDirectory()){
                File files[] = file.listFiles();
                for(int i=0;i<files.length;i++){
                    this.deleteFile(files[i]);
                }
            }
            file.delete();
        }else{
            System.out.println("所删除的文件不存在！"+'\n');
        }
    }




//
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String sayHello() {
//        return "Hello Jersey";
//    }
}
