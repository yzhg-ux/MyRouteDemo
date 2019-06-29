package cn.yzhg.common.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.HttpHeaders;
import com.yzhg.tool.http.tools.ResponseLogInterceptor;
import com.yzhg.tool.utils.Tools;

import java.util.concurrent.TimeUnit;

import cn.yzhg.common.constant.Constant;
import okhttp3.OkHttpClient;

/**
 * 类 名: BaseApplication
 * 作 者: yzhg
 * 创 建: 2018/9/17 0017
 * 版 本: 1.0
 * 历 史: (版本) 作者 时间 注释
 * 描 述:
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化工具类
        Tools.init(getApplicationContext());
        initOkGo();
        //打印日志}
        ARouter.openLog();
        //开启调试模式
        ARouter.openDebug();
        //初始化
        ARouter.init(this);
    }


    /**
     * 初始化OkGo
     * <p>
     * 用于请求  网络支付
     * ERP支付
     */
    private void initOkGo() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new ResponseLogInterceptor());
        builder.retryOnConnectionFailure(false);
        builder.readTimeout(Constant.DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
        builder.writeTimeout(Constant.DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
        builder.connectTimeout(Constant.DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
        //  builder.cookieJar(new CookieJarImpl(new DBCookieStore(this))); //自动管理cookie
        HttpHeaders headers = new HttpHeaders();
        headers.put("content-type", "application/json");
        headers.toJSONString();
        try {
            // 其他统一的配置
            // 详细说明看GitHub文档：https://github.com/jeasonlzy/
            OkGo.getInstance().init(this)                           //必须调用初始化
                    .setOkHttpClient(builder.build())               //建议设置OkHttpClient，不设置会使用默认的
                    .setCacheMode(CacheMode.NO_CACHE)               //全局统一缓存模式，默认不使用缓存，可以不传
                    //可以全局统一设置缓存模式,默认是不使用缓存,可以不传,
                    .setCacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                    .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)   //全局统一缓存时间，默认永不过期，可以不传
                    .setRetryCount(3) //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
                    .addCommonHeaders(headers); //设置全局公共头
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
