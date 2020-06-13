package com.lzy.design.service;

import com.github.pagehelper.PageInfo;
import com.lzy.design.po.Treatise;

import java.util.List;

public interface TreatiseService {

    void addTreatise(int pId,String title,String type,String level,String subject,String year,String introduction);

    PageInfo listTreatise(int page,int limit,String title,String type,String level,boolean isPersonal,boolean isAuditing,boolean isBlocked);

    void removeTreatise(int tId);

    void updateTreatise(int tId,String title,String type,String level,String subject,String year,String introduction);

    void multiAddTreatise(List<Treatise> treatiseList);


}
