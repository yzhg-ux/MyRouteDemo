package cn.yzhg.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yzhg.tool.base.fragment.BasicFragment;

import cn.yzhg.common.constant.Constant;

/**
 * 类 名: MineFragment
 * 作 者: yzhg
 * 创 建: 2018/9/18 0018
 * 版 本: 1.0
 * 历 史: (版本) 作者 时间 注释
 * 描 述:
 */
@Route(path = Constant.AR_MINE_FRAGMENT)
public class MineFragment extends BasicFragment {

    private Button butCustomJavaView;
    private Button butCustomKotlinView;
    private Button butMVVM;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewLayout = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_mine, container, false);
        this.butCustomKotlinView = viewLayout.findViewById(R.id.butCustomKotlinView);
        this.butCustomJavaView = viewLayout.findViewById(R.id.butCustomJavaView);
        this.butMVVM = viewLayout.findViewById(R.id.but_MVVM);
        return viewLayout;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        butMVVM.setOnClickListener(v -> ARouter.getInstance().build(Constant.AROUTER_ACTIVITY_MVVM).navigation());
        butCustomJavaView.setOnClickListener(v -> ARouter.getInstance().build(Constant.AR_ANIM_JAVA_HOME_ACTIVITY).navigation());
        butCustomKotlinView.setOnClickListener(v -> ARouter.getInstance().build(Constant.AR_ANIM_KOTLIN_HOME_ACTIVITY).navigation(context));
    }

}
