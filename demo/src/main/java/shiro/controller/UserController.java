package shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin/user")
@RestController
public class UserController {
	
	@RequiresPermissions("sys:user:view")
	@RequestMapping("/findList")
	public String findList() {
		return "IsOK";
	}
}
