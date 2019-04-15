package shiro.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shiro.dao.UserInfoDao;
import shiro.entity.UserInfo;
import shiro.service.UserInfoService;

@Service("shiroService")
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private	UserInfoDao userInfoDao;
	
	@Override
	public UserInfo findByUsername(String userName) {
		return userInfoDao.findByUsername(userName);
	}

}
