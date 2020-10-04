package com.pd.springboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.businessobject.SysMenuBO;
import com.pd.businessobject.SysMenuFO;
import com.pd.springboot.service.WashingMachineService;
import com.pd.standard.web.IStandardRest;

@RestController
@RequestMapping("washingMachineRest")
public class WashingMachineRest implements IStandardRest<SysMenuFO, SysMenuBO> {
    @Autowired
    private WashingMachineService service;

}
