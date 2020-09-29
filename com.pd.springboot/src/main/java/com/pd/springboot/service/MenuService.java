package com.pd.springboot.service;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pd.businessobject.SysMenuBO;
import com.pd.businessobject.SysMenuFO;
import com.pd.businessobject.SysMenuVO;
import com.pd.springboot.dao.ISysMenuDao;
import com.pd.standard.web.IStandardService;

@Named
public class MenuService extends ServiceImpl<ISysMenuDao, SysMenuVO> implements IStandardService<SysMenuFO, SysMenuBO> {
	@Autowired
	private ISysMenuDao dao;

}
