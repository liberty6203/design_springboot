package com.lzy.design.constcode;

public enum  ProjectLevel {

    COUNTRY(1,"国家级",20),
    CITY(2,"省部级",18),
    SCHOOL(3,"校级",16),
    OTHER(4,"其他",10);


    private int status;
    private String desp;
    private int score;

    ProjectLevel(int status, String desp, int score) {
        this.status = status;
        this.desp = desp;
        this.score = score;
    }

    public int getStatus() {
        return status;
    }

    public String getDesp() {
        return desp;
    }

    public int getScore() {
        return score;
    }
}
