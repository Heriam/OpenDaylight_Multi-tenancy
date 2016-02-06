package driver;

import com.sun.jersey.api.client.ClientResponse;

/**
 * Created by Hao on 2/5/16.
 */
public interface ISendToODL {

    void Post(IMappable message);
    ClientResponse Get(IMappable message);
    void Put(IMappable message);
    void Delete(IMappable message);
}
