package com.lzy.design.po;

public class ProjectCount {

    private int pId;
    private String year;
    private String level;
    private int count;

    public ProjectCount() {
    }

    public ProjectCount(int pId, String year, String level, int count) {
        this.pId = pId;
        this.year = year;
        this.level = level;
        this.count = count;
    }

    @Override
    public String toString() {
        return "ProjectCount{" +
                "pId=" + pId +
                ", year='" + year + '\'' +
                ", level='" + level + '\'' +
                ", count=" + count +
                '}';
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
