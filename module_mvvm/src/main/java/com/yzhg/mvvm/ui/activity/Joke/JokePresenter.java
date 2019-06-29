package com.yzhg.mvvm.ui.activity.Joke;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.yzhg.mvvm.bean.JokeBean;
import com.yzhg.mvvm.http.ApiService;
import com.yzhg.tool.utils.common.JsonUtil;


import cn.yzhg.common.base.ui.BasePresenterImpl;
import cn.yzhg.common.base.ui.NetStateEnum;

/**
 * 类 名: JokePresenter
 * 作 者: yzhg
 * 创 建: 2019/4/10 0010
 * 版 本: 1.0
 * 历 史: (版本) 作者 时间 注释
 * 描 述:
 */
public class JokePresenter extends BasePresenterImpl<JokeContract.JokeView> implements JokeContract.JokePresenter {


    @Override
    public void getRandomJoke() {
        OkGo.
                <String>post(ApiService.jokeUrl)
                .tag(ApiService.jokeUrl)
                .params("cn_to_unicode", "1")
                .params("token", "053e5f20355a4863260f3f0e414c7ab1")
                .params("datatype", "json")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (response != null) {
                            String body = response.body();
                            JokeBean jokeBean = JsonUtil.parseJsonToBean(body, JokeBean.class);
                            if (0 == jokeBean.getErrorCode()) { //获取数据成功
                                JokeBean.ResultBean result = jokeBean.getResult();
                                if (result != null) {
                                    String content = result.getContent();
                                    mView.getJokeSuccess(content);
                                } else {
                                    mView.getDataFailed("没有查询到数据", NetStateEnum.EMPTY);
                                }
                            } else {
                                mView.getDataFailed("获取数据失败", NetStateEnum.FAILED);
                            }
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        mView.getDataFailed(response.message(), NetStateEnum.FAILED);
                    }
                });

    }
}
