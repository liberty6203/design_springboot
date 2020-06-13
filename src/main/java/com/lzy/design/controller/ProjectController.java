package com.lzy.design.controller;


import com.lzy.design.common.R;
import com.lzy.design.exception.ParametreException;
import com.lzy.design.service.ProjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.util.Date;

@RequestMapping("/Project")
@RestController
@CrossOrigin(allowCredentials = "true")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @RequestMapping("/add")
    public R add(@RequestParam("pId")int pId,
                 @RequestParam("title")String title,
                 @RequestParam("subject")String subject,
                 @RequestParam("department")String department,
                 @RequestParam("level")String level,
                 @RequestParam("money")float money,
                 @RequestParam("startTime")String startTime,
                 @RequestParam("endTime")String endTime,
                 @RequestParam("year")String year,
                 @RequestParam("introduction")String introduction){
        Date sDate,eDate;
        if (!StringUtils.isBlank(startTime)){
            long lt = Long.parseLong(startTime);
            sDate = new Date(lt);
        }else{
            throw new ParametreException("参数错误");
        }
        if (!StringUtils.isBlank(endTime)){
            long lt = Long.parseLong(endTime);
            eDate = new Date(lt);
        }else{
            throw new ParametreException("参数错误");
        }
        projectService.addProject(pId,title,subject,department,level,money,sDate,eDate,year,introduction);
        return R.ok();
    }

    @RequestMapping("list")
    public R list(@RequestParam(value = "page",defaultValue = "1") int page,
                  @RequestParam(value = "limit",defaultValue = "20") int limit,
                  @RequestParam(value = "title",required = false) String title,
                  @RequestParam(value = "level",required = false) String level,
                  @RequestParam(value = "isPersonal") boolean isPersonal,
                  @RequestParam("isAuditing") boolean isAuditing,
                  @RequestParam("isBlocked") boolean isBlocked){
        return R.ok().data(projectService.listProject(page,limit,title,level,isPersonal,isAuditing,isBlocked));
    }

    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public R remove(@RequestParam("pjId")int pjId){
        projectService.removeProject(pjId);
        return R.ok();
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public R update(@RequestParam("pjId")int pjId,
                    @RequestParam("title")String title,
                    @RequestParam("subject")String subject,
                    @RequestParam("department")String department,
                    @RequestParam("level")String level,
                    @RequestParam("money")float money,
                    @RequestParam("startTime")String startTime,
                    @RequestParam("endTime")String endTime,
                    @RequestParam("year")String year,
                    @RequestParam("introduction")String introduction){
        Date sDate,eDate;
        if (!StringUtils.isBlank(startTime)){
            long lt = Long.parseLong(startTime);
            sDate = new Date(lt);
        }else{
            throw new ParametreException("参数错误");
        }
        if (!StringUtils.isBlank(endTime)){
            long lt = Long.parseLong(endTime);
            eDate = new Date(lt);
        }else{
            throw new ParametreException("参数错误");
        }
        projectService.updateProject(pjId,title,subject,department,level,money,sDate,eDate,year,introduction);
        return R.ok();
    }
}
