package com.pd.springboot.service;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.pd.businessobject.SysInfoFO;
import com.pd.businessobject.SysInfoVO;
import com.pd.springboot.dao.ISysInfoDao;
import com.pd.standard.web.IQueryListService;

@Named
public class InfoService implements IQueryListService<SysInfoFO, SysInfoVO> {
	@Autowired
	private ISysInfoDao dao;

}
