package com.lzy.design.constcode;

public enum SessionAttribute {

    PWD_MODIFY_CODE("pwd_modify_code"),
    USER_INFO("user_info");

    private String attribute;

    SessionAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }
}
