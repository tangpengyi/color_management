package com.cf.colorm.api;

public class ResponseResult {

    private int code;//1  0
    private String msg;// 成功  失败
    private Object data;//查询成功  查询的数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
