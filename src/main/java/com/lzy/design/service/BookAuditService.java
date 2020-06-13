package com.lzy.design.service;

import com.github.pagehelper.PageInfo;
import com.lzy.design.dto.book.BookAuditDetailDTO;

public interface BookAuditService {

    PageInfo listBookNeedAudit(int page, int limit, String title);

    BookAuditDetailDTO getBookAuditDetail(int bId);

    void bookAudit(int bId,int opinion,String opinionReason);

}
