package cn.yzhg.mine.anim.kotlin

import android.os.Bundle
import cn.yzhg.common.constant.Constant
import cn.yzhg.mine.R
import com.alibaba.android.arouter.facade.annotation.Route
import com.yzhg.tool.base.activity.BasicActivity

/**
 * 类 名: KotlinAnimHomeActivity
 * 作 者: yzhg
 * 创 建: 2019/7/4 0004
 * 版 本: 4.1.0
 * 历 史: (版本) 作者 时间 注释
 * 描 述:
 */
@Route(path = Constant.AR_ANIM_KOTLIN_HOME_ACTIVITY)
class KotlinAnimHomeActivity : BasicActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_anim_home)
    }
}