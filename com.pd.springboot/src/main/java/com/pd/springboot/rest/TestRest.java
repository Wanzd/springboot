package com.pd.springboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.base.exception.BusinessException;
import com.pd.common.util.StringX;
import com.pd.springboot.dao.ITestDao;

@RestController
@RequestMapping("testRest")
public class TestRest {
	@Autowired
	ITestDao dao;

	@RequestMapping("/test1")
	public String root() throws BusinessException {
		return StringX.obj2json(dao.queryList(null));
	}
}
