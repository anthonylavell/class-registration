package com.jrp.cra.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ApplicationLoggerAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.jrp.cra.controller..*)"+"|| within(com.jrp.cra.dao..*)")
    public void definePackagePointcuts(){
        // empty method just to name the location specified in the pointcut
    }

    @Around("definePackagePointcuts()")
    public Object logAround(ProceedingJoinPoint jp){
        log.debug(" \n \n \n ");
        log.debug("***************** Before Method Execution ************* \n {}.{} () " +
                "with arguments [s] = {}", jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
        log.debug("___________________ \n \n \n");

        Object o = null;

        try {

        } catch (Throwable e) {
            // TODD Auto-generated catch block
            e.printStackTrace();
        }

        log.debug("***************** After Method Execution ************* \n {}.{} () " +
                        "with arguments [s] = {}", jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
        log.debug("___________________ \n \n \n");

        return o;
    }

}
