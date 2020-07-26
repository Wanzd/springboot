package com.pd.standard.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pd.base.exception.BusinessException;
import com.pd.common.util.ReflectUtil;
import com.pd.common.util.StringX;
import com.pd.standard.itf.IQueryInfoOperation;
import com.pd.standard.itf.IQueryListOperation;

public interface IStandardRest<FO, VO> {

	@RequestMapping("/queryInfo")
	default String queryInfo(FO fo) throws BusinessException {
		IQueryInfoOperation service = ReflectUtil.firstExistField(this, IQueryInfoOperation.class, "business,service,dao");
		return StringX.obj2json(service.queryInfo(fo));
	}

	@RequestMapping(value = "/queryList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	default String queryList(@RequestBody(required = false) FO fo) throws BusinessException {
		IQueryListOperation service = ReflectUtil.firstExistField(this, IQueryListOperation.class, "dao");
		return StringX.obj2json(service.queryList(fo));
	}
}
