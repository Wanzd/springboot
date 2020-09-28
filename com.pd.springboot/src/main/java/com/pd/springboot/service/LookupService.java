package com.pd.springboot.service;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pd.businessobject.LookupFO;
import com.pd.businessobject.LookupVO;
import com.pd.springboot.dao.ILookupDao;
import com.pd.standard.web.IStandardService;

@Named
public class LookupService extends ServiceImpl<ILookupDao, LookupVO> implements IStandardService<LookupFO, LookupVO> {
	@Autowired
	private ILookupDao dao;
}
