package com.pd.springboot.service;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pd.base.exception.BusinessException;
import com.pd.businessobject.UserFO;
import com.pd.businessobject.UserVO;
import com.pd.common.enums.UserExportConfigEum;
import com.pd.springboot.dao.IUserDao;
import com.pd.standard.web.IStandardService;

@Named
public class UserService extends ServiceImpl<IUserDao, UserVO> implements IStandardService<UserFO, UserVO> {
	@Autowired
	private IUserDao dao;

	@Override
	public Class getExportConfig() {
		return UserExportConfigEum.class;
	}

}
