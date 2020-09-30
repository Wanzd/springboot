package com.pd.standard.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pd.base.exception.BusinessException;
import com.pd.businessobject.PageVO;
import com.pd.common.util.ReflectUtil;
import com.pd.common.util.Reflects;
import com.pd.standard.itf.IDeleteInfoOperation;
import com.pd.standard.itf.IDeleteListOperation;
import com.pd.standard.itf.IQueryInfoOperation;
import com.pd.standard.itf.IQueryListOperation;
import com.pd.standard.itf.IQueryPagedListOperation;
import com.pd.standard.itf.IUpdateInfoOperation;
import com.pd.standard.itf.IUpdateListOperation;

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
		Object field = ReflectUtil.firstExistField(this, "service");
		if (field instanceof IQueryPagedListOperation) {
			IQueryPagedListOperation op = (IQueryPagedListOperation) field;
			return op.queryPagedList(fo, page);
		}
		if (field instanceof ServiceImpl) {
			ServiceImpl op = (ServiceImpl) field;
			return op.list(null);
		}
		return null;
		// return OperationUtil.operate(OperationEnum.QUERY_PAGED_LIST, this, fo, page);
	}

	@RequestMapping("/updateInfo")
	default int updateInfo(@RequestBody(required = false) VO fo) throws BusinessException {
		IUpdateInfoOperation service = ReflectUtil.firstExistField(this, IUpdateInfoOperation.class,
				"business,service,dao");
		return service.updateInfo(fo);
	}

	@RequestMapping("/updateList")
	default int updateList(@RequestBody(required = false) List<VO> list) throws BusinessException {
		Object field = ReflectUtil.firstExistField(this, "service");
		if (field instanceof IUpdateListOperation) {
			IUpdateListOperation op = (IUpdateListOperation) field;
			return op.updateList(list);
		}
		if (field instanceof ServiceImpl) {
			ServiceImpl op = (ServiceImpl) field;
			op.saveOrUpdateBatch(list);
			return list.size();
		}
		return -1;
	}

	@RequestMapping("/deleteList")
	default int deleteList(@RequestBody(required = false) List<VO> list) throws BusinessException {
		Object field = ReflectUtil.firstExistField(this, "service");
		if (field instanceof IDeleteListOperation) {
			IDeleteListOperation op = (IDeleteListOperation) field;
			return op.deleteList(list);
		}
		if (field instanceof ServiceImpl) {
			ServiceImpl op = (ServiceImpl) field;
			List<Object> idList = list.stream().map(vo -> Reflects.<String>identity(vo)).collect(Collectors.toList());
			op.removeByIds(idList);
			return list.size();
		}
		return -1;
	}

	@RequestMapping("/deleteInfo")
	default int deleteInfo(@RequestBody(required = false) VO fo) throws BusinessException {
		IDeleteInfoOperation op = ReflectUtil.firstExistField(this, IDeleteInfoOperation.class, "business,service,dao");
		return op.deleteInfo(fo);
	}
}
