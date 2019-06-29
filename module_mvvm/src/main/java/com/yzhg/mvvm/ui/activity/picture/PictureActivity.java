package com.yzhg.mvvm.ui.activity.picture;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.yzhg.mvvm.R;
import com.yzhg.mvvm.bean.PictureBean;
import com.yzhg.mvvm.databinding.ActivityPictureBinding;
import com.yzhg.mvvm.ui.adapter.PictureAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.yzhg.common.base.ui.MVPBaseActivity;
import cn.yzhg.common.base.ui.NetStateEnum;

/**
 * 类 名: PictureActivity
 * 作 者: yzhg
 * 创 建: 2019/4/11 0011
 * 版 本: 1.0
 * 历 史: (版本) 作者 时间 注释
 * 描 述:
 */
public class PictureActivity extends MVPBaseActivity<PictureContract.PictureView, PicturePresenter> implements PictureContract.PictureView {
    private List<PictureBean.ResultBean> iconStr = new ArrayList<>();
    private PictureAdapter pictureAdapter;

    //开启Activity
    public static void newInstance(Context context) {
        Intent intent = new Intent(context, PictureActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPictureBinding pictureBinding = DataBindingUtil.setContentView(this, R.layout.activity_picture);

        RecyclerView picture = findViewById(R.id.Recycle_Picture);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        picture.setLayoutManager(new LinearLayoutManager(this));
        pictureAdapter = new PictureAdapter(this, iconStr);
        picture.setAdapter(pictureAdapter);
        mPresenter.getPictureIcon("1");
    }


    @Override
    public void pictureSuccess(List<PictureBean.ResultBean> result) {
        iconStr.addAll(result);
        pictureAdapter.notifyDataSetChanged();
    }

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

}
