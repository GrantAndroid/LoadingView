package com.grant.loading;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnone:
                showLoading(false);//加载动画
//                dismissLoading();//取消动画
                break;

        }
    }
}
