package com.lzy.design.constcode;

public enum RoleCode {
    USER(0,"user"),
    DEPARTMENT_ADMIN(1,"department_admin"),
    SYSTEM_ADMIN(2,"system_admin");

    private int roleCode;
    private String roleDesp;

    RoleCode(int roleCode, String roleDesp) {
        this.roleCode = roleCode;
        this.roleDesp = roleDesp;
    }

    public int getRoleCode() {
        return roleCode;
    }

    public String  getRoleDesp() {
        return roleDesp;
    }

    public static String getDesp(int code){
        String ret;
        switch(code){
            case 0: ret = USER.getRoleDesp();break;
            case 1: ret = DEPARTMENT_ADMIN.getRoleDesp();break;
            case 2: ret = SYSTEM_ADMIN.getRoleDesp();break;
            default: ret = "error";
        }
        return ret;
    }
}
