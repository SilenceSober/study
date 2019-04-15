package shiro.service;

import java.util.List;

import shiro.entity.SysMenu;

public interface MenuService {
	
	
	public List<SysMenu> getAllMenuByRoleId(Integer roleId);
}
