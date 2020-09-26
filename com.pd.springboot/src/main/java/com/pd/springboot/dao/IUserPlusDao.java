package com.pd.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pd.businessobject.UserBO;
import com.pd.businessobject.UserFO;
import com.pd.businessobject.UserVO;
import com.pd.standard.itf.IQueryInfoOperation;

@Mapper
public interface IUserPlusDao extends BaseMapper<UserBO>, IQueryInfoOperation<UserFO, UserVO> {

	@Select("select * from user_t where id=#{fo.id}")
	UserVO queryDetailInfo(@Param("fo") UserFO fo);

}