package com.pd.springboot.service;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pd.businessobject.SysChartBO;
import com.pd.businessobject.SysChartFO;
import com.pd.springboot.dao.ISysChartDao;
import com.pd.standard.web.IStandardService;

@Named
public class SysChartService extends ServiceImpl<ISysChartDao, SysChartBO>
        implements IStandardService<SysChartFO, SysChartBO> {
    @Autowired
    private ISysChartDao dao;

}
