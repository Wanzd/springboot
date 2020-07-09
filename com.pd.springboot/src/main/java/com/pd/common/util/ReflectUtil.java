package com.pd.common.util;

import java.lang.reflect.Field;

public class ReflectUtil {

	public static <T> T getField(Object target, String attrName, Class<T> outClass) {
		try {
			Field field = target.getClass().getDeclaredField(attrName);
			field.setAccessible(true);
			return (T) field.get(target);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
