package cn.yzhg.route;

import com.dcloud.update.UpdateSDK;

import cn.yzhg.common.application.BaseApplication;
import cn.yzhg.common.constant.Constant;

/**
 * 类 名: MyApplication
 * 作 者: yzhg
 * 创 建: 2018/9/18 0018
 * 版 本: 1.0
 * 历 史: (版本) 作者 时间 注释
 * 描 述:
 */


public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化第八区APPKey
        UpdateSDK.init(Constant.UPDATE_APP_KEY);
    }
}
