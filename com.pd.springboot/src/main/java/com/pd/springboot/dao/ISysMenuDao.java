package com.pd.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

import com.pd.businessobject.SysMenuBO;
import com.pd.businessobject.SysMenuFO;
import com.pd.standard.itf.IQueryListDao;

@Mapper
public interface ISysMenuDao extends IQueryListDao<SysMenuFO, SysMenuBO> {
}
