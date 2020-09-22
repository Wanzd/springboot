package com.pd.standard.web;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pd.base.exception.BusinessException;
import com.pd.common.util.ReflectUtil;
import com.pd.standard.itf.IDeleteOperation;
import com.pd.standard.itf.IInsertListOperation;
import com.pd.standard.itf.IQueryInfoOperation;
import com.pd.standard.itf.IQueryListDao;
import com.pd.standard.itf.IQueryListOperation;

public interface IStandardService<FO, VO> extends IQueryInfoOperation<FO, VO>, IQueryListOperation<FO, VO> {

	@Override
	default VO queryInfo(FO fo) throws BusinessException {
		IQueryInfoOperation<FO, VO> dao = ReflectUtil.firstExistField(this, IQueryInfoOperation.class, "dao");
		return dao.queryInfo(fo);
	}

	@Override
	default String queryJson(FO fo) throws BusinessException {
		IQueryInfoOperation<FO, VO> dao = ReflectUtil.firstExistField(this, IQueryInfoOperation.class, "dao");
		return dao.queryJson(fo);
	}

	@Override
	default List<VO> queryList(FO fo) throws BusinessException {
		Object field = ReflectUtil.firstExistField(this, "dao");
		if (field instanceof BaseMapper) {
			BaseMapper op = (BaseMapper) field;
			return op.selectList(null);
		} else if (field instanceof IQueryListDao) {
			IQueryListDao op = (IQueryListDao) field;
			return op.queryList(fo);
		}
		return null;
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
