<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="edu.uci.java2.controller.NewBugController, edu.uci.java2.utils.DropDownUtil, java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Bug</title>
</head>
<body>
<h1>New Bug</h1>
<form>
	<p>Summary: <input type="text" name="<% out.print(NewBugController.SUMMARY); %>" required></p>
	<p>Priority: <select id="Priority" name="<% out.print(NewBugController.PRIORITY); %>">
	<%
		@SuppressWarnings("unchecked")
		List<String> priorityList = (List<String>)request.getAttribute(DropDownUtil.PRIORITY_LIST);
		for(String priority: priorityList) {
			StringBuilder sb = new StringBuilder();
			sb.append("<option value=\"");
			sb.append(priority);
			sb.append("\">");
			sb.append(priority);
			sb.append("</option>");
			out.print(sb.toString());
		}
	%>
	</select></p>
	<p>Status: <select id="Status" name="<% out.print(NewBugController.STATUS); %>">
	<%
	@SuppressWarnings("unchecked")
		List<String> statusList = (List<String>)request.getAttribute(DropDownUtil.STATUS_LIST);
		for(String status: statusList) {
			StringBuilder sb = new StringBuilder();
			sb.append("<option value=\"");
			sb.append(status);
			sb.append("\">");
			sb.append(status);
			sb.append("</option>");
			out.print(sb.toString());
		}
	%>	
	</select></p>
	<p>Assigned to: <select id="Assigned" name="<% out.print(NewBugController.ASSIGNED); %>">
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
	<p>Full Description:<br/>
	<textarea name="<% out.print(NewBugController.DESCRIPTION); %>" rows="7" cols="50" required></textarea></p>
	
	<input type="submit" value="Submit"/>
</form>
</body>
</html>