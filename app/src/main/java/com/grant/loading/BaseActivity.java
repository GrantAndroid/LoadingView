package com.grant.loading;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by grant on 2018/5/15 0015.
 */

public class BaseActivity extends FragmentActivity  {


    protected Dialog mLoading;
    private AVLoadingIndicatorView mLoadingView;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);

    }

    protected void showLoading(boolean cancel){

        if(mLoading==null){
            View imageView = LayoutInflater.from(this).inflate(R.layout.loading_layout, null, false);
            mLoadingView = (AVLoadingIndicatorView)imageView.findViewById(R.id.animation_iv);
            mLoadingView.show();
            mLoading=dialog(this,imageView,R.style.TransparentDialog,0.8f,1.0f,true);
        } else if (("").equals(mLoading)) {
            mLoading.dismiss();
        }
        mLoading.dismiss();
        mLoading.show();
    }

    protected void dismissLoading(){
        if (mLoading != null) {
            mLoading.dismiss();
            mLoadingView.hide();
        }
    }

    protected Dialog dialog(Context context, View view, int style, float scale, float alpha, boolean cancel){
        final Dialog dialog=new Dialog(context,style>0?style:R.style.dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(cancel);
        dialog.setContentView(view);
        //解决dialog宽度显示与view效果不一致的问题
        Window window=dialog.getWindow();
        WindowManager.LayoutParams lp=window.getAttributes();
        if(scale>0)
            lp.width=(int) (context.getResources().getDisplayMetrics().widthPixels*scale);
        if(alpha>=0)
            lp.alpha=alpha;
        window.setGravity(Gravity.CENTER);
        window.setAttributes(lp);

        return dialog;
    }
}
