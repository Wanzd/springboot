package com.pd.standard.web;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pd.base.exception.BusinessException;
import com.pd.common.util.ReflectUtil;
import com.pd.standard.itf.IQueryListDao;
import com.pd.standard.itf.IQueryListOperation;

public interface IQueryListService<FO, VO> extends IQueryListOperation<FO, VO> {

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

}
