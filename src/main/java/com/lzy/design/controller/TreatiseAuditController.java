package com.lzy.design.controller;


import com.lzy.design.common.R;
import com.lzy.design.service.TreatiseAuditService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("/TreatiseAudit")
@Validated
@CrossOrigin(allowCredentials = "true")
public class TreatiseAuditController {

    @Autowired
    private TreatiseAuditService treatiseAuditService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @RequiresRoles(value = {"system_admin","department_admin"},logical = Logical.OR)
    public R list(@RequestParam(value = "page",defaultValue = "1")int page,
                  @RequestParam(value = "limit",defaultValue = "20")int limit,
                  @RequestParam(value = "title",required = false)String title,
                  @RequestParam(value = "type",required = false)String type,
                  @RequestParam(value = "level",required = false)String level){
        return R.ok().data(treatiseAuditService.listTreatiseNeedAudit(page,limit,title,type,level));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public R detail(@RequestParam(value = "tId")int tId){
        return R.ok().data(treatiseAuditService.getTreatiseAuditDetail(tId));
    }

    @RequestMapping(value = "/audit",method = RequestMethod.POST)
    @RequiresRoles(value = {"system_admin","department_admin"},logical = Logical.OR)
    public R audit(@Min(1)
                   @RequestParam(value = "tId") int tId,
                   @RequestParam(value = "opinion")int opinion,
                   @RequestParam("opinionReason")String opinionReason){
        treatiseAuditService.treatiseAudit(tId,opinion,opinionReason);
        return R.ok();
    }

}
