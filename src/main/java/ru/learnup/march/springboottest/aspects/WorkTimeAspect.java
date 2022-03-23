package ru.learnup.march.springboottest.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WorkTimeAspect {

    private static final Logger log = LoggerFactory.getLogger(WorkTimeAspect.class);

    @Around("@annotation(ru.learnup.march.springboottest.annotations.WorkTime)")
    public void aroundAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long finalTime = System.currentTimeMillis();
        log.info("Имя метода: {}", joinPoint.getSignature().getName());
        log.info("Время работы метода: {} мс", finalTime - startTime);
    }
}
