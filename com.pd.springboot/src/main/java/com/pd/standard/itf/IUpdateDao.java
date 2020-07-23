package com.pd.standard.itf;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IUpdateDao<FO, DTO> extends IInsertListOperation<DTO>, IDeleteOperation<FO> {

	int updateList(@Param("list") List<DTO> list) throws SQLException;

	int deleteList(@Param("list") List<DTO> list) throws SQLException;

}
