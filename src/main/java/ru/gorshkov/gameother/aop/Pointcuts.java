package ru.gorshkov.gameother.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution(* ru.gorshkov.gameother.controller..*.*(.., Long, ..))")
    public void allControllerMethodsWithId() {}
}
