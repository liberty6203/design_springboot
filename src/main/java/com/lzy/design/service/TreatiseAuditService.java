package com.lzy.design.service;

import com.github.pagehelper.PageInfo;
import com.lzy.design.dto.treatiseAudit.TreatiseAuditDetailDTO;

public interface TreatiseAuditService {

    PageInfo listTreatiseNeedAudit(int page,int limit,String title,String type,String level);

    TreatiseAuditDetailDTO getTreatiseAuditDetail(int tId);

    void treatiseAudit(int tId,int opinion,String opinionReason);

}
