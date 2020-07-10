package com.pd.springboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.base.exception.BusinessException;
import com.pd.businessobject.MenuFO;
import com.pd.common.util.StringX;
import com.pd.springboot.service.MenuService;

@RestController
@RequestMapping("menuRest")
public class MenuRest {
	@Autowired
	MenuService service;

	@RequestMapping("/root")
	public String root() throws BusinessException {
		return StringX.from(service.queryList(new MenuFO()));
	}
}