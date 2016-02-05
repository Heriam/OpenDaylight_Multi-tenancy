package test;


import driver.Requester;
import driver.IMessagable;
import driver.Message;
import driver.aaadatamodel.UserInfo;
import driver.aaadatamodel.UserList;


/**
 * Created by Hao on 2/5/16.
 */
public class AAARequests {
    public static void main(String[] args) {

        String userAdmin = "admin";
        String pswdAdmin = "admin";

        String usernameAndPassword = userAdmin + ":" + pswdAdmin;
        String adminAuth = "Basic " + java.util.Base64.getEncoder().encodeToString( usernameAndPassword.getBytes());

        //Create a User
        Requester req = new Requester();
        IMessagable userJue = new Message(new UserInfo("hao.jiang", "931026"), "auth/v1/users", adminAuth);
//        req.Post(userJue);
        System.out.println(req.Get(userJue).getEntity(UserList.class));

    }
}
