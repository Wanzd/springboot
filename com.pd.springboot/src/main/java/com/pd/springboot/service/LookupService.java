package com.pd.springboot.service;

import javax.inject.Named;

import com.pd.businessobject.LookupFO;
import com.pd.businessobject.LookupVO;
import com.pd.springboot.dao.ILookupDao;

@Named
public class LookupService extends ServiceAdapter<LookupFO, LookupVO, ILookupDao> {
}
