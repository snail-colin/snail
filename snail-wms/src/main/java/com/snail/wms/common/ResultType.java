package com.snail.wms.common;


/**
 * 
 * 方法本身运行是否正确的结果类型
 * 
 * @author colin
 */
public enum ResultType {
	//方法成功执行并返回了业务人员需要的结果
	success,
	//方法成功执行但是返回的是业务人员不需要的结果
	error,
	//方法执行抛出了Exception
	exception;
}
