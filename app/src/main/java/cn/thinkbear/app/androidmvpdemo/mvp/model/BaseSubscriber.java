package cn.thinkbear.app.androidmvpdemo.mvp.model;

import android.content.Context;
import android.content.Intent;


import java.io.IOException;

import cn.thinkbear.app.androidmvpdemo.R;
import cn.thinkbear.app.androidmvpdemo.service.ApiConstant;
import cn.thinkbear.app.androidmvpdemo.utils.MyFindException;
import cn.thinkbear.app.androidmvpdemo.vo.Response;
import rx.Subscriber;

/**
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/4/20
 */

public abstract class BaseSubscriber<T> extends Subscriber<T> {
    private Context context = null;

    public BaseSubscriber(Context context){
        this.context = context;
    }

    @Override
    public void onError(Throwable e) {
        MyFindException findException = null;
        if(e instanceof MyFindException){
            findException = (MyFindException)e;


        }else if(e instanceof IOException){
            String msg = null;
            /*
            //判断设置是否有网络操作
            if(UtilsInternetStatus.isHasNetWork(this.context)){
                msg = this.context.getString(R.string.hint_error_io);
            }else {
                msg = this.context.getString(R.string.hint_error_no_network);
            }*/
            findException = new MyFindException(ApiConstant.Error.IO_EXCEPTION,msg);
        }else{
            findException = new MyFindException(ApiConstant.Error.ORTHER,this.context.getString(R.string.hint_error_orther));
        }
        onFailure(findException);
    }

    @Override
    public void onNext(T t) {
        if(t instanceof Response){
            Response response = (Response) t;
            if(response.isSuccess()){
                onSuccess(t);
            }else{
                onError(new MyFindException(response.getState(),response.getMsg()));
            }
        }else{
            onError(new MyFindException(ApiConstant.Error.ORTHER,this.context.getString(R.string.hint_error_orther)));
        }
    }

    public abstract void onSuccess(T response);
    public abstract void onFailure(MyFindException e);
}
