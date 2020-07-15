package com.pd.common.util;

import com.alibaba.fastjson.JSON;

public class StringX {

	public static String from(Object in) {
		if (in == null) {
			return null;
		}
		return JSON.toJSONString(in);
	}

	public static String obj2json(Object obj) {
		return JSON.toJSONString(obj);
	}

}
