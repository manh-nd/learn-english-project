<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>
	<spring:message code="admin.phrase.list.phrase_lesson" var="title"/>
	${title}
</h1>
<hr>
<script>
	$(document).ready(function(e) {
		$("title").text("${title}");
	});
</script>