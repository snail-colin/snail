package com.snail.wms.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 根据指定属性值检验非空
 * @author colin
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotEmptyByAttributes {
	
	/**
	 * 属性名称
	 * @return
	 */
	public String name();

	/**
	 * 属性值
	 * @return
	 */
	public String value();

	/**
	 * 默认不能为空
	 * @return
	 */
	public boolean notEmpty() default true;

}
