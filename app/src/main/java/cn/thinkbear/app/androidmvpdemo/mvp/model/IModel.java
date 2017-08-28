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
    /**
     * 取得订阅对象
     *
     * @param query 请求参数数据
     * @return 返回一个订阅
     */
    public Subscription requestQuery(Query query);

    /**
     * 初始化数据层
     *
     * @param callback 数据层回调对象
     * @param context
     */
    public void initModel(IModelCallback<T> callback, Context context);
}
