package cn.yzhg.mine.anim.java;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yzhg.tool.base.activity.BasicActivity;
import com.yzhg.tool.utils.Tools;

import cn.yzhg.common.constant.Constant;
import cn.yzhg.common.weight.ToolBarView;
import cn.yzhg.mine.R;
import cn.yzhg.mine.base.MyWebViewActivity;

/**
 * 类 名: JavaAnimHomeActivity
 * 作 者: yzhg
 * 创 建: 2019/7/3 0003
 * 版 本: 4.1.0
 * 历 史: (版本) 作者 时间 注释
 * 描 述:  java版本  主页面
 */
@Route(path = Constant.AR_ANIM_JAVA_HOME_ACTIVITY)
public class JavaAnimHomeActivity extends BasicActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_anim_home);

        initView();
    }

    private void initView() {
        ToolBarView customView = findViewById(R.id.tbvCustomView);
        customView.setOnRightClick(this::rightClick);
    }

    private void rightClick() {
        Tools.openBrowser(this, "https://blog.csdn.net/harvic880925/article/details/50995268");
    }
}
