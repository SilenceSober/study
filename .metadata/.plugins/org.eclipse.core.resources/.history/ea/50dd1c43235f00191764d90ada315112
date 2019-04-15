package shiro.config;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import shiro.entity.SysMenu;
import shiro.entity.SysPermission;
import shiro.entity.SysRole;
import shiro.entity.UserInfo;
import shiro.service.MenuService;
import shiro.service.RoleService;
import shiro.service.UserInfoService;

@Slf4j
@Component
public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private MenuService menuService;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Object principal = principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		if (principal instanceof UserInfo) {
			UserInfo userLogin = (UserInfo) principal;
			if (userLogin != null) {
				List<SysRole> roleList = roleService.findByUserid(userLogin.getId());
				if (CollectionUtils.isNotEmpty(roleList)) {
					for (SysRole role : roleList) {
						authorizationInfo.addRole(role.getEnName());
						List<SysMenu> menuList = menuService.getAllMenuByRoleId(role.getId());
						if (CollectionUtils.isNotEmpty(menuList)) {
							for (SysMenu menu : menuList) {
								if (StringUtils.isNotBlank(menu.getPermission())) {
									authorizationInfo.addStringPermission(menu.getPermission());
								}
							}
						}
					}

				}
			}
		}
//				log.info("---------------- 获取到以下权限 ----------------");
//				log.info(authorizationInfo.getStringPermissions().toString());
//				log.info("---------------- Shiro 权限获取成功 ----------------------");
		return authorizationInfo;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
//		log.info("---------------- 执行 Shiro 凭证认证 ----------------------");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String name = token.getUsername();
		// 从数据库获取对应用户名密码的用户
		UserInfo user = userInfoService.findByUsername(name);
		if (user != null) {
			// 用户为禁用状态
			if (!user.getLoginFlag().equals("1")) {
				throw new DisabledAccountException();
			}
//			log.info("---------------- Shiro 凭证认证成功 ----------------------");
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, // 用户
					user.getPassword(), // 密码
					getName() // realm name
			);
			return authenticationInfo;
		}
		throw new UnknownAccountException();
	}
}
