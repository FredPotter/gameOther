package ru.gorshkov.gameother.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.gorshkov.gameother.logging.Logging;
import ru.gorshkov.gameother.logging.MethodInfoForLogBuilder;

@Aspect
@Component
public class LoggingAspect {
    Logging logger = new Logging();

    @Around("Pointcuts.allControllerMethodsWithId()")
    public Object aroundAllMainControllerMethodsWithID(ProceedingJoinPoint proceedingJoinPoint) {
        MethodInfoForLogBuilder methodInfoBuilder = new MethodInfoForLogBuilder(proceedingJoinPoint.getSignature(), proceedingJoinPoint.getArgs());
        String methodInfo = methodInfoBuilder.buildMethodInfoForLog();
        Long id = (Long) methodInfoBuilder.getFieldFromMethod("id");

        logger.info(id, methodInfo, "request starts");
        Long startTime = System.currentTimeMillis();
        Object result;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            logger.error(id, methodInfo, e.getMessage());
            throw new RuntimeException(e);
        }

        Long endTime = System.currentTimeMillis();

        logger.info(id, methodInfo, "request finished with success with result: " + result + " by " + (endTime - startTime) + " millis");

        return result;
    }
}
