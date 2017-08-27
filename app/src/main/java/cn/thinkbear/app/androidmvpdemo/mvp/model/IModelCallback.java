package cn.thinkbear.app.androidmvpdemo.mvp.model;


import cn.thinkbear.app.androidmvpdemo.utils.MyFindException;
import cn.thinkbear.app.androidmvpdemo.vo.Query;
import cn.thinkbear.app.androidmvpdemo.vo.Response;

/**
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/3/26
 */

public interface IModelCallback<T> {
    public void onSuccess(Query query, Response<T> response);

    public void onFailure(Query query, MyFindException e);

    public void onFinish(Query query);
}
