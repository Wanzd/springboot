package com.pd.standard.itf;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pd.base.exception.BusinessException;

public interface IQueryListDao<FO, DTO> extends IQueryListOperation<FO, DTO> {

	@Override
	List<DTO> queryList(@Param("fo") FO in) throws BusinessException;

}
