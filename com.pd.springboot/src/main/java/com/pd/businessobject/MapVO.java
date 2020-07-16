package com.pd.businessobject;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
public class MapVO extends HashMap<String, Object> {
	public <T> T getValue(String path, Class<T> outClass) {
		String[] pathArray = path.split("\\.");
		HashMap tmpMap = this;
		for (int idx = 0, total = pathArray.length; idx < total; idx++) {
			String curPath = pathArray[idx];
			Object tmpObj = tmpMap.get(curPath);
			if (tmpObj == null) {
				return null;
			}
			if (tmpObj instanceof HashMap) {
				tmpMap = (HashMap) (tmpObj);
				System.out.println(tmpMap);
			}
			if (idx == total - 1) {
				return (T) tmpObj;
			}
		}
		return null;
	}
}
