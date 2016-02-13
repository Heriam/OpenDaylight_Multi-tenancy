package aaa.realms;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by Hao on 2/10/16.
 */
public class VTNAuthNToken extends UsernamePasswordToken {

    private int domainId;

    public VTNAuthNToken(final String username, final char[] password, int domainId) {
        setUsername(username);
        setPassword(password);
        setDomainId(domainId);
    }

    public VTNAuthNToken(final String username, final String password, int domainId) {
        setUsername(username);
        setPassword(password != null ? password.toCharArray() : null);
        setDomainId(domainId);
    }

    public int getDomainId() {
        return domainId;
    }

    public void setDomainId(int tenantId) {
        this.domainId = tenantId;
    }


}
