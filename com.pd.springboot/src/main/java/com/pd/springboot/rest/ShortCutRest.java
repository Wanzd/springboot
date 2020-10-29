package com.pd.springboot.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import com.pd.common.util.StringX;
import com.pd.springboot.business.DataSourceBusiness;
import com.pd.springboot.dao.ILookupDao;
import com.pd.springboot.dao.ISysChartDao;
import com.pd.springboot.dao.IUserDao;

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
    private ILookupDao lookupDao;
    @Autowired
    private IUserDao userDao;

    @RequestMapping(value = "/CHART:{id}", produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Object query(@PathParam("") SysChartFO fo) throws BusinessException {
        String jsonData = dao.queryJson(fo);
        if (jsonData == null) {
            return jsonData;
        }
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
        MapVO mapFO = new MapVO(StringX.from(fo));
        return lookupDao.queryCombo(mapFO);
    }

    @RequestMapping(value = "/USER:{userName}", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public List<ComboVO> queryUser(@PathParam("") LookupFO fo) throws BusinessException {
        MapVO mapFO = new MapVO(StringX.from(fo));
        return userDao.queryCombo(mapFO);
    }
}
