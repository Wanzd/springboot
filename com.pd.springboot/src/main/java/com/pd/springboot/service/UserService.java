package com.pd.springboot.service;

import javax.inject.Named;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pd.businessobject.UserVO;
import com.pd.springboot.dao.IUserDao;

@Named
public class UserService extends ServiceImpl<IUserDao, UserVO> {

}
