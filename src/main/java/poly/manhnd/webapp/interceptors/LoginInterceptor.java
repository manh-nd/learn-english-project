package poly.manhnd.webapp.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import poly.manhnd.webapp.entities.User;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(object instanceof String == false) {
			User user = (User) object;
			if(user!=null) {
				response.sendRedirect("/");
				return false;
			}
		}
		return true;
	}

}
