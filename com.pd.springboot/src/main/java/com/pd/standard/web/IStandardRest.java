package com.pd.standard.web;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pd.base.exception.BusinessException;
import com.pd.businessobject.PageVO;
import com.pd.common.util.ReflectUtil;
import com.pd.standard.itf.IQueryInfoOperation;
import com.pd.standard.itf.IQueryListOperation;
import com.pd.standard.itf.IQueryPagedListOperation;

public interface IStandardRest<FO, VO> {

	@RequestMapping("/queryInfo")
	default Object queryInfo(FO fo) throws BusinessException {
		IQueryInfoOperation service = ReflectUtil.firstExistField(this, IQueryInfoOperation.class,
				"business,service,dao");
		return service.queryInfo(fo);
	}

	@RequestMapping(value = "/queryList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	default List queryList(@RequestBody(required = false) FO fo) throws BusinessException {
		IQueryListOperation service = ReflectUtil.firstExistField(this, IQueryListOperation.class, "service,dao");
		return service.queryList(fo);
	}

	@RequestMapping(value = "/queryPagedList/{pageSize}/{curPage}", method = { RequestMethod.POST })
	@ResponseBody
	default List queryPagedList(@RequestParam(required = false) FO fo, @PathParam(value = "") PageVO page)
			throws BusinessException {
		IQueryPagedListOperation service = ReflectUtil.firstExistField(this, IQueryPagedListOperation.class,
				"service,dao");
		return service.queryPagedList(fo, page);
	}
}
