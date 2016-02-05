package driver.vtndatamodel;

import driver.IMessagable;
import org.json.JSONObject;

/**
 * Created by Hao on 1/12/16.
 * bundle element shows version information of OSGi bundle that implements VTN Manager. Meaning of each bundle attribute is as follows.

 major
     major component of OSGi bundle version is configured.
 minor
     minor component of OSGi bundle version is configured.
 micro
     micro component of OSGi bundle version is configured.
 qualifier
     qualifier component of OSGi bundle version is configured.
     qualifier is omitted if qualifier is not set in OSGi bundle version.
 */
public class ODLBundle extends JSONObject implements IMessagable{
    private String major;
    private String minor;
    private String micro;
    private String qualifier;

    private String URL;
    private String Auth;
    @Override
    public String getURL() {
        return URL;
    }
    @Override
    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String getAuth() {
        return Auth;
    }
    @Override
    public void setAuth(String auth) {
        Auth = auth;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getMicro() {
        return micro;
    }

    public void setMicro(String micro) {
        this.micro = micro;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    @Override
    public String toString() {
        return "{" +
                "\"major\":\"" + major + '\"' +
                ", \"minor\":\"" + minor + '\"' +
                ", \"micro\":\"" + micro + '\"' +
                ", \"qualifier\":\"" + qualifier + '\"' +
                '}';
    }
}
