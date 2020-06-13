package com.lzy.design.common;

import com.lzy.design.exception.ParametreException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import static com.lzy.design.constcode.ResponseCode.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnauthenticatedException.class)
    public R notLogin(HttpServletRequest request,Exception e){
        return R.error(UNAUTHORIZED.getStatus(),UNAUTHORIZED.getDesp());
    }

    @ExceptionHandler({UnauthorizedException.class,})
    public R noPermission(HttpServletRequest request,Exception e){
        return R.error(FORBIDDEN.getStatus(),FORBIDDEN.getDesp());
    }

    @ExceptionHandler(UnknownAccountException.class)
    public R unKnownAccount(HttpServletRequest request,Exception e){
        return R.error(UNKNOWN_ACCOUNT.getStatus(),UNKNOWN_ACCOUNT.getDesp());
    }

    @ExceptionHandler({IncorrectCredentialsException.class,AuthenticationException.class})
    public R incorrectCredentials(HttpServletRequest request,Exception e){
        return R.error(INCORRECT_CREDENTIAL.getStatus(),INCORRECT_CREDENTIAL.getDesp());
    }

    @ExceptionHandler({ConstraintViolationException.class, MethodArgumentTypeMismatchException.class, ParametreException.class, MissingServletRequestParameterException.class})
    public R handleMethodArgumentNotValidException(Exception e) {
        e.printStackTrace();
        return R.error(BAD_REQUEST.getStatus(),BAD_REQUEST.getDesp());
    }

    @ExceptionHandler(Exception.class)
    public R loginError(HttpServletRequest request,Exception e){
        e.printStackTrace();
        return R.error(CLIENT_ERROR.getStatus(),e.getMessage());
    }

}
