package com.lzy.design.constcode;

public enum TreatiseLevel {

    EI(1,20),
    SCI(2,18),
    CORE(3,16),
    COMMON_JOURNALS(5,14),
    OTHER(4,10),
    ;


    private int code;
    private int score;

    TreatiseLevel(int code, int score) {
        this.code = code;
        this.score = score;
    }

    public int getCode() {
        return code;
    }

    public int getScore() {
        return score;
    }
}
