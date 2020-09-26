package com.pd.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pd.businessobject.SysInfoBO;

@Mapper
public interface ISysInfoDao extends BaseMapper<SysInfoBO> {
}