package com.pd.springboot.service;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.pd.businessobject.MapVO;
import com.pd.standard.web.IStandardService;

@Named
public class SariBaseService implements IStandardService<MapVO, MapVO> {
	@Autowired
	private com.pd.springboot.dao.IBaseNewsDao dao;

}
