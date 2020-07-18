package com.pd.springboot.dao;

import java.util.List;

import com.pd.businessobject.MapVO;
import com.pd.standard.web.IStandardDao;

public interface IAppSariDao extends IStandardDao<MapVO, MapVO> {
	void initChinaData();
}