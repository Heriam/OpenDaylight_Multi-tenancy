package driver;

import driver.vtndatamodel.Serializable;
import org.json.JSONObject;

/**
 * Created by Hao on 2/23/16.
 */
public class ResponseMsgPOJO extends JSONObject implements Serializable {
    String Http_Response;

    public ResponseMsgPOJO(){};
    public ResponseMsgPOJO(String string){
        this.Http_Response = string;
    }

    public String getHttp_Response() {
        return Http_Response;
    }

    public void setHttp_Response(String http_Response) {
        Http_Response = http_Response;
    }

    @Override
    public String toString() {
        return Http_Response;
    }
}
