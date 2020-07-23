package com.pd.standard.itf;

import org.apache.ibatis.annotations.Param;

public interface IQueryDao<FO, DTO>
		extends IQueryInfoOperation<FO, DTO>, IQueryListOperation<FO, DTO>, IQueryPagedListOperation<FO, DTO> {
	@Override
	String queryJson(@Param("fo") FO in);
}
