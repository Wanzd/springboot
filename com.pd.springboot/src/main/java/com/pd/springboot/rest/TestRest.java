package com.pd.springboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.base.exception.BusinessException;
import com.pd.businessobject.MapVO;
import com.pd.common.util.StringX;
import com.pd.springboot.dao.ITestDao;

@RestController
@RequestMapping("testRest")
public class TestRest {
	@Autowired
	ITestDao dao;

	@RequestMapping("/root")
	public String root() throws BusinessException {
		MapVO queryInfo = dao.queryInfo(new MapVO());
		System.out.println(queryInfo.getValue("c.d.e", String.class));
		return StringX.from(queryInfo);
	}
}
