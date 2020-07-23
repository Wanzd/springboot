package com.pd.common.util;

import java.util.Map;

import com.alibaba.fastjson.JSON;

public class ObjectX {
	public static <IN, OUT> OUT x(IN in, Class<OUT> outClass) {
		String jsonString = JSON.toJSONString(in);
		return JSON.parseObject(jsonString, outClass);
	}

	public static <OUT> OUT get(Object target, String attrName, Class<OUT> outClass) {
		if (target instanceof Map) {
			Map map = (Map) target;
			Object attr = map.get(attrName);
			if (attr == null) {
				return null;
			}
			return x(attr, outClass);
		}
		return Reflects.field(target, outClass, attrName);
	}
}
