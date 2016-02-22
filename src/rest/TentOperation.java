package rest;


import aaa.authn.VTNAuthNToken;
import driver.Mappable;
import driver.MappableMsg;
import org.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by Hao on 2/22/16.
 */

@Path("/operation")
public class TentOperation {

    @POST
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
                           @FormParam("json") JSONObject json,
                           @FormParam("username") String username) {

        VTNAuthNToken userToken = TentProxy.LoginedToken.get(username);
        Mappable request = new MappableMsg(json, url, userToken);
        if(method!=null) request.setMsgType(method);
        if(service!=null) request.setServID(service);








        StringBuilder sb = new StringBuilder();
        String filePath = "/Users/Hao/IdeaProjects/multi-tenancy/web/" + username + "/output.html";
        File fp = new File(filePath);
        if (fp.exists()) {
            fp.delete();// 目录存在的情况下删除。
        }
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream("/Users/Hao/IdeaProjects/multi-tenancy/web/" + username + "/output.html"));

            sb.append("<html>");
            sb.append("<head>");
            sb.append("<title>Updated Output</title>");
            sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            sb.append("<style type=\"text/css\">");
            sb.append("</style></head>");
            sb.append("<body>");
            sb.append("<h3>Output</h3><hr><br>");
            sb.append("<div align=\"center\">");
            sb.append("<br/><br/>");
            sb.append("");
            sb.append("<br/><br/>");
            sb.append("</div></body></html>");
            printStream.println(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
