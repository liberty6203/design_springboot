package com.lzy.design.constcode;

public enum ResponseCode {

    OK(200,"正常"),

//    请求错误
    BAD_REQUEST(400,"参数错误"),
    UNAUTHORIZED(401,"未登录"),
    FORBIDDEN(403,"没有权限"),
    NOT_FOUND(404,"资源不存在"),
    CLIENT_ERROR(405,"客户端错误"),
    UNKNOWN_ACCOUNT(406,"用户不存在"),
    INCORRECT_CREDENTIAL(407,"用户名或密码错误"),

    ERROR(500,"内部错误"),


    ;


    private int status;
    private String desp;

    private ResponseCode(int status, String desp){
        this.status = status;
        this.desp = desp;
    }

    public int getStatus() {
        return status;
    }

    public String getDesp() {
        return desp;
    }
}
