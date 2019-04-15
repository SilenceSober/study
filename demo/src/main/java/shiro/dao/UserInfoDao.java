package shiro.dao;

import shiro.entity.UserInfo;

public interface  UserInfoDao {

	UserInfo findByUsername(String userName);
	
}
