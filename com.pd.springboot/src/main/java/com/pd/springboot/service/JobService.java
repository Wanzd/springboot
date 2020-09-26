package com.pd.springboot.service;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.pd.businessobject.AppJobBO;
import com.pd.springboot.dao.IAppJobPlusDao;
import com.pd.standard.web.IStandardService;

@Named
public class JobService implements IStandardService<AppJobBO, AppJobBO> {
	@Autowired
	private IAppJobPlusDao dao;
}
