package aaa;

import driver.IMappable;
import tenant.Tenant;

/**
 * Created by Hao on 2/6/16.
 */
public interface IAuthorizable {

    String SERVREQ = "Create";

    boolean isAuthorized(IMappable request);

}
