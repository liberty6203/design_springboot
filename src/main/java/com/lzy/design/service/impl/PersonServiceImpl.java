package com.lzy.design.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzy.design.mapper.PersonMapper;
import com.lzy.design.po.Person;
import com.lzy.design.po.PersonExample;
import com.lzy.design.service.PersonService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public Person findByIdcard(String idcard) {
        PersonExample example = new PersonExample();
        PersonExample.Criteria criteria = example.createCriteria();
        criteria.andIdcardEqualTo(idcard);
        List<Person> personList = personMapper.selectByExample(example);
        if (personList.size()==0)
            throw new UnknownAccountException();
        return personList.get(0);
    }

    @Override
    public Person getPersonInfoByIdcard(String idcard) {
        PersonExample example = new PersonExample();
        PersonExample.Criteria criteria = example.createCriteria();
        criteria.andIdcardEqualTo(idcard);

        List <Person> people = personMapper.selectByExample(example);
        return people.get(0);
    }

    @Override
    public void modifyPassword(String oldPassword, String newPassword) {
        Subject subject = SecurityUtils.getSubject();
        Person person =(Person) subject.getPrincipal();
        if (person == null)
            throw new UnauthenticatedException("未登录");
        String password = ((Person) subject.getPrincipal()).getPassword();
        if (password.equals(oldPassword));

        Person updatePerson = new Person();
        updatePerson.setId(person.getId());
        updatePerson.setPassword(newPassword);
        personMapper.updateByPrimaryKeySelective(updatePerson);
    }

    @Override
    public void addPerson(List<Person> personList) {
        for(Person p:personList){
            personMapper.insertSelective(p);
        }

    }

    @Override
    public void removePerson(int id) {
        personMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updatePerson(int id, String idcard, String password, String email, String name, String degree, String phone, String department, String position, int role) {
        Person person = new Person();
        person.setId(id);
        person.setIdcard(idcard);
        if (!StringUtils.isBlank(password))
            person.setPassword(password);
        person.setEmail(email);
        person.setName(name);
        person.setDegree(degree);
        person.setDepartment(department);
        person.setPhone(phone);
        person.setPosition(position);
        person.setRole(role);
        personMapper.updateByPrimaryKeySelective(person);
    }

    @Override
    public PageInfo getPersonInfo(int page, int limit, String name) {
        PersonExample example = new PersonExample();
        if (!StringUtils.isBlank(name)){
            example.createCriteria().andNameLike("%"+name+"%");
        }
        PageHelper.startPage(page,limit);
        return new PageInfo(personMapper.selectByExample(example));
    }
}
