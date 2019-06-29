package com.yzhg.mvvm;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yzhg.mvvm.databinding.ActivityMvvmBinding;
import com.yzhg.mvvm.ui.activity.Joke.JokeActivity;
import com.yzhg.mvvm.ui.activity.picture.PictureActivity;


import cn.yzhg.common.constant.Constant;

/**
 * 类 名: MVVMActivity
 * 作 者: yzhg
 * 创 建: 2019/4/2 0002
 * 版 本: 1.0
 * 历 史: (版本) 作者 时间 注释
 * 描 述:
 */
@Route(path = Constant.AROUTER_ACTIVITY_MVVM)
public class MVVMActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        binding.setClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        //点击笑话大全
        if (i == R.id.But_Joke) {
            JokeActivity.newInstance(this);
        } else if (i == R.id.But_Picture) {
            PictureActivity.newInstance(this);
        }
    }
}
