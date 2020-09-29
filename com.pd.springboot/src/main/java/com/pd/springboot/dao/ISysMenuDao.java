package com.pd.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pd.businessobject.SysMenuBO;
import com.pd.businessobject.SysMenuFO;
import com.pd.businessobject.SysMenuVO;
import com.pd.standard.itf.IQueryListOperation;

@Mapper
public interface ISysMenuDao extends BaseMapper<SysMenuVO>, IQueryListOperation<SysMenuFO, SysMenuBO> {

}