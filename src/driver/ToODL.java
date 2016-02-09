package driver;

import com.sun.jersey.api.client.ClientResponse;

/**
 * Created by Hao on 2/5/16.
 */
public interface ToODL {

     static ToODL AAA(){
         return new ODLDriver(8181);
     }

     static ToODL VTN(){
         return new ODLDriver(8282);
     }

     void Post(Mappable message);
     ClientResponse Get(Mappable message);
     void Put(Mappable message);
     void Delete(Mappable message);
}
