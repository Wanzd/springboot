package com.pd.springboot.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.base.exception.BusinessException;
import com.pd.businessobject.ComboVO;
import com.pd.businessobject.LookupFO;
import com.pd.businessobject.LookupVO;
import com.pd.businessobject.MapVO;
import com.pd.common.util.StringX;
import com.pd.springboot.dao.ILookupDao;
import com.pd.standard.web.IStandardRest;

@RestController
@RequestMapping("")
public class LookupRest implements IStandardRest<LookupFO, LookupVO> {
	@Autowired
	private ILookupDao dao;

	@RequestMapping(value = "/LOOKUP:{lookupType}", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<ComboVO> lookup(@PathParam("") LookupFO fo) throws BusinessException {
		MapVO mapFO = new MapVO(StringX.from(fo));
		return dao.queryCombo(mapFO);
	}

}
