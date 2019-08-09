package com.woniu.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.woniu.pojo.User;

public class LoginFilter implements Filter {
	String[] passes;
	Boolean flag;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		passes=filterConfig.getInitParameter("pass").split(",");
		 flag=Boolean.parseBoolean(filterConfig.getInitParameter("isUse")); 	
		
	}
	public boolean isPass(String reqStr) {
		for(String s:passes) {
			if(s.equals(reqStr)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse) response;
		

		
		if(flag) {
			String  reqStr=req.getQueryString();
			reqStr=reqStr.substring(reqStr.lastIndexOf("=")+1);
			HttpSession session=req.getSession();
			User loginUser=(User)session.getAttribute("loginUser");
			
			System.out.println(req.getServletPath());
			System.out.println(req.getServerName());
			if(loginUser!=null||isPass(reqStr)){
				chain.doFilter(request, response);
			}else{
				resp.sendRedirect("login.jsp");
			}
			
		}else {
			chain.doFilter(request, response);
		}
		
	}


}
