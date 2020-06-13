package com.lzy.design.dto.project;

import com.lzy.design.constcode.ProjectLevel;

public class ProjectCountDTO {

    private String year;
    private long countryCount;
    private long cityCount;
    private long schoolCount;
    private long otherCount;
    private long totalCount;

    private long countryScore;
    private long cityScore;
    private long schoolScore;
    private long otherScore;
    private long totalScore;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getCountryCount() {
        return countryCount;
    }

    public void setCountryCount(long countryCount) {
        this.countryCount = countryCount;
        this.countryScore = countryCount* ProjectLevel.COUNTRY.getScore();
    }

    public long getCityCount() {
        return cityCount;
    }

    public void setCityCount(long cityCount) {
        this.cityCount = cityCount;
        this.cityScore = cityCount*ProjectLevel.CITY.getScore();
    }

    public long getSchoolCount() {
        return schoolCount;
    }

    public void setSchoolCount(long schoolCount) {
        this.schoolCount = schoolCount;
        this.schoolScore = schoolCount*ProjectLevel.SCHOOL.getScore();
    }

    public long getOtherCount() {
        return otherCount;
    }

    public void setOtherCount(long otherCount) {
        this.otherCount = otherCount;
        this.otherScore = otherCount*ProjectLevel.OTHER.getScore();
    }

    public long getTotalCount() {
        totalCount = countryCount+cityCount+schoolCount+otherCount;
        return totalCount;
    }

    public long getCountryScore() {
        return countryScore;
    }

    public long getCityScore() {
        return cityScore;
    }

    public long getSchoolScore() {
        return schoolScore;
    }

    public long getOtherScore() {
        return otherScore;
    }

    public long getTotalScore() {
        totalScore = countryScore+cityScore+schoolScore+otherScore;
        return totalScore;
    }
}
