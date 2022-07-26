package com.example.book.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class BookAspect {
    @Pointcut("within( com.example.book.controller.BookController.*)")
    public void allMethodPointCut() {
    }
    @After("allMethodPointCut()")
    public void afterCallMethod(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"Time"+ LocalDate.now());
    }
}
