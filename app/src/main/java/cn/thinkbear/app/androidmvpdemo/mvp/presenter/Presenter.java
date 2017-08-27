package cn.thinkbear.app.androidmvpdemo.mvp.presenter;

import android.content.Context;

import cn.thinkbear.app.androidmvpdemo.mvp.model.IModel;
import cn.thinkbear.app.androidmvpdemo.mvp.model.IModelCallback;
import cn.thinkbear.app.androidmvpdemo.mvp.view.IView;
import cn.thinkbear.app.androidmvpdemo.utils.MyFindException;
import cn.thinkbear.app.androidmvpdemo.vo.Query;
import cn.thinkbear.app.androidmvpdemo.vo.Response;


/**
 * Presenter层的基类<br>
 * <p>
 * 用于管理Subscription(订阅者)对象，避免内存泄露
 *
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/3/25
 */

public class Presenter<T> extends BasePresenter implements IModelCallback<T> {
    private IView<T> view = null;
    private IModel<T> model = null;
    public Presenter(Context context, IModel model, IView view) {
        this.view = view;
        this.model = model;
        this.model.initModel(this,context);
    }


    @Override
    public void requestApi(){
        Query query = this.view.getQuery();
        if (query != null) {
            this.view.requestStart(query);
            super.addSubscription(this.model.requestQuery(query));
        }
    }

    @Override
    public void requestApi(Query query) {
        if (query != null) {
            this.view.requestStart(query);
            super.addSubscription(this.model.requestQuery(query));
        }
    }

    @Override
    public void onSuccess(Query query, Response response) {
        this.view.requestSuccess(query, response);
    }

    @Override
    public void onFailure(Query query, MyFindException e) {
        this.view.requestFailure(query, e);
    }

    @Override
    public void onFinish(Query query) {
        this.view.requestComplete(query);
    }


}
