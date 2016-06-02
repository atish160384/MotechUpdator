package motech.nms.HttpMethods;

import com.google.gson.Gson;
import motech.nms.FlwRequest.AddFlwRequest;

/**
 * Created by atish on 2/6/16.
 */
public class GsonConverter <T> {

    private  Gson gson;

    public GsonConverter() {
        gson  = new Gson();
    }

    public String converttoJson(T t) {
        return gson.toJson(t);
    }

    public Gson getGson() {
        return gson;
    }
}
