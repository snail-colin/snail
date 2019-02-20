package com.snail.wms.config;

import com.snail.wms.config.aop.LogAspectj;
import com.snail.wms.config.aop.PageHelperAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author colin
 * 2019/2/1
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public LogAspectj logAspectj() {
        return new LogAspectj();
    }

    @Bean
    public PageHelperAspect pageHelperAspect() {
        return new PageHelperAspect();
    }

}
