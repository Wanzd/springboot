package com.pd.springboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.base.exception.BusinessException;
import com.pd.businessobject.SysMenuFO;
import com.pd.businessobject.SysMenuVO;
import com.pd.common.util.StringX;
import com.pd.springboot.service.MenuService;
import com.pd.standard.web.IStandardRest;

@RestController
@RequestMapping("menuRest")
public class MenuRest implements IStandardRest<SysMenuFO, SysMenuVO> {
	@Autowired
	private MenuService service;

	@RequestMapping("/root")
	//@Cacheable(value = "redis", key = "menuRoot")
	public String root() throws BusinessException {
		return StringX.from(service.queryList(new SysMenuFO()));
	}

}
