package cn.yzhg.common.base.ui;

import android.content.Context;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public interface BaseView {

    //上下文
    Context getContext();

    //显示dialog弹框
    void showDialogIng();

    //隐藏弹框
    void hideDialogIng();

    void getDataFailed(String failedText, NetStateEnum type);
}
