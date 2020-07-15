package com.pd.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

import com.pd.businessobject.SysMenuFO;
import com.pd.businessobject.SysMenuVO;
import com.pd.standard.web.IStandardDao;

@Mapper
public interface ISysMenuDao extends IStandardDao<SysMenuFO, SysMenuVO> {
}
