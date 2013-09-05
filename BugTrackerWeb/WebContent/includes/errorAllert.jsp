<% String errormessage = (String)request.getAttribute("errorMessage");%>
<% if(errormessage!=null){
	out.println("errorMessage(\""+ errormessage +"\");");
}
%>

function errorMessage(message){
	if(message!=null){
		alert(message);
		}
}
