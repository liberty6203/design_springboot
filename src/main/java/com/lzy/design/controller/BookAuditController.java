package com.lzy.design.controller;


import com.lzy.design.common.R;
import com.lzy.design.service.BookAuditService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("/BookAudit")
@Validated
@CrossOrigin(allowCredentials = "true")
public class BookAuditController {

    @Autowired
    private BookAuditService bookAuditService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @RequiresRoles(value = {"system_admin","department_admin"},logical = Logical.OR)
    public R list(@RequestParam(value = "page",defaultValue = "1")int page,
                  @RequestParam(value = "limit",defaultValue = "20")int limit,
                  @RequestParam(value = "title",required = false)String title){
        return R.ok().data(bookAuditService.listBookNeedAudit(page,limit,title));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public R detail(@RequestParam(value = "bId")int bId){
        return R.ok().data(bookAuditService.getBookAuditDetail(bId));
    }

    @RequestMapping(value = "/audit",method = RequestMethod.POST)
    @RequiresRoles(value = {"system_admin","department_admin"},logical = Logical.OR)
    public R audit(@Min(1)
                   @RequestParam(value = "bId") int bId,
                   @RequestParam(value = "opinion")int opinion,
                   @RequestParam("opinionReason")String opinionReason){
        bookAuditService.bookAudit(bId,opinion,opinionReason);
        return R.ok();
    }


}
