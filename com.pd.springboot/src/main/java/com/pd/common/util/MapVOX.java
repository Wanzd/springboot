package com.pd.common.util;

import com.pd.businessobject.MapKV;
import com.pd.businessobject.MapVO;

public class MapVOX {

	public static MapVO bridge(MapVO vo, String bridgeStr) {
		return bridge(vo, new MapKV(bridgeStr));
	}

	public static MapVO bridge(MapVO vo, MapKV bridgeKV) {
		MapVO rsMapVO=new MapVO();
		for(String eachKey:bridgeKV.keySet()) {
			rsMapVO.put(bridgeKV.get(eachKey), vo.get(eachKey));
		}
		return rsMapVO;
	}
}
