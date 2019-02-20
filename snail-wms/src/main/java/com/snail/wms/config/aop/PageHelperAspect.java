package com.snail.wms.config.aop;

import com.github.pagehelper.PageHelper;
import com.snail.wms.common.PageRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;
import java.util.List;

/**
 * @author colin
 * 2019/2/1
 * 分页插件aop
 */
@Aspect
public class PageHelperAspect {

        private Logger logger = LogManager.getLogger();

        @Pointcut("execution( public com.github.pagehelper.PageInfo<*> com.snail.wms.service.impl.*.*(..))")
        public void pageHelperPointCut() {
        }

        @Before("pageHelperPointCut()")
        public void logBefore(JoinPoint joinPoint) {
            String className = joinPoint.getTarget().getClass().getSimpleName();
            List<Object> objects = Arrays.asList(joinPoint.getArgs());
            PageRequest<?> page = (PageRequest<?>)objects.get(0);
            logger.info("[class = {}][设置分页参数] 请求方法 method = {},请求参数 request = {}", className, joinPoint.getSignature().getName(), page);
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
        }

}
