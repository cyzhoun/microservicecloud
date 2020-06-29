<html>
	<head>
		<title>展示用户数据</title>
		<meta charset="utf-8"></meta>
	</head>
	<body>
		<table border="1" align="center" width="60%">
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Age</td>
			</tr>
			<#list userList as user>
				<tr>
					<td>${user.userid}</td>
					<td>${user.username}</td>
					<td>${user.userage}</td>
				</tr>
			</#list>
		</table>
		
	</body>
</html>