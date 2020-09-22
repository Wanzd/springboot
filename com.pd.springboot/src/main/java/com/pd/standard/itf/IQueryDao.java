package com.pd.standard.itf;

public interface IQueryDao<FO, DTO>
		extends IQueryInfoOperation<FO, DTO>, IQueryListDao<FO, DTO>, IQueryPagedListOperation<FO, DTO> {
}
