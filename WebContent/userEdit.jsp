<%@page import="com.woniu.pojo.User"%>
<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3>用户编辑</h3>

	<form action="login.do?method=userEdit&uid=${user.uid }" method="post">
		<input type="hidden" name="uid"  value="${user.uid }"/>
		用户名:<input type="text" name="uname"  value="${user.uname }" /><br>
		密码:<input type="password" name="upwd"  value="${user.upwd }"/><br>
		<button>update</button>
		<button type="reset">reset</button>
	</form>
</body>
</html>