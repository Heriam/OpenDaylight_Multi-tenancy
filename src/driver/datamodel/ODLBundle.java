package driver.datamodel;

import org.json.JSONObject;

/**
 * Created by Hao on 1/12/16.
 */
public class ODLBundle extends JSONObject{
    private String major;
    private String minor;
    private String micro;
    private String qualifier;

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
