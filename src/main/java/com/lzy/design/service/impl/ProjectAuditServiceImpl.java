package com.lzy.design.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzy.design.constcode.AuditOpinion;
import com.lzy.design.constcode.AuditStatus;
import com.lzy.design.dto.projectAudit.ProjectAuditDetailDTO;
import com.lzy.design.mapper.PersonMapper;
import com.lzy.design.mapper.ProjectAuditMapper;
import com.lzy.design.mapper.ProjectMapper;
import com.lzy.design.po.*;
import com.lzy.design.service.ProjectAuditService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectAuditServiceImpl implements ProjectAuditService {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private ProjectAuditMapper projectAuditMapper;

    @Override
    public PageInfo listProjectNeedAudit(int page, int limit, String title, String level) {

        ProjectExample example = new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        criteria.andAuditStatusNotEqualTo(AuditStatus.AUDIT_COMPLETE.getStatus());
        if (!StringUtils.isBlank(title))
            criteria.andTitleLike("%"+title+"%");
        if (!StringUtils.isBlank(level))
            criteria.andLevelEqualTo(level);
        example.setOrderByClause("create_time desc");
        PageHelper.startPage(page,limit);
        PageInfo<Project> pageInfo = new PageInfo<>(projectMapper.selectByExample(example));

        return pageInfo;
    }

    @Override
    public ProjectAuditDetailDTO getProjectAuditDetail(int pjId) {
        Project project = projectMapper.selectByPrimaryKey(pjId);
        Person person = personMapper.selectByPrimaryKey(project.getpId());
        ProjectAuditExample example = new ProjectAuditExample();
        example.createCriteria()
                .andPjIdEqualTo(pjId);
        example.setOrderByClause("audit_time desc");
        List<ProjectAudit> projectAuditList = projectAuditMapper.selectByExample(example);
        return new ProjectAuditDetailDTO(project,person,projectAuditList);
    }

    @Override
    public void projectAudit(int pjId, int opinion, String opinionReason) {
        Project project = projectMapper.selectByPrimaryKey(pjId);
        if (!(project.getAuditStatus()==AuditStatus.NEED_FIRST_AUDIT.getStatus()||
                project.getAuditStatus()==AuditStatus.NEED_SECOND_AUDIT.getStatus())){
            throw new RuntimeException("审核状态错误");
        }
        Person admin = (Person) SecurityUtils.getSubject().getPrincipal();
        ProjectAudit projectAudit = new ProjectAudit();

        projectAudit.setAdId(admin.getId());
        projectAudit.setPjId(pjId);
        projectAudit.setAuditOpinion(opinion);
        projectAudit.setAuditOpinionReason(opinionReason);
        projectAudit.setAuditTime(new Date());
        projectAuditMapper.insertSelective(projectAudit);
        if (opinion == AuditOpinion.AUDIT_PASS.getAuditStatus()){
            if (project.getAuditStatus()==AuditStatus.NEED_FIRST_AUDIT.getStatus()){
                project.setAuditStatus(AuditStatus.NEED_SECOND_AUDIT.getStatus());
                project.setFirstAuditTime(new Date());
            }else{
                project.setAuditStatus(AuditStatus.AUDIT_COMPLETE.getStatus());
                project.setSecondAuditTime(new Date());
                project.setUpdateTime(new Date());
            }
            project.setUpdateTime(new Date());
            projectMapper.updateByPrimaryKey(project);
        }
    }
}
