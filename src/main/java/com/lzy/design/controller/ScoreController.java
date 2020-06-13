package com.lzy.design.controller;


import com.lzy.design.common.R;
import com.lzy.design.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Score")
@CrossOrigin(allowCredentials = "true")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;


    @RequestMapping("/personalTreatiseScore")
    public R getPersonalTreatiseScore(@RequestParam(value = "year",required = false) String year,
                                      @RequestParam("pId")int pId){
        return R.ok().data(scoreService.getTreatiseCount(year,pId));
    }

    @RequestMapping("/totalTreatiseScore")
    public R getPersonalTreatiseScore(@RequestParam(value = "year",required = false) String year){
        return R.ok().data(scoreService.getTreatiseTotalCount(year));
    }

    @RequestMapping("/personalProjectScore")
    public R personalProjectScore(@RequestParam(value = "year",required = false) String year,
                                      @RequestParam("pId")int pId){
        return R.ok().data(scoreService.getProjectCount(year,pId));
    }

    @RequestMapping("/totalProjectScore")
    public R totalProjectScore(@RequestParam(value = "year",required = false) String year){
        return R.ok().data(scoreService.getProjectTotalCount(year));
    }

    @RequestMapping("/personalBookScore")
    public R personalBookScore(@RequestParam(value = "year",required = false) String year,
                                  @RequestParam("pId")int pId){
        return R.ok().data(scoreService.getBookCount(year,pId));
    }

    @RequestMapping("/totalBookScore")
    public R totalBookScore(@RequestParam(value = "year",required = false) String year){
        return R.ok().data(scoreService.getBookTotalCount(year));
    }

    @RequestMapping("/personScore")
    public R personalBookScore(@RequestParam(value = "year",required = false) String year,
                               @RequestParam(value = "name",required = false)String name){
        return R.ok().data(scoreService.getPersonScore(year,name));
    }

    @RequestMapping("/personScoreByPid")
    public R personalBookScore(@RequestParam(value = "pId") int pId){
        return R.ok().data(scoreService.getPersonScoreByPid(pId));
    }

}
