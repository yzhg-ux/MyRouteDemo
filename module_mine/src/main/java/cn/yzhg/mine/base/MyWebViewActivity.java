package cn.yzhg.mine.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yzhg.tool.ui.web.CommonWebViewActivity;

import cn.yzhg.common.constant.Constant;

/**
 * 类 名: MyWebViewActivity
 * 作 者: yzhg
 * 创 建: 2019/3/22 0022
 * 版 本: 1.0
 * 历 史: (版本) 作者 时间 注释
 * 描 述:
 */
@Route(path = Constant.AR_ANIM_BASE_WEB_ACTIVITY)
public class MyWebViewActivity extends CommonWebViewActivity {
    public static final String KEY_TITLE = "KEY_TITLE";
    public static final String KEY_URL = "KEY_URL";


    private String title;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            title = bundle.getString(KEY_TITLE);
            url = bundle.getString(KEY_URL);
        }
        setTitle(title);
        webView.loadUrl(url);

        //测试加载失败点击重新加载逻辑
//        loadingFailed();
    }

    @Override
    protected void againLoad() {
        super.againLoad();
        webView.loadUrl(url);
    }
}
