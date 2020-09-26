package com.pd.standard.web;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pd.base.exception.BusinessException;
import com.pd.businessobject.PageVO;
import com.pd.common.enums.OperationEnum;
import com.pd.common.util.OperationUtil;
import com.pd.common.util.ReflectUtil;
import com.pd.standard.itf.IDeleteInfoOperation;
import com.pd.standard.itf.IQueryInfoOperation;
import com.pd.standard.itf.IQueryListOperation;
import com.pd.standard.itf.IUpdateInfoOperation;

public interface IStandardRest<FO, VO> {

	@RequestMapping("/queryInfo")
	default Object queryInfo(@RequestBody(required = false) FO fo) throws BusinessException {
		IQueryInfoOperation service = ReflectUtil.firstExistField(this, IQueryInfoOperation.class,
				"business,service,dao");
		return service.queryInfo(fo);
	}

	@RequestMapping("/queryDetailInfo")
	default Object queryDetailInfo(@RequestBody(required = false) FO fo) throws BusinessException {
		Object field = ReflectUtil.firstExistField(this, "business,service,dao");
		if (field instanceof IQueryInfoOperation) {
			IQueryInfoOperation op = (IQueryInfoOperation) field;
			return op.queryDetailInfo(fo);
		}
		if (field instanceof ServiceImpl) {
			ServiceImpl op = (ServiceImpl) field;
			return op.list(null);
		}
		return null;
	}

	@RequestMapping(value = "/queryList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	default List queryList(@RequestBody(required = false) FO fo) throws BusinessException {
		Object field = ReflectUtil.firstExistField(this, "service");
		if (field instanceof IQueryListOperation) {
			IQueryListOperation op = (IQueryListOperation) field;
			return op.queryList(fo);
		}
		if (field instanceof ServiceImpl) {
			ServiceImpl op = (ServiceImpl) field;
			return op.list(null);
		}
		return null;
	}

	@RequestMapping(value = "/queryPagedList/{pageSize}/{curPage}", method = { RequestMethod.POST })
	@ResponseBody
	default Object queryPagedList(@RequestParam(required = false) FO fo, @PathParam(value = "") PageVO page)
			throws BusinessException {
		return OperationUtil.operate(OperationEnum.QUERY_PAGED_LIST, this, fo, page);
	}

	@RequestMapping("/updateInfo")
	default int updateInfo(@RequestBody(required = false) VO fo) throws BusinessException {
		IUpdateInfoOperation service = ReflectUtil.firstExistField(this, IUpdateInfoOperation.class,
				"business,service,dao");
		return service.updateInfo(fo);
	}

	@RequestMapping("/deleteInfo")
	default int deleteInfo(@RequestBody(required = false) VO fo) throws BusinessException {
		IDeleteInfoOperation op = ReflectUtil.firstExistField(this, IDeleteInfoOperation.class, "business,service,dao");
		return op.deleteInfo(fo);
	}
}
