package com.yzhg.mvvm.bean;

/**
 * 类 名: JokeBean
 * 作 者: yzhg
 * 创 建: 2019/4/11 0011
 * 版 本: 1.0
 * 历 史: (版本) 作者 时间 注释
 * 描 述:
 */
public class JokeBean {


    /**
     * ApiName : joke
     * ErrorCode : 0
     * ErrorReason : no
     * Result : {"content":"一位顾客准备在一家瑞士银行里开户。工作人员问道：您准备存多少？  顾客觉得这笔现金太多，怕引贼人注意，他环顾四周，小声说道：五百万美元。  工作人员答道：先生，您完全可以大声说话。在瑞士，贫穷不是过错\u2026\u2026"}
     */

    private String ApiName;
    private int ErrorCode;
    private String ErrorReason;
    private ResultBean Result;

    public String getApiName() {
        return ApiName;
    }

    public void setApiName(String ApiName) {
        this.ApiName = ApiName;
    }

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public String getErrorReason() {
        return ErrorReason;
    }

    public void setErrorReason(String ErrorReason) {
        this.ErrorReason = ErrorReason;
    }

    public ResultBean getResult() {
        return Result;
    }

    public void setResult(ResultBean Result) {
        this.Result = Result;
    }

    public static class ResultBean {
        /**
         * content : 一位顾客准备在一家瑞士银行里开户。工作人员问道：您准备存多少？  顾客觉得这笔现金太多，怕引贼人注意，他环顾四周，小声说道：五百万美元。  工作人员答道：先生，您完全可以大声说话。在瑞士，贫穷不是过错……
         */

        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
