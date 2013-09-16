<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="
    	edu.uci.java2.controller.EmailController, 
    	edu.uci.java2.utils.DropDownUtil,  
    	java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Email Bug</title>
</head>
<body>
<h2>Email about bug #<% out.print(request.getAttribute(EmailController.BUG_ID)); %></h2>
<form>
	<input type="hidden" name="<% out.print(EmailController.BUG_ID); %>" value="<% out.print(request.getAttribute(EmailController.BUG_ID)); %>" />
	<p>Email to: <select name="<% out.print(EmailController.USERNAME); %>">
	<%
	@SuppressWarnings("unchecked")
		List<String> usernameList = (List<String>)request.getAttribute(DropDownUtil.USERNAME_LIST);
		for(String username: usernameList) {
			StringBuilder sb = new StringBuilder();
			sb.append("<option value=\"");
			sb.append(username);
			sb.append("\">");
			sb.append(username);
			sb.append("</option>");
			out.print(sb.toString());
		}
	%>	
	</select></p>
	<p>Subject: <% out.print(request.getAttribute(EmailController.SUBJECT_INTRO)); %>
		<input type="text" name="<% out.print(EmailController.SUBJECT); %>" /> </p>
	<p>Body: <br/>
	<textarea name="<% out.print(EmailController.BODY); %>" rows="7" cols="50" required></textarea></p>
	<input type="submit" value="Send" />
</form>
</body>
</html>