package com.pd.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

import com.pd.businessobject.MapVO;
import com.pd.standard.itf.IQueryComboOperation;
import com.pd.standard.itf.IQueryDao;
import com.pd.standard.itf.IUpdateDao;

@Mapper
public interface ISysChartDao extends IQueryDao<MapVO, MapVO>, IQueryComboOperation, IUpdateDao<MapVO, MapVO> {
}