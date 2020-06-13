package com.lzy.design.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Project {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.id
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.p_id
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    private Integer pId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.title
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.audit_status
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    private Integer auditStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.create_time
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.update_time
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.first_audit_time
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date firstAuditTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.second_audit_time
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date secondAuditTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.subject
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    private String subject;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.department
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    private String department;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.level
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    private String level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.money
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    private Float money;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.start_time
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date startTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.end_time
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date endTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.introduction
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    private String introduction;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.year
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    private String year;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.id
     *
     * @return the value of project.id
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.id
     *
     * @param id the value for project.id
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.p_id
     *
     * @return the value of project.p_id
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public Integer getpId() {
        return pId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.p_id
     *
     * @param pId the value for project.p_id
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public void setpId(Integer pId) {
        this.pId = pId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.title
     *
     * @return the value of project.title
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.title
     *
     * @param title the value for project.title
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.audit_status
     *
     * @return the value of project.audit_status
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.audit_status
     *
     * @param auditStatus the value for project.audit_status
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.create_time
     *
     * @return the value of project.create_time
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.create_time
     *
     * @param createTime the value for project.create_time
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.update_time
     *
     * @return the value of project.update_time
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.update_time
     *
     * @param updateTime the value for project.update_time
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.first_audit_time
     *
     * @return the value of project.first_audit_time
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public Date getFirstAuditTime() {
        return firstAuditTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.first_audit_time
     *
     * @param firstAuditTime the value for project.first_audit_time
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public void setFirstAuditTime(Date firstAuditTime) {
        this.firstAuditTime = firstAuditTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.second_audit_time
     *
     * @return the value of project.second_audit_time
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public Date getSecondAuditTime() {
        return secondAuditTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.second_audit_time
     *
     * @param secondAuditTime the value for project.second_audit_time
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public void setSecondAuditTime(Date secondAuditTime) {
        this.secondAuditTime = secondAuditTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.subject
     *
     * @return the value of project.subject
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public String getSubject() {
        return subject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.subject
     *
     * @param subject the value for project.subject
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.department
     *
     * @return the value of project.department
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public String getDepartment() {
        return department;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.department
     *
     * @param department the value for project.department
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.level
     *
     * @return the value of project.level
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public String getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.level
     *
     * @param level the value for project.level
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.money
     *
     * @return the value of project.money
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public Float getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.money
     *
     * @param money the value for project.money
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public void setMoney(Float money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.start_time
     *
     * @return the value of project.start_time
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.start_time
     *
     * @param startTime the value for project.start_time
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.end_time
     *
     * @return the value of project.end_time
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.end_time
     *
     * @param endTime the value for project.end_time
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.introduction
     *
     * @return the value of project.introduction
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.introduction
     *
     * @param introduction the value for project.introduction
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.year
     *
     * @return the value of project.year
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public String getYear() {
        return year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.year
     *
     * @param year the value for project.year
     *
     * @mbg.generated Sun May 24 14:24:29 CST 2020
     */
    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }
}