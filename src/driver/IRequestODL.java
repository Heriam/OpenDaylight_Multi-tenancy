package driver;

import com.sun.jersey.api.client.ClientResponse;

/**
 * Created by Hao on 2/5/16.
 */
public interface IRequestODL {

    void Post(IMessagable message);
    ClientResponse Get(IMessagable message);
    void Put(IMessagable message);
    void Delete(IMessagable message);
}
