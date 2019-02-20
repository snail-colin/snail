package com.snail.wms.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author colin
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Length {
	/**
	 * 最小长度
	 * @return
	 */
	public int min() default 1;

	/**
	 * 最大长度
	 * @return
	 */
	public int max();
	
	
	/**
	 * 匹配规则,默认是*
	 * @return
	 */
	public String reg() default "[\\s\\S]*";

	
}
