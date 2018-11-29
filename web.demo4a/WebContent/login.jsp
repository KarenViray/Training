<%@ page language="java" %>
<jsp:useBean id="loginForm" class="com.training.demo.bean.LoginForm" scope="request"/>
<html>
	<head>
		<title>Login Page</title>
		<style type="text/css">
			.error {
				color: red;
				font-weight: bold;
			}
		</style>
	</head>
	<body>
		<h1>Login Page</h1>
		<form action="<%= request.getContextPath() %>/login.do" method="post">
			<p>
				<label>Username</label>
				<input type="text" name="username" value="<%=loginForm.getUsername()%>">
				<label for="error" class="error"><%= loginForm.getError("username") %></label>
			</p>
			<p>
				<label>Password</label>
				<input type="password" name="password">
				<label for="error" class="error"><%= loginForm.getError("password") %></label>
			</p>
			<p>				
				<input type="submit" value="Login">
			</p>
		</form>
	</body>
</html>