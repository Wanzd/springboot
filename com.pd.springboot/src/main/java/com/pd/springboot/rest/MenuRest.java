package com.pd.springboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.base.exception.BusinessException;
import com.pd.businessobject.SysMenuFO;
import com.pd.businessobject.SysMenuVO;
import com.pd.common.util.StringX;
import com.pd.springboot.dao.ISysMenuDao;
import com.pd.standard.web.IStandardRest;

@RestController
@RequestMapping("menuRest")
public class MenuRest implements IStandardRest<SysMenuFO, SysMenuVO> {
	@Autowired
	private ISysMenuDao dao;

	@RequestMapping("/root")
	public String root() throws BusinessException {
		return StringX.from(dao.queryList(new SysMenuFO()));
	}
}
