package com.lzy.design.controller;

import com.lzy.design.common.R;
import com.lzy.design.service.BookService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/Book")
@RestController
@CrossOrigin(allowCredentials = "true")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/add")
    public R add(@RequestParam("pId")int pId,
                 @RequestParam("title")String title,
                 @RequestParam("publisher")String publisher,
                 @RequestParam("isbn")String isbn,
                 @RequestParam("year")String year,
                 @RequestParam("introduction")String introduction){
        bookService.addBook(pId,title,publisher,isbn,year,introduction);
        return R.ok();
    }

    @RequestMapping("list")
    public R list(@RequestParam(value = "page",defaultValue = "1") int page,
                  @RequestParam(value = "limit",defaultValue = "20") int limit,
                  @RequestParam(value = "title",required = false) String title,
                  @RequestParam(value = "isPersonal") boolean isPersonal,
                  @RequestParam("isAuditing") boolean isAuditing,
                  @RequestParam("isBlocked") boolean isBlocked){
        return R.ok().data(bookService.listBook(page,limit,title,isPersonal,isAuditing,isBlocked));
    }

    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    @RequiresRoles(value = {"system_admin","department_admin"},logical = Logical.OR)
    public R remove(@RequestParam("bId")int bId){
        bookService.removeBook(bId);
        return R.ok();
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public R update(@RequestParam("bId")int bId,
                    @RequestParam("title")String title,
                    @RequestParam("publisher")String publisher,
                    @RequestParam("isbn")String isbn,
                    @RequestParam("year")String year,
                    @RequestParam("introduction")String introduction){
        bookService.updateBook(bId,title,publisher,isbn,year,introduction);
        return R.ok();
    }
}
