package com.youliao.ylguquan.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.youliao.ylguquan.R;
import com.youliao.ylguquan.dataBind.MainDataBind;
import com.youliao.ylguquan.delegeate.MainActDeleges;
import com.youliao.ylguquan.modle.MainModule;
import com.youliao.ylguquan.modle.Recommends;
import com.youliao.ylguquan.themvp.databind.DataBindActivity;
import com.youliao.ylguquan.themvp.databind.DataBinder;
import com.youliao.ylguquan.util.RetrofitUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends DataBindActivity<MainActDeleges> implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //网络数据
        mSubcriber=new Subscriber<Recommends>() {
            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(MainActivity.this,"onstart",Toast.LENGTH_SHORT).show();
                viewDelegate.showProgress();
            }

            @Override
            public void onCompleted() {
                viewDelegate.hideProgress();
                Toast.makeText(MainActivity.this,"onCompleted",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(MainActivity.this,"onError"+e.getMessage(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(Recommends recommends) {
                MainModule module = new MainModule();
                module.recommends = recommends.getRecommend();
                notifyModelChanged(module);
            }
        };
        getStringHttp();
    }

    @Override
    public DataBinder getDataBinder() {

        return new MainDataBind();
    }

    @Override
    protected Class<MainActDeleges> getDelegateClass() {
        return MainActDeleges.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        viewDelegate.setOnClickListener(this, R.id.id_viewpager, R.id.tabpage_act_tpi);
    }

    @Override
    public void onClick(View v) {

    }
    private Subscriber<Recommends> mSubcriber;
    private void getStringHttp() {
        RetrofitUtils.getInstance().getRetrofit().getString().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mSubcriber);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mSubcriber!=null) {
            if (!mSubcriber.isUnsubscribed()) mSubcriber.unsubscribe();
        }
    }
}
