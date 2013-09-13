<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@include file="includes/header.jsp" %>
  	<%@ page import="edu.uci.java2.domain.Bug, java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>View Bugs</title>
</head>
<body>
	<h3>
		Welcome
		<%
		out.print((String) request.getAttribute("username"));
	%>
	</h3>
	<form action="./listofbugs" method="post">
		<input type="button"
			onclick="window.location.href='./newbug'"
			value="Submit New Defect" />
		<table>
		<tr><td>Number</td><td>Summary</td><td>Status</td><td>Priority</td><td>Date Entered</td><td></td><td></td></tr>
			<%
				@SuppressWarnings("unchecked")
				List<Bug> bugList = (List<Bug>) request.getAttribute("buglist");			
				
				final String NEW_ROW = "<tr><td>";
				final String NEW_ELEMENT = "</td><td>";
				final String END_ROW = "</td></tr>";
				
				for (Bug bug : bugList){
					StringBuilder sb = new StringBuilder();
					sb.append(NEW_ROW);
					sb.append(bug.getID());
					sb.append(NEW_ELEMENT);
					sb.append(bug.getSummary());
					sb.append(NEW_ELEMENT);
					sb.append(bug.getStatus());
					sb.append(NEW_ELEMENT);
					sb.append(bug.getPriority());
					sb.append(NEW_ELEMENT);
					sb.append(bug.getCreatedDate().toString());
					sb.append(NEW_ELEMENT);
					sb.append("<input type='button' onclick=\"window.location.href='./notimplemented.jsp'\" value='View Details'");
					sb.append(NEW_ELEMENT);
					sb.append("<input type='button' onclick=\"window.location.href='./notimplemented.jsp'\" value='Email'");
					sb.append(END_ROW);
					out.print(sb.toString());
				}
			%>
		</table>
	</form>
</body>
<script type="text/javascript">
<%@include file="includes/errorAlert.jsp" %>
</script>	
</html>