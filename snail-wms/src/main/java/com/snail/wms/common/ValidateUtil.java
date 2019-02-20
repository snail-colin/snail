package com.snail.wms.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {

	/**
	 * 检验手机号
	 */
	public static final String CHECK_PHONE_REG = "1[3,4,5,6,7,8,9]\\d{9}";
	
	/**
	 * 校验省份
	 */
	public static final String CHECK_PROVINCE_REG="[\u4e00-\u9fa5]{0,10}";
	/**
	 * 校验城市
	 */
	public static final String CHECK_CITY_REG="[\u4e00-\u9fa5]{0,15}";
	/**
	 * 校验区
	 */
	public static final String CHECK_AREA_REG="[\u4e00-\u9fa5]{0,10}";

	/**
	 * 校验邮政编码
	 */
	public static final String CHECK_ZIP_CODE_REG="\\d{6}";
	
	/**
	 * 校验日期
	 */
	public static final String CHECK_TIME_REG = "\\d{14}";
	
	/**
	 * 校验出生日期
	 */
	public static final String CHECK_BIRTHDAY_REG = "\\d{8}";
	
	/**
	 * 校验身份证
	 */
	public static final String CHECK_ID_CARD_REG = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9xX])$";
	/**
	 * 检验名称
	 */
	public static final String CHECK_NAME_REG="[\u4e00-\u9fa5]{0,8}";
	
	public static Matcher getMatcher(String reg,String target){
		 Pattern pattern = Pattern.compile(reg);
		 Matcher matcher = pattern.matcher(target);
		 return matcher;
	}
	
	/**
	 * 校验手机号
	 * @param phone
	 * @return
	 */
	public   boolean checkPhone(String phone){
		Matcher matcher = getMatcher(CHECK_PHONE_REG,phone);
		return matcher.matches();
	}
	
}
