<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Edit User</h1>
<hr>

<form:form action="/admin/user/update" modelAttribute="user">
	<div class="form-group row">
		<label for="uid" class="col-sm-2 col-form-label">
			<strong>User Id</strong>
		</label>
		<div class="col-sm-10">
			<input type="text" name="uid" readonly class="form-control-plaintext"
				id="uid" value="${user.id}">
		</div>
	</div>

	<div class="form-group row">
		<label for="username" class="col-sm-2 col-form-label">
			<strong>Username</strong>
		</label>
		<div class="col-sm-10">
			<input type="text" readonly class="form-control" id="username"
				value="${user.username}">
		</div>
	</div>

	<div class="form-group row">
		<label for="joinedDate" class="col-sm-2 col-form-label">
			<strong>Joined date</strong>
		</label>
		<div class="col-sm-10">
			<input type="text" readonly class="form-control" id="joinedDate"
				value="${user.createdDate}">
		</div>
	</div>

	<div class="form-group row">
		<label for="enabled" class="col-sm-2 col-form-label">
			<strong>Enable</strong>
		</label>
		<div class="col-sm-10">
			<form:select id="enabled" path="enabled" cssClass="form-control">
				<form:option value="true">Enable</form:option>
				<form:option value="false">Disable</form:option>
			</form:select>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-2"></div>
		<div class="col-sm-10">
			<button class="btn btn-warning">
				<i class="fas fa-pencil-alt"></i>
				Edit
			</button>
		</div>
	</div>
</form:form>
<script>
	$(document).ready(function(e) {
		$("title").text("${title}");
	});
</script>