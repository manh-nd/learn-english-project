<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>
	<spring:message code="admin.dashboard.title" var="title" />
	${title}
</h1>
<hr>
<div class="card-deck">
	<div class="card">
		<div class="card-header bg-success text-light">
			<spring:message code="admin.dashboard.card.total_users" />
		</div>
		<div class="card-body text-success">
			<h2 class="card-title">${totalUser}</h2>
		</div>
	</div>
	<div class="card">
		<div class="card-header bg-secondary text-light">
			<spring:message code="admin.dashboard.card.total_sentences" />
		</div>
		<div class="card-body text-secondary">
			<h2 class="card-title">${totalSentence}</h2>
		</div>
	</div>
	<div class="card">
		<div class="card-header bg-primary text-light">
			<spring:message code="admin.dashboard.card.total_phrases" />
		</div>
		<div class="card-body text-primary">
			<h2 class="card-title">${totalPhrase}</h2>
		</div>
	</div>
</div>

<div class="card-deck mt-4">
	<div class="card">
		<div class="card-header bg-info text-light">
			<spring:message
				code="admin.dashboard.card.total_users_registered_today" />
		</div>
		<div class="card-body text-info">
			<h2 class="card-title">${totalUserRegisteredToday}</h2>
		</div>
	</div>
	<div class="card">
		<div class="card-header bg-warning text-light">
			<spring:message
				code="admin.dashboard.card.total_users_in_phrase_course" />
		</div>
		<div class="card-body text-warning">
			<h2 class="card-title">${totalUserInPhraseCourse}</h2>
		</div>
	</div>
	<div class="card">
		<div class="card-header bg-danger text-light">
			<spring:message
				code="admin.dashboard.card.total_users_in_grammar_course" />
		</div>
		<div class="card-body text-danger">
			<h2 class="card-title">${totalUserInGrammarCourse}</h2>
		</div>
	</div>
</div>
<script>
	$(document).ready(function(e) {
		$("title").text("${title}");
	});
</script>