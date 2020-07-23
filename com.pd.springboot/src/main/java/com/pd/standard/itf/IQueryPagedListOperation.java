package com.pd.standard.itf;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pd.businessobject.PageVO;

public interface IQueryPagedListOperation<FO, DTO> {
	List<DTO> queryPagedList(@Param("fo") FO in, @Param("page") PageVO page);

	int queryCount(@Param("fo") FO fo);
}
