package com.youliao.ylguquan.delegeate;

import android.support.v4.view.ViewPager;
import android.util.Log;

import com.yinglan.alphatabs.AlphaTabsIndicator;
import com.youliao.ylguquan.R;
import com.youliao.ylguquan.api.ApiService;
import com.youliao.ylguquan.themvp.view.AppDelegate;

import butterknife.BindView;

/**
 * Created by admin on 2017/3/21.
 */

public class MainActDeleges extends AppDelegate {
    @BindView(R.id.id_viewpager)
    ViewPager idViewpager;
    @BindView(R.id.tabpage_act_tpi)
    AlphaTabsIndicator tabpageActTpi;

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void  showProgress() {
        Log.d(ApiService.tag, "showProgress: ");

    }

    @Override
    public void hideProgress() {
        Log.d(ApiService.tag, "hideProgress: ");
    }

    @Override
    public void onEmpty() {
        super.onEmpty();
    }

    @Override
    public void onError() {
        super.onError();
    }

    @Override
    public void onNetWorkDisConnect() {
        super.onNetWorkDisConnect();
    }

    @Override
    public void initWidget() {
        super.initWidget();
    }
}
