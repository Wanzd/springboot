package com.pd.springboot.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pd.businessobject.SysMenuBO;
import com.pd.businessobject.SysMenuFO;
import com.pd.springboot.dao.ISysMenuDao;
import com.pd.standard.web.IStandardService;

@Service
public class MenuService implements IStandardService<SysMenuFO, SysMenuBO> {
	@Resource
	private ISysMenuDao dao;
}
