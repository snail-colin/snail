package com.snail.wms.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

/**
 * @author colin
 * 2019/1/30
 */
@Aspect
public class LogAspectj {

        private  Logger logger = LogManager.getLogger();

        @Pointcut("execution( public * com.snail.wms.controller.*.*(..))")
        public void controllerPointCut() {
        }

        @Pointcut("execution( public * com.snail.wms.service.impl.*.*(..))")
        public void servicePointCut() {
        }

        @Before("controllerPointCut() || servicePointCut()")
        public void logBefore(JoinPoint joinPoint) {
            String className = joinPoint.getTarget().getClass().getSimpleName();
            logger.info("[class = {}] 请求方法 method = {},请求参数 request = {}", className, joinPoint.getSignature().getName(), Arrays.asList(joinPoint.getArgs()));
        }

        @After("controllerPointCut() || servicePointCut()")
        public void logEnd(JoinPoint joinPoint) {
            String className = joinPoint.getTarget().getClass().getSimpleName();
            logger.info("[class = {}],请求方法 method = {}执行结束", className, joinPoint.getSignature().getName());
        }

        @AfterReturning(value = "controllerPointCut() || servicePointCut()", returning = "result")
        public void logResult(JoinPoint joinPoint, Object result) {
            String className = joinPoint.getTarget().getClass().getSimpleName();
            logger.info("[class = {}],请求方法 method = {},返回结果 response = {}", className, joinPoint.getSignature().getName(), result);
        }

//	@Around("pointCut()")
//	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//		Object obj = proceedingJoinPoint.proceed();
//		return obj;
//	}

}
