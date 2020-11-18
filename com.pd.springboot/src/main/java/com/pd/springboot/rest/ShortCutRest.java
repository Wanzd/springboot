package com.pd.springboot.rest;

import static com.pd.common.util.StaticTool.assertNull;
import static com.pd.common.util.StaticTool.queryJson;

import java.util.List;

import javax.inject.Inject;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.base.exception.BusinessException;
import com.pd.businessobject.ComboVO;
import com.pd.businessobject.LookupFO;
import com.pd.businessobject.MapVO;
import com.pd.businessobject.SysChartFO;
import com.pd.businessobject.SysDataSourceFO;
import com.pd.common.util.QueryBridge;
import com.pd.springboot.business.DataSourceBusiness;
import com.pd.springboot.dao.ISysChartDao;
import com.pd.springboot.dao.IUserDao;
import com.pd.springboot.service.LookupItemService;

/**
 * AI系统
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("")
public class ShortCutRest {
    @Inject
    private ISysChartDao dao;
    @Inject
    private DataSourceBusiness dataSourceBusiness;
    @Autowired
    private LookupItemService lookupItemService;
    @Autowired
    private IUserDao userDao;

    @RequestMapping(value = "/CHART:{id}", produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Object queryChart(@PathParam("") SysChartFO fo) throws BusinessException {
        /* 查询chart配置 */ String jsonData = queryJson(dao, fo);
        /* 校验chart配置非空 */ assertNull(jsonData, "queryJson return null");
        MapVO rs = new MapVO(jsonData);
        SysDataSourceFO sysDataSourceFO = new SysDataSourceFO();
        sysDataSourceFO.setId(rs.str("dataSourceId"));
        Object list = dataSourceBusiness.query(sysDataSourceFO);
        rs.put("list", list);
        return rs;
    }

    @RequestMapping(value = "/LOOKUP:{lookupType}", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public List<ComboVO> queryLookup(@PathParam("") LookupFO fo) throws BusinessException {
        return QueryBridge.queryCombo(lookupItemService, fo);
    }

    @RequestMapping(value = "/USER:{userName}", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public List<ComboVO> queryUser(@PathParam("") LookupFO fo) throws BusinessException {
        return QueryBridge.queryCombo(userDao, fo);
    }
}
