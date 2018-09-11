<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message code="user.grammar.title" var="title" />

<c:import url="/private/courses/grammar/${lesson}/${lesson}.html"
	charEncoding="utf-8" />
<div class="pt-1 pb-5">
	<hr>
	<a href="/grammar/lesson-${lesson}-quiz" class="btn btn-success">
		<spring:message code="global.text.button.exercise" />
	</a>
</div>
<script>
	$(document).ready(function(e) {
		$("title").text("${title}");
	});
</script>