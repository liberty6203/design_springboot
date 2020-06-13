package com.lzy.design.mapper;

import com.lzy.design.po.Project;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectWithProjectAuditMapper {

    List<Project> getBlockedProject(@Param("pId") int pId);

}
