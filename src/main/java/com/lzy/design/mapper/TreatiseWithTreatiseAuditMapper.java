package com.lzy.design.mapper;

import com.lzy.design.po.Treatise;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatiseWithTreatiseAuditMapper {

    List<Treatise> getBlockedTreatise(int pId);

}
