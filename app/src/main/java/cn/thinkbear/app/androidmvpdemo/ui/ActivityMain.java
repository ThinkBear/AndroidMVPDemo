package cn.thinkbear.app.androidmvpdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.thinkbear.app.androidmvpdemo.R;

/**
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/8/27
 */

public class ActivityMain extends AppCompatActivity {

    private TextView infoTv;
    private Button requestBut;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        this.infoTv = (TextView) super.findViewById(R.id.infoTv);
        this.requestBut = (Button) super.findViewById(R.id.requestBut);

        this.requestBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
