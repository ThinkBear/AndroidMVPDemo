package cn.thinkbear.app.androidmvpdemo.mvp.view;


import cn.thinkbear.app.androidmvpdemo.vo.Query;

/**
 * View层 回调接口的适配器
 *
 * 对于某些不需要太多额外回调方法，可继承此类
 *
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/4/20
 */

public abstract class ViewAdapter<T> implements IView<T> {

    @Override
    public Query getQuery() {
        return null;
    }

    @Override
    public void requestStart(Query query) {

    }

    @Override
    public void requestComplete(Query query) {

    }
}
