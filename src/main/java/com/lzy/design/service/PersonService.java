package com.lzy.design.service;

import com.github.pagehelper.PageInfo;
import com.lzy.design.po.Person;

import java.util.List;

public interface PersonService {

    Person findByIdcard(String idcard);

    Person getPersonInfoByIdcard(String idcard);

    void modifyPassword(String oldPassword,String newPassword);

    void addPerson(List<Person> personList);

    void removePerson(int id);

    void updatePerson(int id,String idcard,String password,String email,String name,String degree,String phone,String department,String position,int role);

    PageInfo getPersonInfo(int page,int limit,String name);

}
