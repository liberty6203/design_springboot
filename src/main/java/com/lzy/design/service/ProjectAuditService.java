package com.lzy.design.service;

import com.github.pagehelper.PageInfo;
import com.lzy.design.dto.projectAudit.ProjectAuditDetailDTO;

public interface ProjectAuditService {

    PageInfo listProjectNeedAudit(int page, int limit, String title, String level);

    ProjectAuditDetailDTO getProjectAuditDetail(int pjId);

    void projectAudit(int pjId,int opinion,String opinionReason);

}
