package cn.thinkbear.app.androidmvpdemo.mvp.model.extend;

import cn.thinkbear.app.androidmvpdemo.mvp.model.BaseModel;
import cn.thinkbear.app.androidmvpdemo.vo.AndroidUpdate;
import cn.thinkbear.app.androidmvpdemo.vo.Query;
import cn.thinkbear.app.androidmvpdemo.vo.Response;
import rx.Observable;

/**
 * 具体的模型层实现类，用于取得安卓版本更新信息
 *
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/8/27
 */

public class MExtendAndroidUpdate extends BaseModel<AndroidUpdate> {
    @Override
    public Observable<Response<AndroidUpdate>> getObservable(Query query) {
        return super.getApiExtend().getAndroidUpdate(query.getId_int());
    }

    @Override
    public int getDelay() {
        return 3000;
    }
}
