package cn.yzhg.shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;

import cn.yzhg.common.constant.Constant;

/**
 * 类 名: MineFragment
 * 作 者: yzhg
 * 创 建: 2018/9/18 0018
 * 版 本: 1.0
 * 历 史: (版本) 作者 时间 注释
 * 描 述:
 */
@Route(path = Constant.AR_SHOP_FRAGMENT)
public class ShopFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_shop, container, false);
        return view;
    }
}
