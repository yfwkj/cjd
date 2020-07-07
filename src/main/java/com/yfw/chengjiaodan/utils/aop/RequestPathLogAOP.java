package com.yfw.chengjiaodan.utils.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @ClassName: RequestPathLogAOP
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/7/6 16:20
 * @Version: 1.0
 **/
@Component
@Aspect
@Slf4j
public class RequestPathLogAOP {

    //@Pointcut("execution(* com.yfw.chengjiaodan.controller.*.*(..)) && !execution(* com.yfw.chengjiaodan.controller.MvcConfigurer.*(..))")
    @Pointcut("execution(* com.yfw.chengjiaodan.controller.*.*(..))")
    public void Pointcut() {

    }


    @Before("Pointcut()")
    public void doBefore() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if (request != null) {
            String servletPath = request.getServletPath();
            log.info(servletPath);
        }
    }
}
