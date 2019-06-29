package com.yzhg.mvvm.ui.activity.Joke;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.yzhg.mvvm.R;
import com.yzhg.mvvm.databinding.ActivityJokeBinding;


import cn.yzhg.common.base.ui.MVPBaseActivity;
import cn.yzhg.common.base.ui.NetStateEnum;

/**
 * 类 名: JokeActivity
 * 作 者: yzhg
 * 创 建: 2019/4/10 0010
 * 版 本: 1.0
 * 历 史: (版本) 作者 时间 注释
 * 描 述:
 */
public class JokeActivity extends MVPBaseActivity<JokeContract.JokeView, JokePresenter> implements JokeContract.JokeView, View.OnClickListener {

    //默认笑话
    private String textResult = "小时候放学的时候路过庄稼地旁的一个大粪坑。粪坑对面有条狗，我同学说：咦，好像我家狗！于是喊了一声狗的名字……神奇的一幕出现了，狗狗扑通一声跳进粪池，奋力向我同学游来！我同学大喊一声：于是，这样一副毕生难忘的画面出现了……一个少年在前面没命的跑，一个满身粪便的狗狗摇着尾巴在后面欢快的追……终于狗狗如愿以偿的扑进了小主人的怀抱……";
    //DataBinding
    private ActivityJokeBinding dataBinding;

    //开启Activity
    public static void newInstance(Context context) {
        Intent intent = new Intent(context, JokeActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定布局
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_joke);

        //设置监听事件
        dataBinding.setAgainListener(this);

        SpannableStringBuilder spannableText = spannableText(textResult);
        //设置text数据
        dataBinding.setJokeText(spannableText);
        //访问P层数据
        mPresenter.getRandomJoke();
    }


    @Override
    public void onClick(View v) {
        mPresenter.getRandomJoke();
    }

    /**
     * 作 者: yzhg
     * 历 史: (版本) 1.0 
     * 描 述: 获取数据成功展示
     */
    @Override
    public void getJokeSuccess(String jokeText) {
        //设置text数据
        SpannableStringBuilder spannableText = spannableText(jokeText);
        //访问P层数据
        dataBinding.setJokeText(spannableText);
    }
    
    /**
     * 作 者: yzhg
     * 历 史: (版本) 1.0 
     * 描 述: 数据获取失败
     */
    @Override
    public void getDataFailed(String failedText, NetStateEnum type) {
        Toast.makeText(this, failedText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialogIng() {
        showBaseDialogIng();
    }

    @Override
    public void hideDialogIng() {
        hideBaseDialogIng();
    }

    private SpannableStringBuilder spannableText(String text) {
        SpannableStringBuilder span = new SpannableStringBuilder("缩进" + Html.fromHtml(text));
        span.setSpan(new ForegroundColorSpan(Color.TRANSPARENT), 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return span;
    }
}














