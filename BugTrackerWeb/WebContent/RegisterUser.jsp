<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@include file="includes/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>BugTracker - Register User</title>
</head>
<body>
<div>
<form action="./register" method="post">
<table>
	<tr>
		<td>UserName:</td><td><input type="text" name="username"></td>
		<td>
		<% String userNameError = (String)request.getAttribute("UserNameError");
		if(userNameError!=null){
			out.print(userNameError);
		}%>
		</td>
	</tr><tr>
		<td>Email:</td><td><input type="text" name="email"></td>
		<td>
		<% String emailError = (String)request.getAttribute("EmailError");
		if(emailError!=null){
			out.print(emailError);
		}%>
		</td>
	</tr><tr>
		<td>Password:</td><td><input type="password" name="password"></td>
		<td>
		<% String passWordError = (String)request.getAttribute("PassWordError");
		if(passWordError!=null){
			out.print(passWordError);
		}%>
		</td>
	</tr>
</table>
	<input type="submit" value="Submit"/>
</form>
</div>
</body>
</html>