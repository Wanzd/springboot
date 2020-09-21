package com.pd.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.pd.base.exception.BusinessException;
import com.pd.businessobject.SysInfoBO;
import com.pd.businessobject.SysInfoFO;
import com.pd.businessobject.SysInfoVO;
import com.pd.springboot.dao.ISysInfoDao;
import com.pd.standard.web.IStandardService;

@Named
public class InfoService implements IStandardService<SysInfoFO, SysInfoVO> {
	@Autowired
	private ISysInfoDao dao;

	@Override
	public List<SysInfoVO> queryList(SysInfoFO fo) throws BusinessException {
		Map<String, String> getenv = System.getenv();
		List<SysInfoVO> rsList = new ArrayList<>();
		getenv.entrySet().stream().forEach(entry -> {
			rsList.add(new SysInfoVO("env", entry.getKey(), entry.getValue()));
		});

		List<SysInfoBO> selectList = dao.selectList(null);
		selectList.forEach(bo -> {
			SysInfoVO vo = new SysInfoVO();
			vo.setSource("db");
			vo.setKey(bo.getKey());
			vo.setValue(bo.getValue());
			rsList.add(vo);
		});

		return rsList;
	}
}
