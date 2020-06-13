package com.lzy.design.service;

import com.github.pagehelper.PageInfo;

import java.util.Date;

public interface ProjectService {


    void addProject(int pId, String title, String subject, String department, String level, float money, Date startTime, Date endTime,String year,String introduction);

    PageInfo listProject(int page, int limit, String title, String level, boolean isPersonal, boolean isAuditing, boolean isBlocked);

    void removeProject(int pjId);

    void updateProject(int pjId, String title, String subject, String department, String level, float money, Date startTime, Date endTime,String year, String introduction);

}
