package com.pd.springboot.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pd.businessobject.MenuBO;
import com.pd.businessobject.MenuFO;
import com.pd.springboot.dao.IMenuDao;
import com.pd.standard.web.IStandardService;

@Service
public class MenuService implements IStandardService<MenuFO, MenuBO> {
	@Resource
	private IMenuDao dao;
}
