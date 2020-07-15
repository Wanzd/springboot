package com.pd.standard.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pd.base.exception.BusinessException;
import com.pd.common.util.ReflectUtil;
import com.pd.common.util.StringX;

public interface IStandardRest<FO, VO> {

	@RequestMapping("/queryInfo")
	default String queryInfo(FO fo) throws BusinessException {
		IStandardService service = ReflectUtil.getField(this, "service", IStandardService.class);
		return StringX.obj2json(service.queryInfo(fo));
	}

	@RequestMapping(value = "/queryList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	default String queryList(@RequestBody(required = false) FO fo) throws BusinessException {
		IStandardService service = ReflectUtil.getField(this, "service", IStandardService.class);
		return StringX.obj2json(service.queryList(fo));
	}
}
