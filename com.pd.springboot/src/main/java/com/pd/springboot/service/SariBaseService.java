package com.pd.springboot.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.businessobject.MapVO;
import com.pd.standard.web.IStandardService;

@Named
public class SariBaseService implements IStandardService<MapVO, MapVO> {
	@Inject
	private com.pd.springboot.dao.IBaseNewsDao dao;

}
