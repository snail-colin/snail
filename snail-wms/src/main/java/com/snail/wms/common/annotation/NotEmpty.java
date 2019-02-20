package com.snail.wms.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author colin
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotEmpty {
	public boolean values() default true;
}
