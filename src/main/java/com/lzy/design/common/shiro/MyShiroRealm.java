package com.lzy.design.common.shiro;

import com.lzy.design.constcode.RoleCode;
import com.lzy.design.po.Person;
import com.lzy.design.service.PersonService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private PersonService personService;

    //角色权限和对应权限添加
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//      获取用户信息，service or shiro 随意
        Person person = (Person) principalCollection.getPrimaryPrincipal();
        //添加角色addRole和权限addPermission
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(RoleCode.getDesp(person.getRole()));
        return simpleAuthorizationInfo;
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws UnauthenticatedException,UnknownAccountException,IncorrectCredentialsException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
//        if (authenticationToken.getPrincipal() == null) {
//            return null;
//        }
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String idcard = token.getUsername();
        String password = String.valueOf(token.getPassword());
        //获取用户信息
        if (StringUtils.isBlank(idcard)){
            throw new UnauthenticatedException("登录失效");
        }
        Person person = personService.findByIdcard(idcard);
        if (person == null) {
            throw new UnknownAccountException("账户不存在");
        }
        if (!password.equals(person.getPassword())) {
            throw new IncorrectCredentialsException("身份证号或密码不正确");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(person, password, getName());
        return info;
    }

}
