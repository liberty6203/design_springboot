package com.lzy.design.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzy.design.constcode.AuditOpinion;
import com.lzy.design.constcode.AuditStatus;
import com.lzy.design.dto.treatiseAudit.TreatiseAuditDetailDTO;
import com.lzy.design.mapper.PersonMapper;
import com.lzy.design.mapper.TreatiseAuditMapper;
import com.lzy.design.mapper.TreatiseMapper;
import com.lzy.design.po.*;
import com.lzy.design.service.TreatiseAuditService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TreatiseAuditServiceImpl implements TreatiseAuditService {

    @Autowired
    private TreatiseMapper treatiseMapper;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private TreatiseAuditMapper treatiseAuditMapper;

    @Override
    public PageInfo listTreatiseNeedAudit(int page,int limit,String title,String type,String level) {

        TreatiseExample example = new TreatiseExample();
        TreatiseExample.Criteria criteria = example.createCriteria();
        criteria.andAuditStatusNotEqualTo(AuditStatus.AUDIT_COMPLETE.getStatus());
        if (!StringUtils.isBlank(title))
            criteria.andTitleLike("%"+title+"%");
        if (!StringUtils.isBlank(type))
            criteria.andTypeEqualTo(type);
        if (!StringUtils.isBlank(level))
            criteria.andLevelEqualTo(level);
        example.setOrderByClause("create_time desc");

        PageHelper.startPage(page,limit);
        PageInfo<Treatise> pageInfo = new PageInfo<>(treatiseMapper.selectByExample(example));


        return pageInfo;
    }

    @Override
    public TreatiseAuditDetailDTO getTreatiseAuditDetail(int tId) {
        Treatise treatise = treatiseMapper.selectByPrimaryKey(tId);
        Person person = personMapper.selectByPrimaryKey(treatise.getpId());
        TreatiseAuditExample example = new TreatiseAuditExample();
        example.createCriteria()
                .andTIdEqualTo(tId);
        example.setOrderByClause("audit_time desc");

        List<TreatiseAudit> treatiseAuditList = treatiseAuditMapper.selectByExample(example);
        return new TreatiseAuditDetailDTO(treatise,person,treatiseAuditList);
    }

    @Override
    @Transactional
    public void treatiseAudit(int tId, int opinion, String opinionReason) {
        Treatise treatise = treatiseMapper.selectByPrimaryKey(tId);
        if (!(treatise.getAuditStatus()==AuditStatus.NEED_FIRST_AUDIT.getStatus()||
                treatise.getAuditStatus()==AuditStatus.NEED_SECOND_AUDIT.getStatus())){
            throw new RuntimeException("审核状态错误");
        }
        Person admin = (Person) SecurityUtils.getSubject().getPrincipal();
        TreatiseAudit treatiseAudit = new TreatiseAudit();
        treatiseAudit.setAdId(admin.getId());
        treatiseAudit.settId(tId);
        treatiseAudit.setAuditOpinion(opinion);
        treatiseAudit.setAuditOpinionReason(opinionReason);
        treatiseAudit.setAuditTime(new Date());
        treatiseAuditMapper.insertSelective(treatiseAudit);
        if (opinion == AuditOpinion.AUDIT_PASS.getAuditStatus()){
            if (treatise.getAuditStatus()==AuditStatus.NEED_FIRST_AUDIT.getStatus()){
                treatise.setAuditStatus(AuditStatus.NEED_SECOND_AUDIT.getStatus());
                treatise.setFirstAuditTime(new Date());
                treatise.setUpdateTime(new Date());
            }else{
                treatise.setAuditStatus(AuditStatus.AUDIT_COMPLETE.getStatus());
                treatise.setSecondAuditTime(new Date());
                treatise.setUpdateTime(new Date());
            }
            treatiseMapper.updateByPrimaryKey(treatise);
        }
    }
}
