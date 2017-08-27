package cn.thinkbear.app.androidmvpdemo.mvp.view;


import cn.thinkbear.app.androidmvpdemo.vo.Query;

/**
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
