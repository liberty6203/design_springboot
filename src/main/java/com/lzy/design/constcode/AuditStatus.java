package com.lzy.design.constcode;

public enum  AuditStatus {

    NEED_FIRST_AUDIT(0,"需要第一次审核"),
    NEED_SECOND_AUDIT(1,"需要二次审核"),
    AUDIT_COMPLETE(2,"审核完成");


    private int status;
    private String desp;

    private AuditStatus(int status,String desp){
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
