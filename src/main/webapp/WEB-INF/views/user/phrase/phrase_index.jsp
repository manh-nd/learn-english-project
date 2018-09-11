<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>
	<spring:message code="user.phrase.title" var="title"/>
	${title }
</h1>
<hr>
<div>
	<p>
		<spring:message code="user.phrase.intro.content.row1" />
	</p>
	<p>
		<spring:message code="user.phrase.intro.content.row2" />
	</p>
</div>
<hr>
<div class="pt-3">
	<c:choose>
		<c:when test="${joined}">
			<c:forEach var="lesson" begin="1" end="${totalLesson}" step="1">
				<a href="/phrase/lesson-${lesson}" class="btn btn-success">${lesson}</a>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<form action="/phrase/join-course" method="POST">
				<button class="btn btn-primary">
					<spring:message code="user.phrase.text.button.join_now" />
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