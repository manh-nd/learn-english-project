<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>
	<spring:message code="user.profile.text.title" var="title" />
	${title}
</h1>
<hr>

<div id="profile ">
	<table class="table table-hover table-sm table-bordered table-striped">
		<tr class="bg-secondary text-light">
			<td colspan="2">
				<h3><spring:message code="user.profile.text.userInfo" /></h3>
			</td>
		</tr>
		<tr>
			<td>
				<strong>
					<spring:message code="user.profile.text.username" />
				</strong>
			</td>
			<td>${user.username}</td>
		</tr>

		<tr>
			<td>
				<strong>
					<spring:message code="user.profile.text.email" />
				</strong>
			</td>
			<td>${user.emailAddress}</td>
		</tr>

		<tr>
			<td>
				<strong>
					<spring:message code="user.profile.text.firstName" />
				</strong>
			</td>
			<td>${user.firstName}</td>
		</tr>

		<tr>
			<td>
				<strong>
					<spring:message code="user.profile.text.lastName" />
				</strong>
			</td>
			<td>${user.lastName}</td>
		</tr>

		<tr>
			<td>
				<strong>
					<spring:message code="user.profile.text.joinedDate" />
				</strong>
			</td>
			<td>${user.createdDate}</td>
		</tr>

		<tr>
			<td>
				<strong>
					<spring:message code="user.profile.text.lastModified" />
				</strong>
			</td>
			<td>${user.lastUpdatedDate}</td>
		</tr>
	</table>

</div>

<script>
	$(document).ready(function(e) {
		$("title").text("${title}");
	});
</script>