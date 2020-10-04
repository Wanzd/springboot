package com.pd.springboot.service;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pd.businessobject.SysDataSourceBO;
import com.pd.businessobject.SysDataSourceFO;
import com.pd.springboot.dao.ISysDataSourceDao;
import com.pd.standard.web.IStandardService;

@Named
public class SysDataSourceService extends ServiceImpl<ISysDataSourceDao, SysDataSourceBO>
        implements IStandardService<SysDataSourceFO, SysDataSourceBO> {
    @Autowired
    private ISysDataSourceDao dao;

}
