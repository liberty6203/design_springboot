package com.lzy.design.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lzy.design.constcode.ResponseCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class R {

    private int status;
    private String msg;
    private Object data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public static R ok(){
        R r = new R();
        r.setStatus(ResponseCode.OK.getStatus());
        r.setMsg(ResponseCode.OK.getDesp());
        return r;
    }

    public R data(Object data){
        setData(data);
        return this;
    }

    public static R error(int code,String msg){
        R r = new R();
        r.setStatus(code);
        r.setMsg(msg);
        return r;
    }

}
