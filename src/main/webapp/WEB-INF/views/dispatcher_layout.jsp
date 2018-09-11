<%
	String value = request.getParameter("view");
	if (value.startsWith("admin/")) {
		pageContext.forward("admin_layout.jsp");
	} else {
		pageContext.forward("user_layout.jsp");
	}
%>