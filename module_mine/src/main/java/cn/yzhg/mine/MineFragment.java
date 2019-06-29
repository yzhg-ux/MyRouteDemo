package cn.yzhg.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import cn.yzhg.common.constant.Constant;

/**
 * 类 名: MineFragment
 * 作 者: yzhg
 * 创 建: 2018/9/18 0018
 * 版 本: 1.0
 * 历 史: (版本) 作者 时间 注释
 * 描 述:
 */
@Route(path = "/mine/MineFragment")
public class MineFragment extends Fragment {

    private Button butMvvm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_mine, container, false);
        butMvvm = view.findViewById(R.id.but_MVVM);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        butMvvm.setOnClickListener(v -> ARouter.getInstance().build(Constant.AROUTER_ACTIVITY_MVVM).navigation());
    }
}
