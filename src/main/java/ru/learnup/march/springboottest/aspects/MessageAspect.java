package ru.learnup.march.springboottest.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessageAspect {

    private static final Logger log = LoggerFactory.getLogger(MessageAspect.class);

    @AfterReturning(value="@annotation(ru.learnup.march.springboottest.annotations.LogMethod)", returning = "result")
    public void beforeAnnotation(JoinPoint joinPoint, Object result) {
        log.info("Имя метода: {}", joinPoint.getSignature().getName());
        log.info("Параметры метода: {}", joinPoint.getArgs());
        log.info("Возвращаемое значение: {}", result);
    }
}
