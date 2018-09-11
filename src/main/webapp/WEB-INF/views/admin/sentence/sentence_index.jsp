<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>
	<spring:message code="admin.sentence.list.title" var="title" />
	${title}
</h1>
<hr>
<table id="sentenceTable"
	class="table table-striped table-bordered table-sm">
	<thead>
		<tr>
			<th>
				<spring:message code="admin.sentence.list.table.column.id" />
			</th>
			<th>
				<spring:message code="admin.sentence.list.table.column.sentence" />
			</th>
			<th>
				<spring:message code="admin.sentence.list.table.column.meaning" />
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${sentences}" var="s">
			<tr>
				<td>${s.id}</td>
				<td>${s.sentence}</td>
				<td>${s.meaning}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script src="/public/js/datatable.js"></script>
<script>
	$(document).ready(function() {
		$("title").text("${title}");
		$('#sentenceTable').DataTable();
	});
</script>
