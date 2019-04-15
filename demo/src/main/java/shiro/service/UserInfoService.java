package shiro.service;

import shiro.entity.UserInfo;

public interface UserInfoService {
	
	public UserInfo findByUsername(String username);

}
