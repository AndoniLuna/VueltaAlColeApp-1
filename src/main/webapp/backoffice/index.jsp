<%
	//Gestion de mensajes
	if(null != request.getAttribute("mensaje")){
		out.print("<hr><p style=\"color:red;font-size:25px;\">");
		out.print(request.getAttribute("mensaje"));
		out.print("</p><hr>");
	}
%>

BACKOFFICE