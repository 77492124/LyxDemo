<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3>用户登录</h3>
	<form action="login.do?method=login" method="post">
		用户名:<input type="text" name="uname" /><br>
		密码:<input type="password" name="upwd" /><br>
		<button>登录</button>
		<button type="reset">重置</button>
		<button type="button" onclick="location.href='reg.jsp'">注册</button>
	</form>
	<font>${font}</font>
</body>
</html>