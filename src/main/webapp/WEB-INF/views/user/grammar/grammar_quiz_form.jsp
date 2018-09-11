<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>
	<spring:message code="user.grammar.quiz.title" var="title" />
	${title }
</h1>
<hr>

<form:form action="/grammar/lesson-${lesson}-quiz" method="post"
	modelAttribute="qnaList">
	<c:forEach items="${qnaList.questions}" var="q" varStatus="qs">
		<div>
			<b>
				<spring:message code="user.grammar.quiz.question.text" />
				<span> ${qs.count}: ${q.question}</span>
			</b>
			<form:hidden path="list[${qs.index}].questionId" />
		</div>
		<div class="mt-2 mb-2">
			<c:forEach items="${q.grammarAnswers}" var="a" varStatus="as">
				<div>
					<label>
						<form:radiobutton path="list[${qs.index}].answerId"
							value="${a.id}" />
						<span> ${a.answer}</span>
					</label>
				</div>
			</c:forEach>
		</div>
	</c:forEach>
	<hr>
	<div class="mt-2">
		<button class="btn btn-success">
			<spring:message code="user.grammar.quiz.button.text.submit" />
		</button>
		<button type="reset" class="btn btn-secondary">
			<spring:message code="user.grammar.quiz.button.text.reset" />
		</button>
	</div>
</form:form>
<script>
	$(document).ready(function(e) {
		$("title").text("${title}");
	});
</script>