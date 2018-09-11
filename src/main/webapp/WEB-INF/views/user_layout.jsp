<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./fragments/head.jsp" />
<title><spring:message code="global.user.title" /></title>
</head>
<body>
	<jsp:include page="./fragments/navbar_user_fragment.jsp" />
	<div class="container pt-5 pb-5" style="min-height: 600px">
		<jsp:include page="${param.view}" />
	</div>
	<jsp:include page="./fragments/footer.jsp" />
</body>
</html>