package com.me.myprojectapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HttpInterceptor extends HandlerInterceptorAdapter {

	public static final String ROOT_CONTEXT = "/myprojectapp/";

	// before the actual handler will be executed
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();

		System.out.println("Inside http Interceptor");

		// Avoid a redirect loop for some urls
		if (!request.getRequestURI().equals(ROOT_CONTEXT + "user/login.htm")
				&& !request.getRequestURI().equals(ROOT_CONTEXT)
				&& !request.getRequestURI().equals(ROOT_CONTEXT + "user/studentregister.htm")
				&& !request.getRequestURI().equals(ROOT_CONTEXT + "user/adminregister.htm")
				&& !request.getRequestURI().equals(ROOT_CONTEXT + "user/registeras.htm")) {

			if (session.getAttribute("user") == null) {
				response.sendRedirect("/myprojectapp/user/login.htm");
				return false;
			}
		}
		return true;
	}

}
