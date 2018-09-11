<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>
	<spring:message code="user.phrase.lesson.title" arguments="${lesson}"
		htmlEscape="false" argumentSeparator=";" var="title" />
	${title}
</h1>
<hr>
<c:forEach items="${content}" var="l">
	<div class="border-left pl-3">
		<div>
			<div class="text-warning" style="font-size: 1.3em">
				<strong>${l.phrase}</strong>
			</div>
			<div class="text-secondary">${l.phraseIPA}</div>
			<div>${l.phraseDesc}</div>
			<div>
				<strong>${l.phraseMeaning }</strong>
			</div>
		</div>
		<div class="ml-3 mt-3 mb-5">
			<div>
				<span class="text-warning" style="font-size: 1.2em">
					<strong class="text-success">${l.sentence} </strong>
					<a href="#">
						<i class="fas fa-volume-up text-secondary"></i>
					</a>
				</span>
			</div>
			<div class="text-secondary">${l.sentenceIPA }</div>
			<div>
				<strong>${l.sentenceMeaning }</strong>
			</div>
		</div>
	</div>
</c:forEach>
<hr>
<button class="btn btn-primary">
	<spring:message code="global.text.button.exercise" />
</button>
<script>
	$(document).ready(function(e) {
		$("title").text("${title}");
	});
</script>