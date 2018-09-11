<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>
	<spring:message code="admin.user.list.title" var="title" />
	${title}
</h1>
<hr>
<table id="userTable"
	class="table table-striped table-bordered table-sm">
	<thead>
		<tr>
			<th>
				<spring:message code="admin.user.list.table.column.id" />
			</th>
			<th>
				<spring:message code="admin.user.list.table.column.username" />
			</th>
			<th>
				<spring:message code="admin.user.list.table.column.email" />
			</th>
			<th>
				<spring:message code="admin.user.list.table.column.firstName" />
			</th>
			<th>
				<spring:message code="admin.user.list.table.column.joined_date" />
			</th>
			<th>
				<spring:message code="admin.user.list.table.column.enabled" />
			</th>
			<th>
				<spring:message code="admin.user.list.table.column.action" />
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="u" varStatus="s">
			<tr>
				<td>${u.id}</td>
				<td>${u.username}</td>
				<td>${u.email}</td>
				<td>${u.firstName}</td>
				<td>${u.joinedDate}</td>
				<td>${u.enabled}</td>
				<td class="text-center">
					<div class="btn-group">
						<a href="/admin/user/edit?uid=${u.id}" class="btn btn-warning">
							<i class="fas fa-pencil-alt"></i>
						</a>
						<a href="/admin/user/delete?uid=${u.id}" class="btn btn-danger">
							<i class="fas fa-trash-alt"></i>
						</a>
					</div>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script src="/public/js/datatable.js"></script>
<script>
	$(document).ready(function() {
		$("title").text("${title}");
		$('#userTable').DataTable();
	});
</script>
