package com.lzy.design.controller;

import com.lzy.design.common.R;
import com.lzy.design.service.ProjectAuditService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("/ProjectAudit")
@Validated
@CrossOrigin(allowCredentials = "true")
public class ProjectAuditController {

    @Autowired
    private ProjectAuditService projectAuditService;


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @RequiresRoles(value = {"system_admin","department_admin"},logical = Logical.OR)
    public R list(@RequestParam(value = "page",defaultValue = "1")int page,
                  @RequestParam(value = "limit",defaultValue = "20")int limit,
                  @RequestParam(value = "title",required = false)String title,
                  @RequestParam(value = "type",required = false)String type,
                  @RequestParam(value = "level",required = false)String level){
        return R.ok().data(projectAuditService.listProjectNeedAudit(page,limit,title,level));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public R detail(@RequestParam(value = "pjId")int pjId){
        return R.ok().data(projectAuditService.getProjectAuditDetail(pjId));
    }

    @RequestMapping(value = "/audit",method = RequestMethod.POST)
    @RequiresRoles(value = {"system_admin","department_admin"},logical = Logical.OR)
    public R audit(@Min(1)
                   @RequestParam(value = "pjId") int pjId,
                   @RequestParam(value = "opinion")int opinion,
                   @RequestParam("opinionReason")String opinionReason){
        projectAuditService.projectAudit(pjId,opinion,opinionReason);
        return R.ok();
    }
}
