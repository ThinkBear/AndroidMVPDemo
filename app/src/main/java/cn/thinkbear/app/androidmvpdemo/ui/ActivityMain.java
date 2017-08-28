package cn.thinkbear.app.androidmvpdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Date;

import cn.thinkbear.app.androidmvpdemo.R;
import cn.thinkbear.app.androidmvpdemo.mvp.model.extend.MExtendAndroidUpdate;
import cn.thinkbear.app.androidmvpdemo.mvp.presenter.Presenter;
import cn.thinkbear.app.androidmvpdemo.mvp.view.IView;
import cn.thinkbear.app.androidmvpdemo.utils.MyFindException;
import cn.thinkbear.app.androidmvpdemo.vo.AndroidUpdate;
import cn.thinkbear.app.androidmvpdemo.vo.Query;
import cn.thinkbear.app.androidmvpdemo.vo.Response;

/**
 * Demo
 *
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/8/27
 */

public class ActivityMain extends AppCompatActivity implements View.OnClickListener{

    private TextView infoTv;
    private Button requestBut;

    private Presenter<AndroidUpdate> pGet = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        this.infoTv = (TextView) super.findViewById(R.id.infoTv);
        this.requestBut = (Button) super.findViewById(R.id.requestBut);
        this.pGet = new Presenter<AndroidUpdate>(super.getApplicationContext(),new MExtendAndroidUpdate(),new GetCallback());
        this.requestBut.setOnClickListener(this);
        this.infoTv.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    public void appendInfo(String msg){
        if(msg == null){
            return;
        }
        this.infoTv.append(msg);
        this.infoTv.append("\n");
    }

    @Override
    public void onClick(View v) {
        if(pGet.hasSubscriptionRunning()){
            appendInfo("####当前已有请求在执行。。");
            return;
        }
        infoTv.setText("");
        appendInfo("A：开始请求Api");
        pGet.requestApi();
    }

    private class GetCallback implements IView<AndroidUpdate>{

        @Override
        public Query getQuery() {
            appendInfo("B：设置相关请求参数，若返回null，则停止调用");
            Query query = new Query();
            query.setId_int(1234);
            return query;
        }

        @Override
        public void requestStart(Query query) {
            appendInfo("C：网络请求真正开始。。");
        }

        @Override
        public void requestSuccess(Query query, Response<AndroidUpdate> response) {
            appendInfo("D：Api请求成功，接收的数据："+new Gson().toJson(response));
        }

        @Override
        public void requestFailure(Query query, MyFindException e) {
            appendInfo("E：Api请求失败，发生错误："+e.getMessage());
        }

        @Override
        public void requestComplete(Query query) {
            appendInfo("F：Api请求结束。。。");
            appendInfo("\n");
        }
    }

    @Override
    protected void onDestroy() {
        this.pGet.freed();
        super.onDestroy();
    }
}
