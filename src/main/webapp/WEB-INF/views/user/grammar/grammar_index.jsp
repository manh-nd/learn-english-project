<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>
	<spring:message code="user.grammar.title" var="title" />
	${title }
</h1>
<hr>
<div>
	<div>
		<spring:message code="user.grammar.text.description.row1" />
	</div>
	<div>
		<spring:message code="user.grammar.text.description.row2" />
	</div>
</div>
<hr>
<div class="pt-3">
	<c:choose>
		<c:when test="${joined}">
			<c:forEach var="lesson" begin="1" end="${nextLesson}" step="1">
				<a href="/grammar/lesson-${lesson}" class="btn btn-success">${lesson}</a>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<form action="/grammar/join-course" method="POST">
				<button class="btn btn-primary">
					<spring:message code="user.grammar.button.join.text" />
				</button>
			</form>
		</c:otherwise>
	</c:choose>
</div>
<script>
	$(document).ready(function(e) {
		$("title").text("${title}");
	});
</script>