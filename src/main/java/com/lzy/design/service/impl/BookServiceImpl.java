package com.lzy.design.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzy.design.constcode.AuditStatus;
import com.lzy.design.mapper.BookAuditMapper;
import com.lzy.design.mapper.BookMapper;
import com.lzy.design.mapper.BookWithBookAuditMapper;
import com.lzy.design.po.Book;
import com.lzy.design.po.BookAuditExample;
import com.lzy.design.po.BookExample;
import com.lzy.design.po.Person;
import com.lzy.design.service.BookService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookAuditMapper bookAuditMapper;
    @Autowired
    private BookWithBookAuditMapper bookWithBookAuditMapper;


    @Override
    public void addBook(int pId, String title, String publisher, String isbn, String year, String introduction) {
        Book book = new Book();
        book.setPid(pId);
        book.setTitle(title);
        book.setPublisher(publisher);
        book.setIsbn(isbn);
        book.setYear(year);
        book.setIntroduction(introduction);
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
        bookMapper.insertSelective(book);
    }

    @Override
    public PageInfo listBook(int page, int limit, String title, boolean isPersonal, boolean isAuditing, boolean isBlocked) {
        PageInfo<Book> pageInfo;
        Person person = (Person) SecurityUtils.getSubject().getPrincipal();
        if(person == null){
            throw new UnauthenticatedException("未登录");
        }
        int pId = person.getId();
        if (!isAuditing){
            BookExample example = new BookExample();
            BookExample.Criteria criteria = example.createCriteria();
            criteria.andAuditStatusEqualTo(AuditStatus.AUDIT_COMPLETE.getStatus());
            if (isPersonal)
                criteria.andPidEqualTo(pId);
            if (!StringUtils.isBlank(title))
                criteria.andTitleLike("%"+title+"%");
            example.setOrderByClause("create_time desc");
            PageHelper.startPage(page,limit);
            pageInfo = new PageInfo<>(bookMapper.selectByExample(example));
        }else{
            if (!isBlocked){
                BookExample example = new BookExample();
                BookExample.Criteria criteria = example.createCriteria();
                criteria.andAuditStatusNotEqualTo(AuditStatus.AUDIT_COMPLETE.getStatus());
                if (isPersonal)
                    criteria.andPidEqualTo(pId);
                if (!StringUtils.isBlank(title))
                    criteria.andTitleLike("%"+title+"%");
                example.setOrderByClause("create_time desc");
                PageHelper.startPage(page,limit);
                pageInfo = new PageInfo<>(bookMapper.selectByExample(example));
            }else{
                PageHelper.startPage(page,limit);
                pageInfo = new PageInfo<>(bookWithBookAuditMapper.getBlockedBook(pId));
            }
        }
        return pageInfo;
    }

    @Override
    public void removeBook(int bId) {
        bookMapper.deleteByPrimaryKey(bId);
        BookAuditExample example = new BookAuditExample();
        example.createCriteria().andBIdEqualTo(bId);
        bookAuditMapper.deleteByExample(example);
    }

    @Override
    public void updateBook(int bId, String title, String publisher, String isbn, String year, String introduction) {
        Book book = new Book();
        book.setId(bId);
        book.setTitle(title);
        book.setPublisher(publisher);
        book.setIsbn(isbn);
        book.setYear(year);
        book.setIntroduction(introduction);
        bookMapper.updateByPrimaryKeySelective(book);
    }
}
