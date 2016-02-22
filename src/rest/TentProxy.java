package rest;


import aaa.authn.VTNAuthNToken;
import com.sun.jersey.api.client.ClientResponse;
import driver.Mappable;
import driver.MappableMsg;
import org.apache.shiro.authc.AuthenticationException;
import org.json.JSONException;
import org.json.JSONObject;
import tenantmgr.VTNServ;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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

    static Map<String, VTNAuthNToken> LoginedToken;

    public TentProxy(){
        LoginedToken = new HashMap<>();
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void login(
            @FormParam("username") String username,
            @FormParam("password") String password,
            @Context HttpServletResponse response){

        try {
            VTNAuthNToken loginToken = VTNServ.getTentMgr().loginReq(username, password);
            LoginedToken.put(username, loginToken);
            String filePath = "/Users/Hao/IdeaProjects/multi-tenancy/web/" + username;
            File fp = new File(filePath);
            // 创建目录
            if (!fp.exists()) {
                fp.mkdirs();// 目录不存在的情况下，创建目录。
            }
            homePage(username);
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

    @POST
    @Path("/logout")
    public void logout(
            @FormParam("username") String username,
            @Context HttpServletResponse response){
        try {
            if(username==null){
                response.sendError(404, "No login User");
            } else {
                VTNServ.getTentMgr().logoutReq(LoginedToken.get(username));
                LoginedToken.remove(username);
            }
        } catch (IOException e1) {
                e1.printStackTrace();
            }
    }




    @POST
    @Path("/operation")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void getCommand(@FormParam("method") String method,
                           @FormParam("service") String service,
                           @FormParam("resource") String resource,
                           @FormParam("network") String network,
                           @FormParam("bridge") String bridge,
                           @FormParam("interface") String intface,
                           @FormParam("router") String router,
                           @FormParam("mapping") String mapping,
                           @FormParam("url") String url,
                           @FormParam("json") String json,
                           @FormParam("username") String username) {

        VTNAuthNToken userToken = TentProxy.LoginedToken.get(username);
        try {
            JSONObject jsonObject = new JSONObject(json);
            Mappable request = new MappableMsg(jsonObject, url, userToken);
            if (method != null) request.setMsgType(method);
            if (service != null) request.setServID(service);
            ClientResponse response = VTNServ.getTentMgr().getResponse(request);

           // String json_string = EntityUtils.toString(response.getEntity());
          //  JSONObject temp1 = new JSONObject(json_string);

        } catch (RuntimeException e){
            throw new JSONException("JSON READER FAILURE : Cannot Parse JSONObject");
        }
    }



    public void frameTopPage(String username){
        StringBuilder sb = new StringBuilder();
        String filePath = "/Users/Hao/IdeaProjects/multi-tenancy/web/"+username+"/frameTop.html";
        File fp = new File(filePath);
        if (fp.exists()) {
            fp.delete();// 目录存在的情况下删除。
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
            sb.append("<div align=\"center\">");
            sb.append("<br><h1>Welcome User :  " + username + " !</h1></div>");
            sb.append(
                    "<div align=\"right\">" +
                            "<form id=\"form\" action=\"../odl/virnet/logout\" enctype=\"application/x-www-form-urlencoded\" method=\"post\">" +
                            "<button type=\"submit\" form=\"form\" name=\"username\" value=\""+username+ "\" onclick=\"jump()\">Logout</button></form>"+
                            "</div>");
            sb.append("<script>\n" +
                    "function jump(){"+
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
            fp.delete();// 目录存在的情况下删除。
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
            sb.append("<h3>Control Panel</h3><hr><br>");
            sb.append("<form id=\"form\" enctype=\"application/x-www-form-urlencoded\" action=\"../odl/virnet/operation\" method=\"post\">\n" +

                    "  <fieldset>\n" +
                    "    <legend>Operation:</legend>\n<br>" +
                    "<input type=\"radio\" name=\"method\" value=\"create\" />&nbsp;&nbsp;&nbsp;&nbsp;Create&nbsp;&nbsp;&nbsp;&nbsp;   " +
                    "<input type=\"radio\" name=\"method\" value=\"update\" />&nbsp;&nbsp;&nbsp;&nbsp;Update&nbsp;&nbsp;&nbsp;&nbsp;   " +
                    "<input type=\"radio\" name=\"method\" value=\"read\" />&nbsp;&nbsp;&nbsp;&nbsp;Read&nbsp;&nbsp;&nbsp;&nbsp;   " +
                    "<input type=\"radio\" name=\"method\" value=\"delete\" />&nbsp;&nbsp;&nbsp;&nbsp;Delete&nbsp;&nbsp;&nbsp;&nbsp;   " +
                    " <br><br> </fieldset>\n<br><br>" +

                    "  <fieldset>\n" +
                    "  <legend>Service:</legend>\n<br>" +
                    "<input type=\"radio\" name=\"service\" value=\"vtn:topo\" />&nbsp;&nbsp;&nbsp;&nbsp;Traffic Shaper&nbsp;&nbsp;&nbsp;&nbsp;   " +
                    "<input type=\"radio\" name=\"service\" value=\"system:vtn\" />&nbsp;&nbsp;&nbsp;&nbsp;IPS/IDS&nbsp;&nbsp;&nbsp;&nbsp;   " +
                    "<input type=\"radio\" name=\"service\" value=\"serv:firewall\" />&nbsp;&nbsp;&nbsp;&nbsp;Firewall&nbsp;&nbsp;&nbsp;&nbsp;   " +
                    "<input type=\"radio\" name=\"service\" value=\"serv:contentfilter\" />&nbsp;&nbsp;&nbsp;&nbsp;Content Filtering&nbsp;&nbsp;&nbsp;&nbsp;   " +
                    "<input type=\"radio\" name=\"service\" value=\"serv:accelerator\" />&nbsp;&nbsp;&nbsp;&nbsp;Accelerator&nbsp;&nbsp;&nbsp;&nbsp;   " +
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
                    "URL: &nbsp;&nbsp;&nbsp;&nbsp;virtual_network/<input type=\"url\" name=\"url\" style=\"width:200px;\" /><br><br>" +
                    "JSON:&nbsp;&nbsp;&nbsp;&nbsp;<textarea rows=\"20\" cols=\"100\" form=\"form\" name=\"json\" ></textarea>" +
                    " <br><br> </fieldset>\n<br>" +
                    "<div align=\"center\">" +
                    "<button type=\"submit\" form=\"form\" name=\"username\" value=\""+username+"\" onclick=\"setTimeout(\"window.parent.frames.output.location.reload();\",3000)\" >Commit</button>   &nbsp;&nbsp;&nbsp;&nbsp;   "+
                    "<button type=\"reset\" form=\"form\" >Reset</button>"+
                    "</div>"+
                    "</form>");
            sb.append("<div>");
            sb.append("<br/><br/>");
            sb.append("<br/><br/>");
            sb.append("</div></body></html>");
            printStream.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void outputPage(String username){
        StringBuilder sb = new StringBuilder();
        String filePath = "/Users/Hao/IdeaProjects/multi-tenancy/web/"+username+"/output.html";
        File fp = new File(filePath);
        if (fp.exists()) {
            fp.delete();// 目录存在的情况下删除。
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
            sb.append("<div align=\"center\">");
            sb.append("<br/><br/>");
            sb.append("<br/><br/>");
            sb.append("</div></body></html>");
            printStream.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void homePage(String username){
        frameTopPage(username);
        frameLeftPage(username);
        outputPage(username);
        StringBuilder sb = new StringBuilder();
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream("/Users/Hao/IdeaProjects/multi-tenancy/web/"+username+"/home.html"));
            sb.append("<html><head><title>\n" +
                    "VirNet Homepage" +
                    "  </title></head>");
            sb.append("<frameset rows=\"20%,80%\">");
            sb.append("<frame src=\"/"+username+"/frameTop.html\">");
            sb.append("<frameset cols=\"50%,50%\">");
            sb.append("<frame src=\"/"+username+"/frameLeft.html\">");
            sb.append("<frame src=\"/"+username+"/output.html\">");
            sb.append("</frameset>");
            sb.append("</frameset>");
            sb.append("</html>");
            printStream.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }






//
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String sayHello() {
//        return "Hello Jersey";
//    }
}
