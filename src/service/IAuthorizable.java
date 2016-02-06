package service;

import driver.IMappable;
import tenant.Tenant;

/**
 * Created by Hao on 2/6/16.
 */
public interface IAuthorizable {

    String CREATE = "VTN Creation";
    String CREDTOPO = "EDIT Topology";

    boolean isAuthorized(IMappable request);
    int getPriority(Tenant tenant);

}
