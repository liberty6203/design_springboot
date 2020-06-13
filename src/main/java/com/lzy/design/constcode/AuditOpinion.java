package com.lzy.design.constcode;

public enum  AuditOpinion {

    AUDIT_PASS(0,"审核通过"),
    AUDIT_BLOCKED(1,"审核未通过");


    private int auditStatus;
    private String desp;

    private AuditOpinion(int auditStatus, String desp) {
        this.auditStatus = auditStatus;
        this.desp = desp;
    }

    public int getAuditStatus() {
        return auditStatus;
    }

    public String getDesp() {
        return desp;
    }

    public static boolean opinionExist(int auditStatus){
        boolean exist = false;
        for (AuditOpinion a: AuditOpinion.values() ) {
            if (a.getAuditStatus() == auditStatus){
                exist = true;
                break;
            }
        }
        return exist;
    }
}
