package driver;

import com.sun.jersey.api.client.ClientResponse;
import driver.vtndatamodel.Serializable;

/**
 * Created by Hao on 2/5/16.
 */
public interface ToODL {

     static Serializable Send(Mappable message){
          if(message.getServID()==null) throw new RuntimeException("Invalid Request : No ServID");
          String servType = message.getServID().split(":")[0];
          switch (servType){
               case "aaa":
               case "serv":
                    return new ODLDriver(8181).CommitRequest(message);
               case "system":
               case "vtn":
               default:
                    return new ODLDriver(8282).CommitRequest(message);
          }
     }


     ClientResponse Post(Mappable message);

     ClientResponse Get(Mappable message);

     ClientResponse Put(Mappable message);

     ClientResponse Delete(Mappable message);

     Serializable CommitRequest(Mappable message);
}
