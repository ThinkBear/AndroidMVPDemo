package cn.thinkbear.app.androidmvpdemo.mvp.presenter;


import cn.thinkbear.app.androidmvpdemo.vo.Query;
import rx.Subscription;

public interface IPresenter {
	public void requestApi();

	public void requestApi(Query query);

	public void addSubscription(Subscription subscription);

	public void unSubscription();

	public boolean hasSubscriptionRunning();

	public boolean hasSubscription();

	public void freed();
}
