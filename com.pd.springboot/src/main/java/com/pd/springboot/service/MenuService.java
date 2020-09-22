package com.pd.springboot.service;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.pd.businessobject.SysMenuBO;
import com.pd.businessobject.SysMenuFO;
import com.pd.springboot.dao.ISysMenuDao;
import com.pd.standard.web.IStandardService;

@Named
public class MenuService implements IStandardService<SysMenuFO, SysMenuBO> {
	@Autowired
	private ISysMenuDao dao;

}
