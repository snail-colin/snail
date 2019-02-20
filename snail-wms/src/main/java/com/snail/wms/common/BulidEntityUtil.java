package com.snail.wms.common;

import org.apache.commons.lang.StringUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


/**
 * 实体对象构建工具
 * @author colin
 *
 */
public class BulidEntityUtil {
	
	
	/**
	 * 构建实体对象
	 * @param provideObject
	 * @param properties  排除的属性
	 * @throws IntrospectionException
	 */
	public static <T> T bulidEntity(Class<T> clazz, Map<String, Object> provideObject, String[] properties) throws IntrospectionException {
		   BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
	        // 获取bean属性
	        PropertyDescriptor[] pros = beanInfo.getPropertyDescriptors();
	        Map<String, Object> converMap = new HashMap<>(pros.length);
	    	for (int i = 0; i < pros.length; i++) {
				PropertyDescriptor pro = pros[i];
				String name = pro.getName();
				if ("class".equals(name)) {
					continue; 
				}
				//排除不需要的字段
				boolean exclude = false;
				if (properties != null) {
					for (String fieldName : properties) {
						if (fieldName.equals(name)) {
							exclude = true;
							break;
						}
					}
				}
				if (exclude) {
					//provideObject.remove(name);
					continue;
				}

				converMap.put(name, provideObject.get(name));

			}
	    	//对象转换
//	    	return ConvertorUtil.nMap2pojo(clazz, converMap);
	    	T instance = null;
	    	try {
	    		instance =	ConvertorUtil.objectMapper.readValue(ConvertorUtil.objectMapper.writeValueAsBytes(converMap), clazz);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	return instance;
	}

	/**
	 * 构建实体对象
	 * @param clazz
	 * @param provideObject
	 * @return
	 * @throws IntrospectionException
	 */
	public static <T> T bulidEntity(Class<T> clazz, Map<String, Object> provideObject) throws IntrospectionException {
		return bulidEntity(clazz,provideObject,null);
	}
	

	/**
	 * 
	 * @param clazz
	 * @param provideObject
	 * @return
	 * @throws IntrospectionException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T bulidEntity(Class<T> clazz, String provideObject) throws IntrospectionException {
		Map<String, Object> provideObjectMap = ConvertorUtil.json2map(provideObject);
		return bulidEntity(clazz,provideObjectMap,null);
	}
	
	/**
	 * 构建对象
	 * 
	 * @param targetObject
	 * @param provideObject
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public static void bulidEntity(Object targetObject, Object provideObject, String[] properties) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		// 复制属性值给targetObject
		BeanUtils.copyPropertiesExcludeFields(targetObject, provideObject, properties);
	}
}
