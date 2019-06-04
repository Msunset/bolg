package com.sunset.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component//spring 可以扫描到此类
@Aspect//标注这里将使用aop的切面功能
public class AspectHandler {
    @Autowired
    HttpServletRequest request;
    @Pointcut("execution(* com.sunset.web.*.*(..))")
    public void Aspect(){
    }

    @Before("Aspect()")
    public void before(JoinPoint joinPoint){
        System.out.println("aop执行之前");

        Logger logger = LoggerFactory.getLogger(this.getClass());
        String url = request.getRequestURI();
        String ip = request.getRemoteAddr();
        String method = request.getServletPath();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, method, args);
        System.out.println(requestLog);



    }
    @After("Aspect()")
    public void after(){

        System.out.println("执行方法之后");
    }
    @AfterReturning(returning = "res",pointcut = "Aspect()")
    public void result(Object res){

        System.out.println("执行结果的返回"+res);
    }
    //包装需要用的参数
public class RequestLog{
    private String url;
    private String ip;
    private String method;
    private Object[] args;

    public RequestLog(String url, String ip, String method, Object[] args) {
        this.url = url;
        this.ip = ip;
        this.method = method;
        this.args = args;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}


}
