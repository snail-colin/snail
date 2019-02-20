/**
 * 
 */
package com.snail.wms.common.enums;

public enum CodeEnum {

	N00000("00000","成功"),
	N00001("00001","失败"),
	N00002("00002","必传参数不能为空"),
	N00003("00003","请求参数不合法"),
	N00004("00004","bean entity 参数转换失败"),


	N00010("00010","该账号已被注册"),
	N00011("00011","用户不存在"),
	;
	private String code;
	private String msg;

	CodeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
