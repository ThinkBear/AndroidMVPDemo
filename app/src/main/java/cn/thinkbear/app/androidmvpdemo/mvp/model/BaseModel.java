package cn.thinkbear.app.androidmvpdemo.mvp.model;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import cn.thinkbear.app.androidmvpdemo.service.ApiConstant;
import cn.thinkbear.app.androidmvpdemo.service.api.IApiExtend;
import cn.thinkbear.app.androidmvpdemo.utils.MyFindException;
import cn.thinkbear.app.androidmvpdemo.vo.Query;
import cn.thinkbear.app.androidmvpdemo.vo.Response;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/3/25
 */

public abstract class BaseModel<T> implements IModel<T>{

    private Retrofit retrofit = null;

    private IApiExtend apiExtend = null;

    private IModelCallback callback = null;
    private Context context = null;


    public BaseModel() {


        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.connectTimeout(ApiConstant.TIMEOUT_CONNECT, TimeUnit.MILLISECONDS); //设置连接超时时间
        builder.readTimeout(ApiConstant.TIMEOUT_READ, TimeUnit.MILLISECONDS); // 设置读超时时间

        //builder.addInterceptor(new VersionInterceptor()); // 设置拦截器，可用于设置统一请求参数、头信息、打印请求信息等操作
        /*
        //对cookie的相关操作，如果请求涉及到cookie的相关操作，可设置此方法
        builder.cookieJar(new CookieJar() {
            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                //可进行相关缓存到本地操作
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                //可进行将本地的cookie信息设置到请求头信息里
            }
        });
        */

        OkHttpClient client = builder.build();

        //创建Retrofit对象
        this.retrofit = new Retrofit.Builder()
                .client(client) //设置OKHttpClien对象
                .baseUrl(ApiConstant.BASE_URL) //设置网络请求基地址
                .addConverterFactory(GsonConverterFactory.create()) //添加转换器工厂，使用Gson转换
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //添加访问适配器工厂，支持Observable，即RxJava
                .build();

    }

    public Retrofit getRetrofit() {
        return this.retrofit;
    }


    public IApiExtend getApiExtend(){
        if(this.apiExtend == null){
            this.apiExtend = this.retrofit.create(IApiExtend.class);
        }
        return this.apiExtend;
    }

    @Override
    public Subscription requestQuery(final Query query) {
        Observable<Response<T>> request = getObservable(query);
        Subscription subscription = request.delay(this.getDelay(), TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new BaseSubscriber<Response<T>>(this.context) {
            @Override
            public void onCompleted() {
                callback.onFinish(query);
            }

            @Override
            public void onSuccess(Response<T> response) {
                callback.onSuccess(query, response);
            }

            @Override
            public void onFailure(MyFindException e) {
                callback.onFailure(query, e);
                onCompleted();
            }

        });

        return subscription;
    }

    @Override
    public void initModel(IModelCallback<T> callback, Context context) {
        this.callback = callback;
        this.context = context;
    }

    public abstract Observable<Response<T>> getObservable(Query query);


    public int getDelay(){
        return 500;
    }
}
