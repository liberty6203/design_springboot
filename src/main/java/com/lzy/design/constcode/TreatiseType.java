package com.lzy.design.constcode;

public enum TreatiseType {

    DRGREE(0),
    JOURNALS(1),
    MEETINGS(2),
    OTHER(3)
    ;

    private int code;

    TreatiseType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
