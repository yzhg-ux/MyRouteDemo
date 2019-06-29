package com.yzhg.mvvm.bean;

import java.util.List;

/**
 * 类 名: PictureBean
 * 作 者: yzhg
 * 创 建: 2019/4/11 0011
 * 版 本: 1.0
 * 历 史: (版本) 作者 时间 注释
 * 描 述:
 */
public class PictureBean {

    /**
     * code : 200
     * message : 成功!
     * result : [{"id":671,"time":"2019-02-19 04:00:02","img":"https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg"},{"id":670,"time":"2019-02-14 04:00:01","img":"https://ws1.sinaimg.cn/large/0065oQSqly1g04lsmmadlj31221vowz7.jpg"},{"id":669,"time":"2019-01-22 04:00:01","img":"https://ws1.sinaimg.cn/large/0065oQSqgy1fze94uew3jj30qo10cdka.jpg"},{"id":668,"time":"2019-01-04 04:00:02","img":"https://ws1.sinaimg.cn/large/0065oQSqly1fytdr77urlj30sg10najf.jpg"},{"id":667,"time":"2018-12-29 04:00:00","img":"https://ws1.sinaimg.cn/large/0065oQSqly1fymj13tnjmj30r60zf79k.jpg"},{"id":666,"time":"2018-12-14 04:00:01","img":"https://ws1.sinaimg.cn/large/0065oQSqgy1fy58bi1wlgj30sg10hguu.jpg"},{"id":665,"time":"2018-11-29 04:00:00","img":"https://ws1.sinaimg.cn/large/0065oQSqgy1fxno2dvxusj30sf10nqcm.jpg"},{"id":664,"time":"2018-11-20 04:00:01","img":"https://ws1.sinaimg.cn/large/0065oQSqgy1fxd7vcz86nj30qo0ybqc1.jpg"},{"id":663,"time":"2018-11-07 04:00:01","img":"https://ws1.sinaimg.cn/large/0065oQSqgy1fwyf0wr8hhj30ie0nhq6p.jpg"},{"id":662,"time":"2018-10-23 04:00:00","img":"https://ws1.sinaimg.cn/large/0065oQSqgy1fwgzx8n1syj30sg15h7ew.jpg"},{"id":661,"time":"2018-10-16 04:00:00","img":"https://ws1.sinaimg.cn/large/0065oQSqly1fw8wzdua6rj30sg0yc7gp.jpg"},{"id":660,"time":"2018-10-09 04:00:01","img":"https://ws1.sinaimg.cn/large/0065oQSqly1fw0vdlg6xcj30j60mzdk7.jpg"},{"id":659,"time":"2018-09-22 04:00:03","img":"https://ws1.sinaimg.cn/large/0065oQSqly1fvexaq313uj30qo0wldr4.jpg"},{"id":581,"time":"2018-09-18 17:52:43","img":"http://ww1.sinaimg.cn/large/7a8aed7bgw1evdga4dimoj20qo0hsmzf.jpg"},{"id":582,"time":"2018-09-18 17:52:43","img":"http://ww3.sinaimg.cn/large/7a8aed7bgw1ev7o8srkp5j20gz0pfads.jpg"},{"id":583,"time":"2018-09-18 17:52:43","img":"http://ww4.sinaimg.cn/large/610dc034gw1ev8sy6rn52j20m80vwwj2.jpg"},{"id":584,"time":"2018-09-18 17:52:43","img":"http://ww1.sinaimg.cn/large/7a8aed7bgw1ev6jh1hbsgj20hr0qoq5s.jpg"},{"id":585,"time":"2018-09-18 17:52:43","img":"http://ww1.sinaimg.cn/large/7a8aed7bgw1ev6jgvbt8ij20qo0hrdil.jpg"},{"id":586,"time":"2018-09-18 17:52:43","img":"http://ww4.sinaimg.cn/large/610dc034gw1ev5gsdrzf0j20kp0sgdld.jpg"},{"id":587,"time":"2018-09-18 17:52:43","img":"http://ww4.sinaimg.cn/large/7a8aed7bgw1ev1yplngebj20hs0qogq0.jpg"}]
     */

    private int code;
    private String message;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 671
         * time : 2019-02-19 04:00:02
         * img : https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg
         */

        private int id;
        private String time;
        private String img;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }
}
