package aaa;

import aaa.authn.VTNAuthNToken;
import org.apache.shiro.subject.Subject;

/**
 * Created by Hao on 2/12/16.
 */
public interface IShiro {

    Subject userLogin(VTNAuthNToken token);

    static IShiro New(){
        return new Shiro();
    }

}
