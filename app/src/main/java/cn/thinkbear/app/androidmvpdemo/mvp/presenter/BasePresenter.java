package cn.thinkbear.app.androidmvpdemo.mvp.presenter;

import rx.Subscription;

public abstract class BasePresenter implements IPresenter{
	private ManagerSubscription subscriptions = null;
	
	public BasePresenter(){
		this.subscriptions = new ManagerSubscription();
	}
	
	@Override
	public void addSubscription(Subscription subscription){
		this.subscriptions.add(subscription);
	}
	@Override
	public void unSubscription(){
		this.subscriptions.unsubscribe();
	}
	@Override
	public boolean hasSubscriptionRunning(){
		return this.subscriptions.hasSubscriptionRunning();
	}

	@Override
	public boolean hasSubscription() {
		return this.subscriptions.hasSubscriptions();
	}

	@Override
	public void freed(){
		this.subscriptions.clear();
	}
	
	
	
}
