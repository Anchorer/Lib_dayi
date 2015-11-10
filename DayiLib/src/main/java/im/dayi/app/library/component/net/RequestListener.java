package im.dayi.app.library.component.net;

import java.util.Map;

public abstract class RequestListener {

    public abstract void onError(int errorCode);

    public void onComplete(Object data) {}

    public void onComplete(Object data, Map<String, Object> data2) {}

}
