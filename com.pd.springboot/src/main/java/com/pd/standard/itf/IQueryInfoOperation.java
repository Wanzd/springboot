package com.pd.standard.itf;

import org.apache.ibatis.annotations.Param;

public interface IQueryInfoOperation<FO, DTO> {
	DTO queryInfo(@Param("fo") FO in);

	default String queryJson(@Param("fo") FO in) {
		return "not impl";
	};
}
