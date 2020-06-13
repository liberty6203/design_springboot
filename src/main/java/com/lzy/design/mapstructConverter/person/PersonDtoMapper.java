package com.lzy.design.mapstructConverter.person;

import com.lzy.design.dto.person.PersonDTO;
import com.lzy.design.po.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface PersonDtoMapper {

    PersonDtoMapper INSTANCE = Mappers.getMapper(PersonDtoMapper.class);

    @Mappings({})
    PersonDTO toDto(Person person);

}
