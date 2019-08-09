package com.woniu.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

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

import javafx.scene.chart.PieChart.Data;

public class TxtFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session=req.getSession();
//		File file=new File("d:/logs.txt");
//		OutputStream out =new FileOutputStream(file);
		String line="----------------------";	
		User u=(User)session.getAttribute("loginUser");
		String uname=u!=null?u.getUname():"游客";
		String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
		String reqStr=req.getRequestURL()+req.getQueryString();
		
		PrintWriter pw=new PrintWriter(new FileWriter(new File("d:/logs.txt"),true));
		pw.println(line);
		pw.println(uname);
		pw.println(time);
		pw.println(reqStr);
		pw.flush();
		pw.close();
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
