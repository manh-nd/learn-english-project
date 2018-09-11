<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>
	<spring:message code="user.dictionary.text.title" var="title" />
	${title}
</h1>
<hr>
<form action="/dictionary/search" method="get">
	<div class="input-group">
		<input type="text" name="key" class="form-control mr-1"
			placeholder=" <spring:message code="user.dictionary.text.input.search.placeholder" />" />
		<div class="input-group-append">
			<button class="btn btn-success">
				<i class="fas fa-search"></i>
				<spring:message code="user.dictionary.text.button.search" />
			</button>
		</div>
	</div>
</form>
<c:if test="${keyEmpty}">
	<p class="text-danger pt-2">
		<spring:message code="message.error.dictionary.search.key.empty" />
	</p>
</c:if>
<script>
	$(document).ready(function(e) {
		$("title").text("${title}");
	});
</script>