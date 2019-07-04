package cn.yzhg.main.ui.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.launcher.ARouter;
import com.dcloud.update.UpdateSDK;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.ButterKnife;
import cn.yzhg.common.constant.Constant;
import cn.yzhg.main.R;

public class Main2Activity extends AppCompatActivity {

    private FrameLayout mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        int id = item.getItemId();
        if (id == R.id.navigation_home) {
            /*
             * 作 者: yzhg
             * 历 史: (版本) 1.0
             * 描 述: 找到homeFragment
             */
            Fragment fragment = (Fragment) ARouter.getInstance().build(Constant.AR_HOME_FRAGMENT).navigation();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.message, fragment);
            fragmentTransaction.commit();
            return true;
        } else if (id == R.id.navigation_dashboard) {
            Fragment fragment = (Fragment) ARouter.getInstance().build(Constant.AR_SHOP_FRAGMENT).navigation();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.message, fragment);
            fragmentTransaction.commit();
            return true;
        } else if (id == R.id.navigation_person) {
            Fragment fragment = (Fragment) ARouter.getInstance().build(Constant.AR_MINE_FRAGMENT).navigation();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.message, fragment);
            fragmentTransaction.commit();
            return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        //检查更新
        //   new UpdateSDK().check(this);

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Fragment fragment = (Fragment) ARouter.getInstance().build(Constant.AR_HOME_FRAGMENT).navigation();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.message, fragment);
        fragmentTransaction.commit();
    }
}
