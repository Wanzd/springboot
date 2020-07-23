package com.pd.common.calobject;

import com.pd.businessobject.MapVO;
import com.pd.springboot.SpringUtil;
import com.pd.springboot.dao.ISysObjDao;
import com.pd.standard.itf.IBuilder;

public class DataSourceObjBuilder implements IBuilder<MapVO, Object> {

	@Override
	public Object build(MapVO in) {
		String objId = in.str("detail");
		ISysObjDao dao = SpringUtil.getBean("ISystemObjDao", ISysObjDao.class);
		MapVO fo = new MapVO();
		fo.put("objId", objId);
		String jsonData = dao.queryJson(fo);
		return new MapVO(jsonData);
	}

}
