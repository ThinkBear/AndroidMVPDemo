package cn.thinkbear.app.androidmvpdemo.mvp.model;

import android.content.Context;

import cn.thinkbear.app.androidmvpdemo.vo.Query;
import rx.Subscription;

/**
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/4/20
 */

public interface IModel<T> {
    public Subscription requestQuery(Query query);
    public void initModel(IModelCallback<T> callback, Context context);
}
