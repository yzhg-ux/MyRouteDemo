package com.yzhg.mvvm.ui.activity.picture;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.yzhg.mvvm.bean.PictureBean;
import com.yzhg.mvvm.http.ApiService;
import com.yzhg.tool.utils.common.JsonUtil;

import java.util.List;

import cn.yzhg.common.base.ui.BasePresenterImpl;
import cn.yzhg.common.base.ui.NetStateEnum;

/**
 * 类 名: PicturePresenter
 * 作 者: yzhg
 * 创 建: 2019/4/11 0011
 * 版 本: 1.0
 * 历 史: (版本) 作者 时间 注释
 * 描 述:
 */
public class PicturePresenter extends BasePresenterImpl<PictureContract.PictureView> implements PictureContract.PicturePresenter {


    @Override
    public void getPictureIcon(String page) {
        OkGo.<String>
                post(ApiService.PictureUrl)
                .tag(ApiService.jokeUrl)
                .params("page", page)
                .params("count", "20")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        PictureBean pictureBean = JsonUtil.parseJsonToBean(body, PictureBean.class);
                        if (200 == pictureBean.getCode()) {
                            List<PictureBean.ResultBean> result = pictureBean.getResult();
                            if (result != null && result.size() > 0) {
                                mView.pictureSuccess(result);
                            } else {
                                mView.getDataFailed("没有数据", NetStateEnum.EMPTY);
                            }
                        } else {
                            mView.getDataFailed("获取数据失败", NetStateEnum.FAILED);
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        mView.getDataFailed(response.message(), NetStateEnum.FAILED);
                    }
                });
    }
}
