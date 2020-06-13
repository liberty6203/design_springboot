package com.lzy.design.dto.treatise;

import com.lzy.design.constcode.TreatiseLevel;

public class TreatiseCountDTO {

    private String year;
    private long eiCount;
    private long sciCount;
    private long coreCount;
    private long commonJournalCount;
    private long otherCount;
    private long totalCount;

    private long eiScore;
    private long sciScore;
    private long coreScore;
    private long commonJournalScore;
    private long otherScore;
    private long totalScore;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getCoreCount() {
        return coreCount;
    }

    public void setCoreCount(long coreCount) {
        this.coreCount = coreCount;
        this.coreScore = coreCount* TreatiseLevel.CORE.getScore();
    }

    public long getEiCount() {
        return eiCount;
    }

    public void setEiCount(long eiCount) {
        this.eiCount = eiCount;
        this.eiScore = eiCount*TreatiseLevel.EI.getScore();
    }

    public long getSciCount() {
        return sciCount;
    }

    public void setSciCount(long sciCount) {
        this.sciCount = sciCount;
        this.sciScore = sciCount*TreatiseLevel.SCI.getScore();
    }

    public long getCommonJournalCount() {
        return commonJournalCount;
    }

    public void setCommonJournalCount(long commonJournalCount) {
        this.commonJournalCount = commonJournalCount;
        this.commonJournalScore = commonJournalCount*TreatiseLevel.COMMON_JOURNALS.getScore();
    }

    public long getOtherCount() {
        return otherCount;
    }

    public void setOtherCount(long otherCount) {
        this.otherCount = otherCount;
        this.otherScore = otherCount*TreatiseLevel.OTHER.getScore();
    }

    public long getTotalCount() {
        totalCount = eiCount+sciCount+commonJournalScore+coreCount+otherCount;
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getEiScore() {
        return eiScore;
    }

    public long getSciScore() {
        return sciScore;
    }

    public long getCoreScore() {
        return coreScore;
    }

    public long getCommonJournalScore() {
        return commonJournalScore;
    }

    public long getOtherScore() {
        return otherScore;
    }

    public long getTotalScore() {
        totalScore = eiScore+sciScore+coreScore+commonJournalScore+otherScore;
        return totalScore;
    }
}
