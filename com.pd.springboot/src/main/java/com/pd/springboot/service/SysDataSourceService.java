package com.pd.springboot.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.businessobject.MapVO;
import com.pd.springboot.dao.ISysDataSourceDao;
import com.pd.standard.itf.IQueryService;

@Named
public class SysDataSourceService implements IQueryService<MapVO, MapVO> {

	@Inject
	private ISysDataSourceDao dao;

	@Override
	public MapVO queryInfo(MapVO dsId) {
		return dao.queryInfo(dsId);
	}

}
