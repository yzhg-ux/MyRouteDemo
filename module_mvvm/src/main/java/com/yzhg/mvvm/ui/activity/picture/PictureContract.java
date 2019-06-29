package com.yzhg.mvvm.ui.activity.picture;

import com.yzhg.mvvm.bean.PictureBean;

import java.util.List;

import cn.yzhg.common.base.ui.BasePresenter;
import cn.yzhg.common.base.ui.BaseView;

/**
 * 类 名: PictureContract
 * 作 者: yzhg
 * 创 建: 2019/4/11 0011
 * 版 本: 1.0
 * 历 史: (版本) 作者 时间 注释
 * 描 述:
 */
public class PictureContract {

    interface PictureView extends BaseView {
        void pictureSuccess(List<PictureBean.ResultBean> result);
    }

    interface PicturePresenter extends BasePresenter<PictureView> {
        void getPictureIcon(String page);
    }
}
