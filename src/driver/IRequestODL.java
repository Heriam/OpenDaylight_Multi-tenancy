package driver;

import com.sun.jersey.api.client.ClientResponse;

/**
 * Created by Hao on 06/01/16.
 */
public interface IRequestODL {

    String ODLIP = "http://172.23.225.48:8282";
    String JSON = "application/json";

    void Post(IMessagable message);
    ClientResponse Get(IMessagable message);
    void Put(IMessagable message);
    void Delete(IMessagable message);
}
