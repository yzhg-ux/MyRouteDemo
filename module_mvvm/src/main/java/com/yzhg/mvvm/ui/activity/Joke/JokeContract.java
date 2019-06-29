package com.yzhg.mvvm.ui.activity.Joke;


import cn.yzhg.common.base.ui.BasePresenter;
import cn.yzhg.common.base.ui.BaseView;

/**
 * 类 名: JokeContract
 * 作 者: yzhg
 * 创 建: 2019/4/10 0010
 * 版 本: 1.0
 * 历 史: (版本) 作者 时间 注释
 * 描 述:
 */
public class JokeContract {

    interface JokeView extends BaseView {
        void getJokeSuccess(String jokeText);
    }

    interface JokePresenter extends BasePresenter<JokeView> {
        void getRandomJoke();
    }

}
