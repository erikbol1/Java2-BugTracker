<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="
    	edu.uci.java2.controller.BugDetailsController, 
    	edu.uci.java2.utils.DropDownUtil, 
    	edu.uci.java2.utils.WebDateUtil, 
    	edu.uci.java2.domain.Bug, 
    	java.util.List" %>
    <% Bug currentBug = (Bug)request.getAttribute("bug"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
</head>
<body>
<h2>Details for Bug# <% out.print(currentBug.getID()); %></h2>
<form>
	<input type="hidden" name="<% out.print(BugDetailsController.HIDDEN_BUG_ID); %>" value="<% out.print(currentBug.getID()); %>" />
	<p>Summary: <input type="text" name="<% out.print(BugDetailsController.SUMMARY); %>" value="<% out.print(currentBug.getSummary()); %>"></p>
	<p>Date Entered: <% 
		String createdDate = WebDateUtil.formatForWebpageDisplay(currentBug.getCreatedDate());
		out.print(createdDate); 
	%></p>
	<input type="hidden" name="<% out.print(BugDetailsController.CREATED_DATE); %>" value="<% out.print(createdDate); %>"/>
	<p>Last Update: <% 
		String updatedDate = WebDateUtil.formatForWebpageDisplay(currentBug.getLastUpdateDate());
		out.print(updatedDate); 
	%></p>
	<input type="hidden" name="<% out.print(BugDetailsController.UPDATED_DATE); %>" value="<% out.print(updatedDate); %>"/>
	<p>Priority: <select id="Priority" name="<% out.print(BugDetailsController.PRIORITY); %>">
	<%
		@SuppressWarnings("unchecked")
		List<String> priorityList = (List<String>)request.getAttribute(DropDownUtil.PRIORITY_LIST);
		for(String priority: priorityList) {
			StringBuilder sb = new StringBuilder();
			sb.append("<option value=\"");
			sb.append(priority);
			
			if (priority.equals(currentBug.getPriority().toString()))
				sb.append("\" selected=\"true\">");
			else 
				sb.append("\">");
			
			sb.append(priority);
			sb.append("</option>");
			out.print(sb.toString());
		}
	%>
	</select></p>
	<p>Status: <select id="Status" name="<% out.print(BugDetailsController.STATUS); %>">
	<%
	@SuppressWarnings("unchecked")
		List<String> statusList = (List<String>)request.getAttribute(DropDownUtil.STATUS_LIST);
		for(String status: statusList) {
			StringBuilder sb = new StringBuilder();
			sb.append("<option value=\"");
			sb.append(status);
			
			if (status.equals(currentBug.getStatus().toString()))
				sb.append("\" selected=\"true\">");
			else 
				sb.append("\">");
			
			sb.append(status);
			sb.append("</option>");
			out.print(sb.toString());
		}
	%>	
	</select></p>
	<p>Assigned to: <select id="Assigned" name="<% out.print(BugDetailsController.ASSIGNED_USER); %>">
	<%
	@SuppressWarnings("unchecked")
		List<String> usernameList = (List<String>)request.getAttribute(DropDownUtil.USERNAME_LIST);
		for(String username: usernameList) {
			StringBuilder sb = new StringBuilder();
			sb.append("<option value=\"");
			sb.append(username);

			if (username.equals(currentBug.getAssigneeUsername()))
				sb.append("\" selected=\"true\">");
			else 
				sb.append("\">");
			
			sb.append(username);
			sb.append("</option>");
			out.print(sb.toString());
		}
	%>	
	</select></p>
	<p>Full Description:<br/>
	<textarea name="<% out.print(BugDetailsController.DESCRIPTION); %>" rows="7" cols="50">
		<% out.print(currentBug.getDescription()); %>
	</textarea></p>
	
	<input type="submit" value="Update"/>
	<input type="button" value="Home" onclick="window.location.href='./listofbugs'" /> 
	</form>
</body>
</html>