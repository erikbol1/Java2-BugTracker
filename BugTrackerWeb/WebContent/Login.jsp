<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="includes/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./login" method="post">
	<table>
	<tr>
		<td>User Name:</td><td><input type="text" name="username"></td>
	</tr><tr>
		<td>PassWord:</td><td><input type="password" name="password"></td>		
	</tr>
	</table>
	<input type="submit" value="Login"/>
	<input type="button" onclick="window.location.href='./register'" value="Register"/>
	</form>
</body>
<script type="text/javascript">
<%@include file="includes/errorAllert.jsp" %>
</script>	
</html>
