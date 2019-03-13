package com.baizhi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.baizhi.entity.Admin;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	
	public void afterCompletion(HttpServletRequest req,
			HttpServletResponse res, Object obj, Exception e)
			throws Exception {
		
	}


	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res,
			Object obj, ModelAndView m) throws Exception {
		
	}


	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object obj) throws Exception {
		Admin user = (Admin)req.getSession().getAttribute("login");
		if(user!=null){
			return true;
		}else{
			res.sendRedirect(req.getContextPath()+"/admin/login.jsp");
			return false;
		}
	}
	
}
