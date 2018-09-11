<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>
	<spring:message code="global.form.login.title" />
</h1>
<hr>

<form:form action="/login" method="POST" modelAttribute="user">

	<c:if test="${param.error!=null}">
		<p class="text-danger">
			<spring:message code="message.error.login.failed" />
		</p>
	</c:if>

	<div class="form-group">
		<label for="inputUserName">
			<spring:message code="global.form.login.label.username" />
		</label>
		<form:input path="username" id="inputUserName" cssClass="form-control"
			autofocus="autofocus" />
	</div>

	<div class="form-group">
		<label for="inputPassword">
			<spring:message code="global.form.login.label.password" />
		</label>
		<form:password path="password" id="inputPassword"
			cssClass="form-control" />
	</div>

	<div class="form-group">
		<input type="checkbox" id="remember" name="remember-me" />
		<label for="remember" >
			<spring:message code="global.form.login.label.remember" />
		</label>
	</div>

	<div class="form-group">
		<button class="btn btn-primary" type="submit">
			<spring:message code="global.form.login.button.login" />
		</button>
	</div>

</form:form>
