package com.lzy.design.mapper;

import com.lzy.design.po.ProjectCount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectCountMapper {

    List<ProjectCount> getProjectCountByPId(@Param("pId") int pId);



}
