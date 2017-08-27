package cn.thinkbear.app.androidmvpdemo.service.api;

import cn.thinkbear.app.androidmvpdemo.vo.AndroidUpdate;
import cn.thinkbear.app.androidmvpdemo.vo.Response;
import retrofit2.http.GET;
import rx.Observable;

/**
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/8/27
 */

public interface IApiExtend {

    @GET("AndroidMVPDemo/blob/master/.source/AndroidUpdate.json")
    public Observable<Response<AndroidUpdate>> getAndroidUpdate();
}
