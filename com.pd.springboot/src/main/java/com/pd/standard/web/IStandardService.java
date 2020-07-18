package com.pd.standard.web;

import java.util.List;

import com.pd.base.exception.BusinessException;
import com.pd.common.util.ReflectUtil;
import com.pd.standard.itf.IQueryInfoAction;
import com.pd.standard.itf.IQueryListAction;

public interface IStandardService<FO, VO> extends IQueryInfoAction<FO, VO>, IQueryListAction<FO, VO> {

	@Override
	default VO queryInfo(FO fo) throws BusinessException {
		IStandardDao<FO, VO> dao = ReflectUtil.getField(this, "dao", IStandardDao.class);
		return dao.queryInfo(fo);
	}

	@Override
	default List<VO> queryList(FO fo) throws BusinessException {
		IStandardDao<FO, VO> dao = ReflectUtil.getField(this, "dao", IStandardDao.class);
		return dao.queryList(fo);
	}

	default int insertList(List<VO> list) throws BusinessException {
		IStandardDao<FO, VO> dao = ReflectUtil.getField(this, "dao", IStandardDao.class);
		return dao.insertList(list);
	}

	default int delete(VO vo) throws BusinessException {
		IStandardDao<FO, VO> dao = ReflectUtil.getField(this, "dao", IStandardDao.class);
		return dao.delete(vo);
	}

}
