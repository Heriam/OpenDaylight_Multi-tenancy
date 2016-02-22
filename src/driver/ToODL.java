package driver;

import com.sun.jersey.api.client.ClientResponse;

/**
 * Created by Hao on 2/5/16.
 */
public interface ToODL {

     static ToODL AAA(){
         return new ODLDriver(8181);
     }

     static ClientResponse Send(Mappable message){
         if(message.getMsgType()==null) throw new RuntimeException("Invalid Message : Method is not specified");
         switch (message.getMsgType()) {
             case "create":
                 return new ODLDriver(8282).Post(message);
             case "update":
                 return new ODLDriver(8282).Put(message);
             case "delete":
                 return new ODLDriver(8282).Delete(message);
             case "read":
                 return new ODLDriver(8282).Get(message);
             default: return null;
         }
     }

     ClientResponse Post(Mappable message);
     ClientResponse Get(Mappable message);
     ClientResponse Put(Mappable message);
     ClientResponse Delete(Mappable message);
}
