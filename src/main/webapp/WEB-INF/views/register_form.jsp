<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>
	<spring:message code="global.form.register.title" />
</h1>
<hr>
<form:form action="/register" method="POST" modelAttribute="user">

	<div class="form-group">
		<label for="firstName">
			<spring:message code="global.form.register.label.firstName" />
		</label>
		<form:input id="firstName" path="firstName" cssClass="form-control" />
		<form:errors cssClass="text-danger" path="firstName" />
	</div>

	<div class="form-group">
		<label for="lastName">
			<spring:message code="global.form.register.label.lastName" />
		</label>
		<form:input id="lastName" path="lastName" cssClass="form-control" />
		<form:errors cssClass="text-danger" path="lastName" />
	</div>

	<div class="form-group">
		<label for="username">
			<spring:message code="global.form.register.label.username" />
		</label>
		<form:input id="username" path="username" cssClass="form-control" />
		<form:errors cssClass="text-danger" path="username" />
	</div>

	<div class="form-group">
		<label for="password">
			<spring:message code="global.form.register.label.password" />
		</label>
		<form:password id="password" path="password" cssClass="form-control" />
		<form:errors cssClass="text-danger" path="password" />
	</div>

	<div class="form-group">
		<label for="email">
			<spring:message code="global.form.register.label.email" />
		</label>
		<form:input id="email" path="emailAddress" cssClass="form-control" />
		<form:errors cssClass="text-danger" path="emailAddress" />
	</div>

	<button class="btn btn-success">
		<spring:message code="global.form.register.button.register" />
	</button>

</form:form>