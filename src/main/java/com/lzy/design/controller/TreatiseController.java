package com.lzy.design.controller;


import com.lzy.design.common.R;
import com.lzy.design.service.TreatiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/Treatise")
@RestController
@CrossOrigin(allowCredentials = "true")
public class TreatiseController {

    @Autowired
    private TreatiseService treatiseService;

    @RequestMapping("/add")
    public R add(@RequestParam("pId")int pId,
                 @RequestParam("title")String title,
                 @RequestParam("type")String type,
                 @RequestParam("level")String level,
                 @RequestParam("subject")String subject,
                 @RequestParam("year")String year,
                 @RequestParam("introduction")String introduction){
        treatiseService.addTreatise(pId,title,type,level,subject,year,introduction);
        return R.ok();
    }

    @RequestMapping("list")
    public R list(@RequestParam(value = "page",defaultValue = "1") int page,
                  @RequestParam(value = "limit",defaultValue = "20") int limit,
                  @RequestParam(value = "title",required = false) String title,
                  @RequestParam(value = "type",required = false) String type,
                  @RequestParam(value = "level",required = false) String level,
                  @RequestParam(value = "isPersonal") boolean isPersonal,
                  @RequestParam("isAuditing") boolean isAuditing,
                  @RequestParam("isBlocked") boolean isBlocked){
        return R.ok().data(treatiseService.listTreatise(page,limit,title,type,level,isPersonal,isAuditing,isBlocked));
    }

    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public R remove(@RequestParam("tId")int tId){
        treatiseService.removeTreatise(tId);
        return R.ok();
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public R update(@RequestParam("tId")int tId,
                    @RequestParam("title")String title,
                    @RequestParam("type")String type,
                    @RequestParam("level")String level,
                    @RequestParam("subject")String subject,
                    @RequestParam("year")String year,
                    @RequestParam("introduction")String introduction){
        treatiseService.updateTreatise(tId,title,type,level,subject,year,introduction);
        return R.ok();
    }

}
