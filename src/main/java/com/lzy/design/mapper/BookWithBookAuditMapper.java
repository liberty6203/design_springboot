package com.lzy.design.mapper;

import com.lzy.design.po.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookWithBookAuditMapper {

    List<Book> getBlockedBook(@Param("pId") int pId);
}
