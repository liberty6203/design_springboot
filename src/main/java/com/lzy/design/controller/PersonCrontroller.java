package com.lzy.design.controller;


import com.lzy.design.common.R;
import com.lzy.design.mapstructConverter.person.PersonDtoMapper;
import com.lzy.design.po.Person;
import com.lzy.design.service.PersonService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(allowCredentials = "true")
public class PersonCrontroller {

    @Autowired
    private PersonService personService;


    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public R login( @RequestParam(value = "idcard",required = true) @NotBlank String idcard,
                    @RequestParam(value = "password",required = true)@NotBlank String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(idcard,password);
        subject.login(token);
        return R.ok().data(PersonDtoMapper.INSTANCE.toDto((Person) subject.getPrincipal()));
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public R logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return R.ok();
    }

    @RequestMapping(value = "/getCode")
    @RequiresRoles(value = {"system_admin","department_admin"},logical = Logical.OR)
    public R getCode(@RequestParam(value = "code",required = true)String code){
        return R.ok().data(code);
    }


    @RequestMapping(value = "/modifyPassword",method = {RequestMethod.POST})
    public R modifyPassword( @RequestParam(value = "oldPassword",required = true) @NotBlank String oldPassword,
                             @RequestParam(value = "newPassword",required = true) @NotBlank String newPassword){
        personService.modifyPassword(oldPassword,newPassword);
        return R.ok();
    }

    @RequestMapping("/addPerson")
    @RequiresRoles(value = {"system_admin"},logical = Logical.OR)
    public R addPerson(@RequestParam String idcard,
                       @RequestParam(value = "password") String password,
                       @RequestParam String email,
                       @RequestParam String name,
                       @RequestParam String degree,
                       @RequestParam String phone,
                       @RequestParam String department,
                       @RequestParam String position,
                       @RequestParam int role){
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setIdcard(idcard);
        person.setPassword(password);
        person.setEmail(email);
        person.setName(name);
        person.setDepartment(degree);
        person.setPhone(phone);
        person.setDepartment(department);
        person.setPosition(position);
        person.setRole(role);
        personList.add(person);
        personService.addPerson(personList);
        return R.ok();
    }

    @RequestMapping("/updatePerson")
    @RequiresRoles(value = {"system_admin"},logical = Logical.OR)
    public R updatePerson(@RequestParam int id,
                          @RequestParam String idcard,
                          @RequestParam(value = "password",required = false) String password,
                          @RequestParam String email,
                          @RequestParam String name,
                          @RequestParam String degree,
                          @RequestParam String phone,
                          @RequestParam String department,
                          @RequestParam String position,
                          @RequestParam(value = "role",required = false) int role){
        personService.updatePerson(id, idcard, password, email, name, degree, phone, department, position, role);
        return R.ok();
    }

    @RequestMapping("/removePerson")
    @RequiresRoles(value = {"system_admin"},logical = Logical.OR)
    public R removePerson(@RequestParam int id){
        personService.removePerson(id);
        return R.ok();
    }

    @RequestMapping("/getPersonList")
    @RequiresRoles(value = {"system_admin"},logical = Logical.OR)
    public R getPersonList(@RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "limit",defaultValue = "12") int limit,
                           @RequestParam(value = "name",required = false) String name){
        return R.ok().data(personService.getPersonInfo(page, limit, name));
    }

}
