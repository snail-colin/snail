package com.snail.wms.config.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author colin
 * 2019/2/1
 * TODO 待优化
 */
@Aspect
public class CheckAspect {

    private Logger logger = LogManager.getLogger();

    @Pointcut("execution( public * com.snail.wms.controller.*.*(..))")
    public void controllerPointCut() {
    }

    @Before("controllerPointCut()")
    public void logBefore(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        logger.info("[class = {}] 请求方法 method = {},请求参数 request = {}", className, joinPoint.getSignature().getName(), Arrays.asList(joinPoint.getArgs()));
    }

    @After("controllerPointCut()")
    public void logEnd(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        logger.info("[class = {}],请求方法 method = {}执行结束", className, joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "controllerPointCut()", returning = "result")
    public void logResult(JoinPoint joinPoint, Object result) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        logger.info("[class = {}],请求方法 method = {},返回结果 response = {}", className, joinPoint.getSignature().getName(), result);
    }
}
