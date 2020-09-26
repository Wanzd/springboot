package com.pd.springboot.service;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pd.businessobject.UserBO;
import com.pd.businessobject.UserFO;
import com.pd.businessobject.UserVO;
import com.pd.springboot.dao.IUserPlusDao;
import com.pd.standard.web.IStandardService;

@Named
public class UserService extends ServiceImpl<IUserPlusDao, UserBO> implements IStandardService<UserFO, UserVO> {
	@Autowired
	private IUserPlusDao dao;
}
