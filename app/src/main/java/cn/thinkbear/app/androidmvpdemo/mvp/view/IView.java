package cn.thinkbear.app.androidmvpdemo.mvp.view;


import cn.thinkbear.app.androidmvpdemo.utils.MyFindException;
import cn.thinkbear.app.androidmvpdemo.vo.Query;
import cn.thinkbear.app.androidmvpdemo.vo.Response;

/**
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/4/17
 */

public interface IView<T> {
    /**
     * 取得所需的查询参数数据
     * @return
     */
    public Query getQuery();

    /**
     * 真正开始进行网络请求操作
     */
    public void requestStart(Query query);

    /**
     * 请求成功
     * @param response
     */
    public void requestSuccess(Query query, Response<T> response);

    /**
     * 请求失败
     * @param e
     */
    public void requestFailure(Query query, MyFindException e);

    /**
     * 请求结束
     */
    public void requestComplete(Query query);

}
