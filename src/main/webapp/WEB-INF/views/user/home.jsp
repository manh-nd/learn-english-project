<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>
	<spring:message code="user.home.text.title" var="title" />
	${title }
</h1>
<hr>
<div class="jumbotron">
	<h1 class="display-4">
		<spring:message code="user.home.text.intro.title" />
	</h1>
	<p class="lead">
		<spring:message code="user.home.text.intro.author" var="author" />
		<spring:message code="user.home.text.intro.nick_name" var="nickName" />
		${author} - ${nickName}
	</p>
	<hr class="my-4">
	<p>
		<spring:message code="user.home.text.intro.description"
			arguments="${author}" argumentSeparator=";" />
	</p>
	<a class="btn btn-primary btn-lg" href="#" role="button">
		<spring:message code="user.home.text.intro.button" />
	</a>
</div>
<script>
	$(document).ready(function(e) {
		$("title").text("${title}");
	});
</script>