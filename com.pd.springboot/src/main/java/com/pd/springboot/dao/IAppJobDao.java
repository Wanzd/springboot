package com.pd.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

import com.pd.businessobject.MapVO;
import com.pd.standard.itf.IUpdateDao;

@Mapper
public interface IAppJobDao extends IUpdateDao<MapVO, MapVO> {
}