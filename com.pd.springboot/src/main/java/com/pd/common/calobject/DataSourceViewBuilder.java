package com.pd.common.calobject;

import org.springframework.context.ApplicationContext;

import com.pd.base.exception.BusinessException;
import com.pd.businessobject.MapVO;
import com.pd.springboot.SpringUtil;
import com.pd.standard.itf.IBuilder;
import com.pd.standard.itf.IQueryListDao;

public class DataSourceViewBuilder implements IBuilder<MapVO, Object> {

	@Override
	public Object build(MapVO in) throws BusinessException {
		ApplicationContext ctx = SpringUtil.getContext();
		String viewName = in.str("detail");
		IQueryListDao bean = ctx.getBean("IViewDao", IQueryListDao.class);
		MapVO fo = new MapVO();
		fo.put("viewName", viewName);
		return bean.queryList(fo);
	}

}
