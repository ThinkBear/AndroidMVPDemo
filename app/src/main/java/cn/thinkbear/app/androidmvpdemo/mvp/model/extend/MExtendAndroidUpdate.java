package cn.thinkbear.app.androidmvpdemo.mvp.model.extend;

import cn.thinkbear.app.androidmvpdemo.mvp.model.BaseModel;
import cn.thinkbear.app.androidmvpdemo.vo.AndroidUpdate;
import cn.thinkbear.app.androidmvpdemo.vo.Query;
import cn.thinkbear.app.androidmvpdemo.vo.Response;
import rx.Observable;

/**
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/8/27
 */

public class MExtendAndroidUpdate extends BaseModel<AndroidUpdate> {
    @Override
    public Observable<Response<AndroidUpdate>> getObservable(Query query) {
        return super.getApiExtend().getAndroidUpdate();
    }
}
