<%@page import="edu.uci.java2.domain.UserService"%>
<%@page import="edu.uci.java2.domain.User"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
<%
UserService service = new UserService();
User user = service.getUserByID(1);
String userName = user.getUsername();
%>

<h1><%=userName %></h1>
</body>
</html>