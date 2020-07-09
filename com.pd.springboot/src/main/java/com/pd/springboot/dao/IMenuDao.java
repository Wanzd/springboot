package com.pd.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

import com.pd.businessobject.MenuBO;
import com.pd.businessobject.MenuFO;
import com.pd.standard.web.IStandardDao;

@Mapper
public interface IMenuDao extends IStandardDao<MenuFO, MenuBO> {
}
