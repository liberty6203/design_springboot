package com.lzy.design.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzy.design.constcode.AuditStatus;
import com.lzy.design.mapper.ProjectAuditMapper;
import com.lzy.design.mapper.ProjectMapper;
import com.lzy.design.mapper.ProjectWithProjectAuditMapper;
import com.lzy.design.po.Person;
import com.lzy.design.po.Project;
import com.lzy.design.po.ProjectAuditExample;
import com.lzy.design.po.ProjectExample;
import com.lzy.design.service.ProjectService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private ProjectAuditMapper projectAuditMapper;

    @Autowired
    private ProjectWithProjectAuditMapper projectWithProjectAuditMapper;


    @Override
    public void addProject(int pId, String title, String subject, String department, String level, float money, Date startTime, Date endTime,String year, String introduction) {
        Project project = new Project();
        project.setpId(pId);
        project.setAuditStatus(AuditStatus.NEED_FIRST_AUDIT.getStatus());
        project.setCreateTime(new Date());
        project.setDepartment(department);
        project.setEndTime(endTime);
        project.setLevel(level);
        project.setMoney(money);
        project.setStartTime(startTime);
        project.setSubject(subject);
        project.setTitle(title);
        project.setUpdateTime(new Date());
        project.setIntroduction(introduction);
        project.setYear(year);
        projectMapper.insertSelective(project);
    }

    @Override
    public PageInfo listProject(int page, int limit, String title, String level, boolean isPersonal, boolean isAuditing, boolean isBlocked) {
        PageInfo<Project> pageInfo;
        Person person = (Person) SecurityUtils.getSubject().getPrincipal();
        if(person == null){
            throw new UnauthenticatedException("未登录");
        }
        int pId = person.getId();
        if (!isAuditing){
            ProjectExample example = new ProjectExample();
            ProjectExample.Criteria criteria = example.createCriteria();
            criteria.andAuditStatusEqualTo(AuditStatus.AUDIT_COMPLETE.getStatus());
            if (isPersonal)
                criteria.andPIdEqualTo(pId);
            if (!StringUtils.isBlank(title))
                criteria.andTitleLike("%"+title+"%");
            if (!StringUtils.isBlank(level))
                criteria.andLevelEqualTo(level);
            example.setOrderByClause("create_time desc");
            PageHelper.startPage(page,limit);
            pageInfo = new PageInfo<>(projectMapper.selectByExample(example));
        }else{
            if (!isBlocked){
                ProjectExample example = new ProjectExample();
                ProjectExample.Criteria criteria = example.createCriteria();
                criteria.andAuditStatusNotEqualTo(AuditStatus.AUDIT_COMPLETE.getStatus());
                if (isPersonal)
                    criteria.andPIdEqualTo(pId);
                if (!StringUtils.isBlank(title))
                    criteria.andTitleLike("%"+title+"%");
                if (!StringUtils.isBlank(level))
                    criteria.andLevelEqualTo(level);
                example.setOrderByClause("create_time desc");
                PageHelper.startPage(page,limit);
                pageInfo = new PageInfo<>(projectMapper.selectByExample(example));
            }else{
                PageHelper.startPage(page,limit);
                pageInfo = new PageInfo<>(projectWithProjectAuditMapper.getBlockedProject(pId));
            }
        }
        return pageInfo;
    }

    @Override
    public void removeProject(int pjId) {
        projectMapper.deleteByPrimaryKey(pjId);
        ProjectAuditExample example = new ProjectAuditExample();
        example.createCriteria().andPjIdEqualTo(pjId);
        projectAuditMapper.deleteByExample(example);
    }

    @Override
    public void updateProject(int pjId, String title, String subject, String department, String level, float money, Date startTime, Date endTime,String year, String introduction) {
        Project project = new Project();
        project.setId(pjId);
        project.setTitle(title);
        project.setSubject(subject);
        project.setDepartment(department);
        project.setLevel(level);
        project.setMoney(money);
        project.setStartTime(startTime);
        project.setEndTime(endTime);
        project.setUpdateTime(new Date());
        project.setIntroduction(introduction);
        project.setYear(year);
        projectMapper.updateByPrimaryKeySelective(project);
    }
}
