package com.lzy.design.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TreatiseAudit {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treatise_audit.ad_id
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    private Integer adId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treatise_audit.t_id
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    private Integer tId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treatise_audit.audit_opinion_reason
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    private String auditOpinionReason;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treatise_audit.audit_opinion
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    private Integer auditOpinion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treatise_audit.audit_time
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date auditTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treatise_audit.ad_id
     *
     * @return the value of treatise_audit.ad_id
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    public Integer getAdId() {
        return adId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treatise_audit.ad_id
     *
     * @param adId the value for treatise_audit.ad_id
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treatise_audit.t_id
     *
     * @return the value of treatise_audit.t_id
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    public Integer gettId() {
        return tId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treatise_audit.t_id
     *
     * @param tId the value for treatise_audit.t_id
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    public void settId(Integer tId) {
        this.tId = tId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treatise_audit.audit_opinion_reason
     *
     * @return the value of treatise_audit.audit_opinion_reason
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    public String getAuditOpinionReason() {
        return auditOpinionReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treatise_audit.audit_opinion_reason
     *
     * @param auditOpinionReason the value for treatise_audit.audit_opinion_reason
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    public void setAuditOpinionReason(String auditOpinionReason) {
        this.auditOpinionReason = auditOpinionReason == null ? null : auditOpinionReason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treatise_audit.audit_opinion
     *
     * @return the value of treatise_audit.audit_opinion
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    public Integer getAuditOpinion() {
        return auditOpinion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treatise_audit.audit_opinion
     *
     * @param auditOpinion the value for treatise_audit.audit_opinion
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    public void setAuditOpinion(Integer auditOpinion) {
        this.auditOpinion = auditOpinion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treatise_audit.audit_time
     *
     * @return the value of treatise_audit.audit_time
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treatise_audit.audit_time
     *
     * @param auditTime the value for treatise_audit.audit_time
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }
}