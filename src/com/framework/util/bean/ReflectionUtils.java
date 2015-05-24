/*
 * @(#)ReflectionUtils.java
 *       
 * 功能描述：反射的Utils函数集合.
 * 公用方法描述：
 * 
 * 修改人：
 * 修改日期：
 * 修改原因：
 * 
 * 
 */
package com.framework.util.bean;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;
 
public class ReflectionUtils { 
    private static Logger log = Logger.getLogger(ReflectionUtils.class.getName());
	
	private ReflectionUtils() {
	}

	/**
	 * 直接读取对象属�?��??,无视private/protected修饰�?,不经过getter函数.
	 */
	public static Object getFieldValue(final Object object, final String fieldName) throws NoSuchFieldException {
		Field field = getDeclaredField(object, fieldName);
		if (!field.isAccessible()) {
			field.setAccessible(true);
		}

		Object result = null;
		try {
			result = field.get(object);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage());
		}
		return result;
	}

	/**
	 * 直接设置对象属�?��??,无视private/protected修饰�?,不经过setter函数.
	 */
	public static void setFieldValue(final Object object, final String fieldName, final Object value)
			throws NoSuchFieldException {
		Field field = getDeclaredField(object, fieldName);
		if (!field.isAccessible()) {
			field.setAccessible(true);
		}
		try {
			field.set(object, value);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * 循环向上转型,获取对象的DeclaredField.
	 */
	public static Field getDeclaredField(final Object object, final String fieldName) throws NoSuchFieldException {
		Assert.notNull(object);
		return getDeclaredField(object.getClass(), fieldName);
	}

	/**
	 * 循环向上转型,获取类的DeclaredField.
	 */ 
	public static Field getDeclaredField(final Class clazz, final String fieldName) throws NoSuchFieldException {
		Assert.notNull(clazz);
		Assert.hasText(fieldName);
		for (Class superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				return superClass.getDeclaredField(fieldName);
			} catch (NoSuchFieldException e) {
				// Field不在当前类定�?,继续向上转型
			}
		}
		throw new NoSuchFieldException("No such field: " + clazz.getName() + '.' + fieldName);
	} 
}
