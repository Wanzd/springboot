package com.pd.standard.web;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pd.base.exception.BusinessException;
import com.pd.standard.itf.IQueryInfoAction;
import com.pd.standard.itf.IQueryListAction;

public interface IStandardDao<FO, VO> extends IQueryInfoAction<FO, VO>, IQueryListAction<FO, VO> {
	@Override
	List<VO> queryList(@Param("fo") FO fo) throws BusinessException;

	int insertList(@Param("list") List<VO> list) throws BusinessException;

	int updateList(@Param("list") List<VO> list);

	int delete(VO vo) throws BusinessException;
}
