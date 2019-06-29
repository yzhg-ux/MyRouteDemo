package cn.yzhg.common.base.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yzhg.tool.utils.common.CustomDialog;

import java.lang.reflect.ParameterizedType;

import cn.yzhg.common.R;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public abstract class MVPBaseActivity<V extends BaseView, T extends BasePresenterImpl<V>> extends AppCompatActivity implements BaseView {

    private CustomDialog showLoding;
    public T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDialogInd();
        mPresenter = getInstance(this, 1);
        mPresenter.attachView((V) this);
    }


    @Override
    public Context getContext() {
        return this;
    }

    public <T> T getInstance(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass().getGenericSuperclass())).getActualTypeArguments()[i]).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 作 者: yzhg
     * 历 史: (版本) 1.0
     * 描 述: 初始化Dialog弹框
     */
    private void initDialogInd() {
        if (showLoding != null && !showLoding.isShowing()) {
            showLoding = new
                    CustomDialog.Builder(this)
                    .setView(R.layout.load_dialog)
                    .setStyle(R.style.MyDialogTheme)
                    .setAnimation(R.style.dialogAnimation)
                    .setGravity(Gravity.CENTER)
                    .build();
        }
    }

    /**
     * 作 者: yzhg
     * 历 史: (版本) 1.0
     * 描 述: 显示弹框
     */
    public void showBaseDialogIng() {
        if (showLoding != null && !showLoding.isShowing()) {
            showLoding.show();
        }
    }

    /**
     * 作 者: yzhg
     * 历 史: (版本) 1.0
     * 描 述: 隐藏弹框
     */
    public void hideBaseDialogIng() {
        if (showLoding != null && showLoding.isShowing()) {
            showLoding.dismiss();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (showLoding != null && showLoding.isShowing()) showLoding.dismiss();
        if (mPresenter != null)
            mPresenter.detachView();
    }
}










