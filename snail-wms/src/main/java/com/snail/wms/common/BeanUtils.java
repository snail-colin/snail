package com.snail.wms.common;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

public class BeanUtils extends org.apache.commons.beanutils.BeanUtils {

	/**
	 * 复制对象字段属性
	 * 
	 * @param dest
	 * @param orig
	 * @param fieldName
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	private static void copyProperty(Object dest, Object orig, String fieldName)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		// setProperty(dest, fieldName, getProperty(orig, fieldName));
		if (dest != null && orig != null)
			if (PropertyUtils.isReadable(orig, fieldName) && PropertyUtils.isWriteable(dest, fieldName))
				PropertyUtils.setProperty(dest, fieldName, PropertyUtils.getProperty(orig, fieldName));
	}

	/**
	 * 复制排除指定字段的字段
	 * 
	 * @param dest
	 * @param orig
	 * @param fieldNames
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static void copyPropertiesExcludeFields(Object dest, Object orig, String[] fieldNames)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if (dest == null || orig == null)
			return;
		PropertyDescriptor[] pros = PropertyUtils.getPropertyDescriptors(orig);
		for (int i = 0; i < pros.length; i++) {
			PropertyDescriptor pro = pros[i];
			String name = pro.getName();
			if ("class".equals(name)) {
				continue; // No point in trying to set an object's class
			}
			boolean exclude = false;
			if (fieldNames != null) {
				for (String fieldName : fieldNames) {
					if (fieldName.equals(name)) {
						exclude = true;
						break;
					}
				}
			}
			if (exclude)
				continue;
			else
				copyProperty(dest, orig, name);
		}
	}

}
