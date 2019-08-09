package com.woniu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.dao.UserDAO;
import com.woniu.pojo.User;

public class UserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method=req.getParameter("method");
		if(method==null||method.equals("login")) {
			login(req,resp);
		}else if(method.equals("findAll")) {
			List(req,resp);
		}else if(method.equals("userDel")) {
			UserDel(req,resp);
		}else if(method.equals("userGet")) {
			UserGet(req,resp);
		}else if(method.equals("userEdit")) {
			UserEdit(req,resp);
		}else if(method.equals("reg")) {
			reg(req,resp);
		}
		
		
	}

	private void reg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String uname=req.getParameter("uname");
		String upwd=req.getParameter("upwd");
		UserDAO ud =new UserDAO();
		ud.save(new User(null, uname, upwd));
		resp.sendRedirect("login.do?method=login");
		
	}

	private void UserEdit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int uid=Integer.parseInt(req.getParameter("uid"));
		String uname=req.getParameter("uname");
		String upwd=req.getParameter("upwd");
		
		UserDAO ud =new UserDAO();
		ud.edit(new User(uid, uname, upwd));

		resp.sendRedirect("login.do?method=findAll");
		
	}

	private void UserGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int uid=Integer.parseInt(req.getParameter("uid"));
		UserDAO ud =new UserDAO();
		User user=ud.findOne(uid);
		req.setAttribute("user", user);
		req.getRequestDispatcher("userEdit.jsp").forward(req, resp);
//		resp.sendRedirect("userEdit.jsp");
		
	}






	private void UserDel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int uid=Integer.parseInt(req.getParameter("uid"));
		UserDAO ud =new UserDAO();
		ud.delete(uid);
		resp.sendRedirect("login.do?method=findAll");
		
	}



	private void List(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO ud= new UserDAO();
		java.util.List<User> users=ud.findAll();
		req.setAttribute("users", users);
		req.getRequestDispatcher("userList.jsp").forward(req, resp);
//		resp.sendRedirect("userList.jsp");
		
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String uname=req.getParameter("uname");
		String upwd=req.getParameter("upwd");
		UserDAO ud=new UserDAO();
		User loginUser=ud.login(new User(null,uname,upwd));
		if(loginUser!=null) {
			req.getSession().setAttribute("loginUser", loginUser);
			resp.sendRedirect("login.do?method=findAll");
		}else {
//			resp.sendRedirect("login.do?method=null");
			resp.sendRedirect("login.jsp");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
