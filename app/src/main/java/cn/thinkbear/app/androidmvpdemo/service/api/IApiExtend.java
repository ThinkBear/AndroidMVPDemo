package cn.thinkbear.app.androidmvpdemo.service.api;

import cn.thinkbear.app.androidmvpdemo.service.ApiConstant.Parameter;
import cn.thinkbear.app.androidmvpdemo.vo.AndroidUpdate;
import cn.thinkbear.app.androidmvpdemo.vo.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/8/27
 */

public interface IApiExtend {

    public String BASE = "Extend?action=";
    public String ACTION_ANDROID_UPDATE = "AndroidUpdate";
    public String POST_ANDROID_UPDATE = BASE + ACTION_ANDROID_UPDATE;

    @POST(POST_ANDROID_UPDATE)
    public Observable<Response<AndroidUpdate>> getAndroidUpdate(@Query(Parameter.ID)int id);
}
