package com.pd.standard.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pd.base.exception.BusinessException;
import com.pd.common.enums.OperationEnum;
import com.pd.common.util.OperationUtil;
import com.pd.common.util.ReflectUtil;
import com.pd.common.util.StringX;
import com.pd.standard.itf.IDeleteInfoOperation;
import com.pd.standard.itf.IDeleteOperation;
import com.pd.standard.itf.IInsertListOperation;
import com.pd.standard.itf.IQueryInfoOperation;
import com.pd.standard.itf.IQueryListOperation;
import com.pd.standard.itf.IUpdateInfoOperation;

public interface IStandardService<FO, VO> extends IQueryInfoOperation<FO, VO>, IQueryListOperation<FO, VO>,
		IUpdateInfoOperation<VO>, IDeleteInfoOperation<VO> {

	@Override
	default VO queryInfo(FO fo) throws BusinessException {
		Object field = ReflectUtil.firstExistField(this, "dao,service,business");
		if (field instanceof BaseMapper) {
			BaseMapper op = (BaseMapper) field;
			String jsonStr = StringX.from(fo);
			return (VO) op.selectById(JSON.parseObject(jsonStr, HashMap.class));
		}
		IQueryInfoOperation op = (IQueryInfoOperation) field;
		return (VO) op.queryInfo(fo);

	}

	@Override
	default VO queryDetailInfo(FO fo) throws BusinessException {
		Object field = ReflectUtil.firstExistField(this, "dao,service,business");
		IQueryInfoOperation op = (IQueryInfoOperation) field;
		return (VO) op.queryDetailInfo(fo);

	}

	@Override
	default String queryJson(FO fo) throws BusinessException {
		return (String) OperationUtil.operate(OperationEnum.QUERY_JSON, this, fo);
	}

	@Override
	default List<VO> queryList(FO fo) throws BusinessException {
		Object field = ReflectUtil.firstExistField(this, "dao,service,business");
		if (field instanceof BaseMapper) {
			BaseMapper op = (BaseMapper) field;
			return op.selectList(null);
		}
		IQueryListOperation op = (IQueryListOperation) field;
		return op.queryList(fo);
		// return (List<VO>) OperationUtil.operate(OperationEnum.QUERY_LIST, this, fo);
	}

	default int insertList(List<VO> list) throws BusinessException {
		IInsertListOperation<VO> dao = ReflectUtil.firstExistField(this, IInsertListOperation.class, "dao");
		return dao.insertList(list);
	}

	default int delete(VO vo) throws BusinessException {
		IDeleteOperation<VO> dao = ReflectUtil.firstExistField(this, IDeleteOperation.class, "dao");
		return dao.delete(vo);
	}

	@Override
	default int updateInfo(VO vo) throws BusinessException {
		Object field = ReflectUtil.firstExistField(this, "dao,service,business");
		if (field instanceof BaseMapper) {
			BaseMapper op = (BaseMapper) field;
			return op.updateById(vo);
		}
		IUpdateInfoOperation<VO> dao = ReflectUtil.firstExistField(this, IUpdateInfoOperation.class, "dao");
		return dao.updateInfo(vo);
	}

	@Override
	default int deleteInfo(VO vo) throws BusinessException {
		Object field = ReflectUtil.firstExistField(this, "dao,service,business");
		if (field instanceof BaseMapper) {
			BaseMapper op = (BaseMapper) field;
			return op.deleteById((Serializable) vo);
		}
		IUpdateInfoOperation<VO> dao = ReflectUtil.firstExistField(this, IUpdateInfoOperation.class, "dao");
		return dao.updateInfo(vo);
	}
}
