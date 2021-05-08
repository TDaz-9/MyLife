package com.example.administrator.mylife.http.okhttp.resp;

/**
 * Created by jane on 2016/1/8.
 */
public class BaseResp {
    private String resultcode;
    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public boolean isSuccess() {
        return resultcode.equals("200");
//        return (null != resultcode && resultcode.equals("1"));
    }
}
