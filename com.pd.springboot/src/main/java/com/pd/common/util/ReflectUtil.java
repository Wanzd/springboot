package com.pd.common.util;

import java.lang.reflect.Field;

public class ReflectUtil {

	public static <T> T getField(Object target, Class<T> outClass, String attrName) {
		try {
			Field field = target.getClass().getDeclaredField(attrName);
			field.setAccessible(true);
			return (T) field.get(target);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// exception in plan
		}
		return null;
	}

	public static <IN, OUT> OUT firstExistField(IN in, Class<OUT> outClass, String attrNames) {
		String[] attrArray = attrNames.split(",");
		for (String eachAttr : attrArray) {
			OUT field = getField(in, outClass, eachAttr);
			if (field != null) {
				return field;
			}
		}
		return null;
	}

	public static <IN, OUT> OUT firstExistField(IN in, Class<OUT> outClass, String... attrNames) {
		for (String eachAttr : attrNames) {
			OUT field = getField(in, outClass, eachAttr);
			if (field != null) {
				return field;
			}
		}
		return null;
	}
}
