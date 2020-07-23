package com.pd.common.calobject;

import org.springframework.context.ApplicationContext;

import com.pd.businessobject.MapVO;
import com.pd.springboot.SpringUtil;
import com.pd.standard.itf.IBuilder;
import com.pd.standard.itf.IQueryListOperation;

public class DataSourceTreeGridBuilder implements IBuilder<MapVO, Object> {

	@Override
	public Object build(MapVO in) {
		ApplicationContext ctx = SpringUtil.getContext();
		String viewName = in.str("detail");
		IQueryListOperation bean = ctx.getBean("IViewDao", IQueryListOperation.class);
		MapVO fo = new MapVO();
		fo.put("viewName", viewName);
		in.put("list", bean.queryList(fo));
		return new TreeListBuilder().build(in);
	}

}
