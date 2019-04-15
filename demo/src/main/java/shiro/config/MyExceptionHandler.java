package shiro.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
@ResponseBody
public class MyExceptionHandler implements HandlerExceptionResolver {
	@Override
	@ExceptionHandler(AuthorizationException.class)
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv = new ModelAndView();
		FastJsonJsonView view = new FastJsonJsonView();
		Map<String, Object> attributes = new HashMap<String, Object>();
		if (ex instanceof UnauthenticatedException) {
			attributes.put("code", "1000001");
			attributes.put("msg", "token错误");
		} else if (ex instanceof UnauthorizedException) {
			attributes.put("code", "1000002");
			attributes.put("msg", "用户无权限");
		} else {
			attributes.put("code", "1000003");
			attributes.put("msg", ex.getMessage());
		}

		view.setAttributesMap(attributes);
		mv.setView(view);
		return mv;
	}

}
