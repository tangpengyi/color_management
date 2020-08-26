package com.cf.colorm.api;

public class CommonsResult {

    public static ResponseResult result = new ResponseResult();

    public static ResponseResult getSuccessResult(String msg){
        result.setCode(1);
        result.setMsg(msg);
        return result;
    }

    public static ResponseResult getSuccessResult(String msg,Object obj){
        result.setCode(1);
        result.setMsg(msg);
        result.setData(obj);
        return result;
    }

    public static ResponseResult getFialResult(String msg){
        result.setCode(0);
        result.setMsg(msg);
        return result;
    }

    public static ResponseResult getFialResult(String msg,Object obj){
        result.setCode(0);
        result.setMsg(msg);
        result.setData(obj);
        return result;
    }

}
