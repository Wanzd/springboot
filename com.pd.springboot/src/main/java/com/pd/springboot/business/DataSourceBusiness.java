package com.pd.springboot.business;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.base.exception.BusinessException;
import com.pd.businessobject.MapVO;
import com.pd.common.calobject.DataSourceObjBuilder;
import com.pd.common.calobject.DataSourceTreeGridBuilder;
import com.pd.common.calobject.DataSourceViewBuilder;
import com.pd.springboot.service.SysDataSourceService;
import com.pd.standard.itf.IBuilder;

@Named
public class DataSourceBusiness {
	private static Map<String, IBuilder<MapVO, Object>> builderMap = initBuilderMap();
	@Inject
	private SysDataSourceService service;

	public Object query(MapVO fo) throws BusinessException {
		MapVO map = service.queryInfo(fo);
		if (map == null) {
			return null;
		}
		IBuilder<MapVO, Object> opBuilder = builderMap.get(map.str("type"));
		return opBuilder.build(map);
	}

	/**
	 * 初始化执行器地图
	 * 
	 * @return
	 */
	private static Map<String, IBuilder<MapVO, Object>> initBuilderMap() {
		Map<String, IBuilder<MapVO, Object>> opMap = new HashMap<>();
		opMap.put("view", new DataSourceViewBuilder());
		opMap.put("obj", new DataSourceObjBuilder());
		opMap.put("treeGrid", new DataSourceTreeGridBuilder());
		return opMap;
	}
}
