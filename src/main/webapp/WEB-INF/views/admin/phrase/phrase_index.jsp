<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>
	<spring:message code="admin.phrase.list.phrasedetail.title" var="title" />
	${title }
</h1>
<hr>
<table id="phraseTable"
	class="table table-striped table-bordered table-sm">
	<thead>
		<tr>
			<th>
				<spring:message
					code="admin.phrase.list.phrasedetail.table.column.id" />
			</th>
			<th>
				<spring:message
					code="admin.phrase.list.phrasedetail.table.column.phrase" />
			</th>
			<th>
				<spring:message
					code="admin.phrase.list.phrasedetail.table.column.description" />
			</th>
			<th>
				<spring:message
					code="admin.phrase.list.phrasedetail.table.column.meaning" />
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${phrases}" var="p" varStatus="s">
			<tr>
				<td>${p.id}</td>
				<td>${p.phrase}</td>
				<td>${p.description}</td>
				<td>${p.meaning}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script src="/public/js/datatable.js"></script>
<script>
	$(document).ready(function() {
		$("title").text("${title}");
		$('#phraseTable').DataTable();
	});
</script>