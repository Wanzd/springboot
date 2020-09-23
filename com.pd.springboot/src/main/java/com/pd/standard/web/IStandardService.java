package com.pd.standard.web;

import java.util.List;

import com.pd.base.exception.BusinessException;
import com.pd.common.enums.OperationEnum;
import com.pd.common.util.OperationUtil;
import com.pd.common.util.ReflectUtil;
import com.pd.standard.itf.IDeleteOperation;
import com.pd.standard.itf.IInsertListOperation;
import com.pd.standard.itf.IQueryInfoOperation;
import com.pd.standard.itf.IQueryListOperation;

public interface IStandardService<FO, VO> extends IQueryInfoOperation<FO, VO>, IQueryListOperation<FO, VO> {

	@Override
	default VO queryInfo(FO fo) throws BusinessException {
		return (VO) OperationUtil.operate(OperationEnum.QUERY_INFO, this, fo);

	}

	@Override
	default String queryJson(FO fo) throws BusinessException {
		IQueryInfoOperation<FO, VO> dao = ReflectUtil.firstExistField(this, IQueryInfoOperation.class, "dao");
		return dao.queryJson(fo);
	}

	@Override
	default List<VO> queryList(FO fo) throws BusinessException {
		return (List<VO>) OperationUtil.operate(OperationEnum.QUERY_LIST, this, fo);
	}

	default int insertList(List<VO> list) throws BusinessException {
		IInsertListOperation<VO> dao = ReflectUtil.firstExistField(this, IInsertListOperation.class, "dao");
		return dao.insertList(list);
	}

	default int delete(VO vo) throws BusinessException {
		IDeleteOperation<VO> dao = ReflectUtil.firstExistField(this, IDeleteOperation.class, "dao");
		return dao.delete(vo);
	}

}
