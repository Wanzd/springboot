package com.pd.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pd.businessobject.UserFO;
import com.pd.businessobject.UserVO;
import com.pd.standard.itf.IQueryInfoOperation;
import com.pd.standard.itf.IUpdateListOperation;

@Mapper
public interface IUserDao extends BaseMapper<UserVO>, IQueryInfoOperation<UserFO, UserVO> {

	@Override
	UserVO queryDetailInfo(@Param("fo") UserFO fo);

}