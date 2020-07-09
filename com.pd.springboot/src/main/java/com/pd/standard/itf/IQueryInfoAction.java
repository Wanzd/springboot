package com.pd.standard.itf;

import com.pd.base.exception.BusinessException;

public interface IQueryInfoAction<IN, OUT> {
	default OUT queryInfo(IN in) throws BusinessException{
		return null;
	}
}
