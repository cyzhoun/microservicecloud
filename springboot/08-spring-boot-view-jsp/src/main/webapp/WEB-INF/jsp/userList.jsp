<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>springboot 整合 jsp</title>
</head>
<body>
	<table border="1" align="center" width="70%" >
		<tr bgcolor="red">
			<td align="center">ID</td>
			<td align="center">Name</td>
			<td align="center">Age</td>
		</tr>
		<c:forEach items="${userList }" var="user">
			<tr>
				<td align="center">${user.userid }</td>
				<td align="center">${user.username }</td>
				<td align="center">${user.userage }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>