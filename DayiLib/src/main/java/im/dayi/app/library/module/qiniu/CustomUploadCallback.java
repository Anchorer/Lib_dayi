package im.dayi.app.library.module.qiniu;

import com.alibaba.fastjson.JSONArray;

/**
 * 公共接口：上传的回调
 * Created by Anchorer/duruixue on 2015/7/21.
 */
public interface CustomUploadCallback {
    void onUploadPrestoreFail();
    void onUploadComplete(JSONArray picKeyArray, JSONArray audioKeyArray);
    void onUploadFail();
}
