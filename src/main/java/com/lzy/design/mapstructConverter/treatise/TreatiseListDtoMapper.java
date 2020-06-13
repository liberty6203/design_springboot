package com.lzy.design.mapstructConverter.treatise;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TreatiseListDtoMapper {

    TreatiseListDtoMapper INSTENCE = Mappers.getMapper(TreatiseListDtoMapper.class);



}
