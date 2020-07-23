package com.pd.springboot.rest;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pd.businessobject.MapVO;
import com.pd.common.util.ObjectX;
import com.pd.springboot.business.DataSourceBusiness;
import com.pd.springboot.dao.ISysChartDao;

/**
 * AI系统
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("")
public class ChartRest {
	@Inject
	private ISysChartDao dao;
	@Inject
	private DataSourceBusiness dataSourceBusiness;

	@RequestMapping(value = "/CHART:{chartId}", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Object query(@PathVariable String chartId) {
		MapVO fo = new MapVO();
		fo.put("id", chartId);
		String jsonData = dao.queryJson(fo);
		if (jsonData == null) {
			return jsonData;
		}
		MapVO rs = new MapVO(jsonData);
		Object list = dataSourceBusiness.query(rs);
		rs.put("list", list);
		return rs;
	}

	@RequestMapping(value = "/refresh", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Object refresh() throws SQLException {
		List<MapVO> list = dao.queryList(null);
		list.stream().forEach(vo -> vo.put("jsonData", JSON.toJSONString(vo)));
		dao.updateList(list);
		return 0;
	}

}
