package com.pd.springboot.service;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.pd.businessobject.MapVO;
import com.pd.springboot.dao.ISysDataSourceDao;
import com.pd.standard.web.IStandardService;

@Named
public class SysDataSourceService implements IStandardService<MapVO, MapVO> {

	@Autowired
	private ISysDataSourceDao dao;

}
