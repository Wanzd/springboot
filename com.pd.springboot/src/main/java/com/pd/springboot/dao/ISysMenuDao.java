package com.pd.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

import com.pd.businessobject.SysMenuBO;
import com.pd.businessobject.SysMenuFO;
import com.pd.standard.itf.IQueryListOperation;

@Mapper
public interface ISysMenuDao extends IQueryListOperation<SysMenuFO, SysMenuBO> {

}