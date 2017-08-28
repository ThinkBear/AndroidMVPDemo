package cn.thinkbear.app.androidmvpdemo.mvp.presenter;


import cn.thinkbear.app.androidmvpdemo.vo.Query;
import rx.Subscription;

/**
 * Presenter层
 *
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/3/25
 */
public interface IPresenter {
	/**
	 * 进行请求Api操作
	 * 会先调用 View层的 getQuery方法
	 */
	public void requestApi();

	/**
	 * 进行请求Api操作
	 *
	 * @param query 封装的请求信息
     */
	public void requestApi(Query query);

	/**
	 *
	 * @param subscription
     */
	public void addSubscription(Subscription subscription);

	/**
	 * 取消订阅
	 */
	public void unSubscription();

	/**
	 * 判断当前是否有订阅在运行
	 * @return true 表示有，false表示无
     */
	public boolean hasSubscriptionRunning();

	/**
	 * 判断当前是否有运行过订阅
	 *
	 * @return true 表示有，false表示无
     */
	public boolean hasSubscription();

	/**
	 * 取消所有订阅，通常放onDestory里调用。
	 */
	public void freed();
}
