package com.lzy.design.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzy.design.constcode.AuditStatus;
import com.lzy.design.mapper.TreatiseAuditMapper;
import com.lzy.design.mapper.TreatiseMapper;
import com.lzy.design.mapper.TreatiseWithTreatiseAuditMapper;
import com.lzy.design.po.Person;
import com.lzy.design.po.Treatise;
import com.lzy.design.po.TreatiseAuditExample;
import com.lzy.design.po.TreatiseExample;
import com.lzy.design.service.TreatiseService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TreatiseServiceImpl implements TreatiseService {

    @Autowired
    private TreatiseMapper treatiseMapper;
    @Autowired
    private TreatiseAuditMapper treatiseAuditMapper;
    @Autowired
    private TreatiseWithTreatiseAuditMapper treatiseWithTreatiseAuditMapper;

    @Override
    public void addTreatise(int pId,String title, String type, String level, String subject, String year, String introduction) {
        Treatise treatise = new Treatise();
        treatise.setpId(pId);
        treatise.setSubject(subject);
        treatise.setAuditStatus(AuditStatus.NEED_FIRST_AUDIT.getStatus());
        treatise.setIntroduction(introduction);
        treatise.setTitle(title);
        treatise.setLevel(level);
        treatise.setType(type);
        treatise.setYear(year);
        treatise.setCreateTime(new Date());
        treatise.setUpdateTime(new Date());

        treatiseMapper.insertSelective(treatise);
    }

    @Override
    public PageInfo listTreatise(int page,int limit,String title, String type, String level, boolean isPersonal, boolean isAuditing, boolean isBlocked) {

        PageInfo<Treatise> pageInfo;
        Person person = (Person) SecurityUtils.getSubject().getPrincipal();
        if(person == null){
            throw new UnauthenticatedException("未登录");
        }
        int pId = person.getId();
        if (!isAuditing){
            TreatiseExample example = new TreatiseExample();
            TreatiseExample.Criteria criteria = example.createCriteria();
            criteria.andAuditStatusEqualTo(AuditStatus.AUDIT_COMPLETE.getStatus());
            if (isPersonal)
                criteria.andPIdEqualTo(pId);
            if (!StringUtils.isBlank(title))
                criteria.andTitleLike("%"+title+"%");
            if (!StringUtils.isBlank(type))
                criteria.andTypeEqualTo(type);
            if (!StringUtils.isBlank(level))
                criteria.andLevelEqualTo(level);
            example.setOrderByClause("create_time desc");
            PageHelper.startPage(page,limit);
            pageInfo = new PageInfo<>(treatiseMapper.selectByExample(example));
        }else{
            if (!isBlocked){
                TreatiseExample example = new TreatiseExample();
                TreatiseExample.Criteria criteria = example.createCriteria();
                criteria.andAuditStatusNotEqualTo(AuditStatus.AUDIT_COMPLETE.getStatus());
                if (isPersonal)
                    criteria.andPIdEqualTo(pId);
                if (!StringUtils.isBlank(title))
                    criteria.andTitleLike("%"+title+"%");
                if (!StringUtils.isBlank(type))
                    criteria.andTypeEqualTo(type);
                if (!StringUtils.isBlank(level))
                    criteria.andLevelEqualTo(level);
                example.setOrderByClause("create_time desc");
                PageHelper.startPage(page,limit);
                pageInfo = new PageInfo<>(treatiseMapper.selectByExample(example));
            }else{
                PageHelper.startPage(page,limit);
                pageInfo = new PageInfo<>(treatiseWithTreatiseAuditMapper.getBlockedTreatise(pId));
            }
        }



        return pageInfo;
    }

    @Override
    @Transactional
    public void removeTreatise(int tId) {
        treatiseMapper.deleteByPrimaryKey(tId);
        TreatiseAuditExample example = new TreatiseAuditExample();
        example.createCriteria().andTIdEqualTo(tId);
        treatiseAuditMapper.deleteByExample(example);
    }

    @Override
    public void updateTreatise(int tId,String title, String type, String level, String subject, String year, String introduction) {
        Treatise treatise = new Treatise();
        treatise.setId(tId);
        if (!StringUtils.isBlank(title))
            treatise.setTitle(title);
        if (!StringUtils.isBlank(type))
            treatise.setType(type);
        if (!StringUtils.isBlank(level))
            treatise.setLevel(level);
        if (!StringUtils.isBlank(subject))
            treatise.setSubject(subject);
        if (!StringUtils.isBlank(year))
            treatise.setYear(year);
        if (!StringUtils.isBlank(introduction))
            treatise.setIntroduction(introduction);
        treatiseMapper.updateByPrimaryKeySelective(treatise);
    }


    @Override
    @Transactional
    public void multiAddTreatise(List<Treatise> treatiseList) {
        Person person = (Person) SecurityUtils.getSubject().getPrincipal();
        if(person == null){
            throw new UnauthenticatedException("未登录");
        }
        int pId = person.getId();
        for (Treatise treatise:treatiseList){
            treatise.setpId(pId);
            treatise.setCreateTime(new Date());
            treatise.setUpdateTime(new Date());
            treatise.setAuditStatus(AuditStatus.NEED_FIRST_AUDIT.getStatus());
            treatiseMapper.insertSelective(treatise);
        }
    }
}
