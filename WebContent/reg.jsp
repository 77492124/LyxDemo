<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h4>用户注册</h4>
	<form action="login.do?method=reg" method="post">
		用户名:<input type="text" name="uname" /><br>
		密码:<input type="password" name="upwd" /><br>
		<button>注册</button>
		<button type="reset">重置</button>
	</form>
</body>
</html>