<%@page import="com.woniu.pojo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".del").click(function(){
			var sel=window.confirm("是否删除该用户");
			if(sel){
				$(location).attr("href","login.do?method=userDel&uid="+$(this).val());
			}
		});
		$(".edit").click(function(){
			$(location).attr("href","login.do?method=userGet&uid="+$(this).val());
		});
	});
</script>
</head>
<body>
	
	<table width="800" border="1">
		<caption><h3>用户管理</h3></caption>
		<tr>
			<th>序号</th>
			<th>用户名</th>
			<th>密码</th>
			<th>删除</th>
			<th>编辑</th>
		</tr>

				
				<c:forEach items="${users}" var="u"  varStatus="i">
					<tr>
						<th>${i.index+1}</th>
						<th>${u.uname }</th>
						<th>${u.upwd}</th>
						<th><button type="button" class="del" value="${u.uid}">Del</button></th>
						<th><button type="button" class="edit" value="${u.uid}">Edit</button></th>
						
					</tr>
				</c:forEach>
			
	</table>
</body>
</html>