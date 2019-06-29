package com.yzhg.mvvm.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yzhg.mvvm.R;
import com.yzhg.mvvm.bean.PictureBean;
import com.yzhg.tool.utils.common.LogUtils;

import java.util.List;


/**
 * 类 名: PictureAdapter
 * 作 者: yzhg
 * 创 建: 2019/4/11 0011
 * 版 本: 1.0
 * 历 史: (版本) 作者 时间 注释
 * 描 述:
 */
public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {

    private List<PictureBean.ResultBean> iconStr;
    private Context context;

    public PictureAdapter(Context context, List<PictureBean.ResultBean> iconStr) {
        this.context = context;
        this.iconStr = iconStr;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_picture_icon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LogUtils.d("--------------加载图片" + iconStr.get(position).getImg());
        Glide.with(context).load(iconStr.get(position).getImg()).into(holder.ivIcon);
    }

    @Override
    public int getItemCount() {
        return iconStr.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.IvPictureIcon);
        }
    }
}
