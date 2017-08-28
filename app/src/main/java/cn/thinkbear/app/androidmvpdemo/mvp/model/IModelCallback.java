package cn.thinkbear.app.androidmvpdemo.mvp.model;


import cn.thinkbear.app.androidmvpdemo.utils.MyFindException;
import cn.thinkbear.app.androidmvpdemo.vo.Query;
import cn.thinkbear.app.androidmvpdemo.vo.Response;

/**
 * Model层 回调接口
 *
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/3/26
 */

public interface IModelCallback<T> {
    /**
     * 数据获取成功
     * @param query 封装的请求参数
     * @param response 成功返回的数据对象
     */
    public void onSuccess(Query query, Response<T> response);

    /**
     * 数据获取失败
     * @param query 封装的请求参数
     * @param e 封装的错误信息
     */
    public void onFailure(Query query, MyFindException e);

    /**
     * 获取结束
     * @param query 封装的请求参数
     */
    public void onFinish(Query query);
}
