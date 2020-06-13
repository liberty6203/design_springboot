package com.lzy.design.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzy.design.constcode.AuditOpinion;
import com.lzy.design.constcode.AuditStatus;
import com.lzy.design.dto.book.BookAuditDetailDTO;
import com.lzy.design.mapper.BookAuditMapper;
import com.lzy.design.mapper.BookMapper;
import com.lzy.design.mapper.PersonMapper;
import com.lzy.design.po.*;
import com.lzy.design.service.BookAuditService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class BookAuditServiceImpl implements BookAuditService {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookAuditMapper bookAuditMapper;
    @Autowired
    private PersonMapper personMapper;


    @Override
    public PageInfo listBookNeedAudit(int page, int limit, String title) {
        BookExample example = new BookExample();
        BookExample.Criteria criteria = example.createCriteria();
        criteria.andAuditStatusNotEqualTo(AuditStatus.AUDIT_COMPLETE.getStatus());
        if (!StringUtils.isBlank(title))
            criteria.andTitleLike("%"+title+"%");
        example.setOrderByClause("create_time desc");
        PageHelper.startPage(page,limit);
        PageInfo<Book> pageInfo = new PageInfo<>(bookMapper.selectByExample(example));

        return pageInfo;
    }

    @Override
    public BookAuditDetailDTO getBookAuditDetail(int bId) {
        Book book = bookMapper.selectByPrimaryKey(bId);
        Person person = personMapper.selectByPrimaryKey(book.getPid());
        BookAuditExample example = new BookAuditExample();
        example.createCriteria()
                .andBIdEqualTo(bId);
        example.setOrderByClause("audit_time desc");
        List<BookAudit> projectAuditList = bookAuditMapper.selectByExample(example);
        return new BookAuditDetailDTO(book,person,projectAuditList);
    }

    @Override
    public void bookAudit(int bId, int opinion, String opinionReason) {
        Book book = bookMapper.selectByPrimaryKey(bId);
        if (!(book.getAuditStatus()==AuditStatus.NEED_FIRST_AUDIT.getStatus()||
                book.getAuditStatus()==AuditStatus.NEED_SECOND_AUDIT.getStatus())){
            throw new RuntimeException("审核状态错误");
        }
//        Person admin = (Person) SecurityUtils.getSubject().getPrincipal();
        BookAudit bookAudit = new BookAudit();

//        bookAudit.setAdId(admin.getId());
        bookAudit.setAdId(1);
        bookAudit.setbId(bId);
        bookAudit.setAuditOpinion(opinion);
        bookAudit.setAuditOpinionReason(opinionReason);
        bookAudit.setAuditTime(new Date());
        bookAuditMapper.insertSelective(bookAudit);
        if (opinion == AuditOpinion.AUDIT_PASS.getAuditStatus()){
            if (book.getAuditStatus()==AuditStatus.NEED_FIRST_AUDIT.getStatus()){
                book.setAuditStatus(AuditStatus.NEED_SECOND_AUDIT.getStatus());
                book.setFirstAuditTime(new Date());
            }else{
                book.setAuditStatus(AuditStatus.AUDIT_COMPLETE.getStatus());
                book.setSecondAuditTime(new Date());
            }
            book.setUpdateTime(new Date());
            bookMapper.updateByPrimaryKey(book);
        }
    }
}
