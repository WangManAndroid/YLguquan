package com.youliao.ylguquan.dataBind;

import android.util.Log;

import com.youliao.ylguquan.api.ApiService;
import com.youliao.ylguquan.delegeate.MainActDeleges;
import com.youliao.ylguquan.modle.MainModule;
import com.youliao.ylguquan.themvp.databind.DataBinder;

/**
 * Created by admin on 2017/3/21.
 */

public class MainDataBind implements DataBinder<MainActDeleges,MainModule> {
    @Override
    public void viewBindModel(MainActDeleges viewDelegate, MainModule data) {
        Log.d(ApiService.tag, "viewBindModel: "+data.recommends.toString());
    }
}
