package com.pd.springboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.businessobject.LookupFO;
import com.pd.businessobject.LookupVO;
import com.pd.springboot.service.LookupService;
import com.pd.standard.web.IStandardRest;

@RestController
@RequestMapping("lookupRest")
public class LookupRest implements IStandardRest<LookupFO, LookupVO> {
    @Autowired
    private LookupService service;
}
