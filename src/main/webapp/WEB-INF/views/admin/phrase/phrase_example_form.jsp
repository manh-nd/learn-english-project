<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>
	<spring:message code="admin.phrase.list.phrase_example.title" var="title" />
	${title }
</h1>
<hr>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary mb-3" data-toggle="modal"
	data-target="#add-phrase-example-modal">
	<spring:message
		code="admin.phrase.list.phrase_example.text.button.add_new_phrase_example" />
</button>

<table id="phrase-example-table"
	class="table table-striped table-bordered table-sm">
	<thead>
		<tr>
			<th>
				<spring:message
					code="admin.phrase.list.phrase_example.table.column.id" />
			</th>
			<th>
				<spring:message
					code="admin.phrase.list.phrase_example.table.column.phrase" />
			</th>
			<th>
				<spring:message
					code="admin.phrase.list.phrase_example.table.column.phrase_meaning" />
			</th>
			<th>
				<spring:message
					code="admin.phrase.list.phrase_example.table.column.sentence" />
			</th>
			<th>
				<spring:message
					code="admin.phrase.list.phrase_example.table.column.sentence_meaning" />
			</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${phraseExamples}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.phrase}</td>
				<td>${p.phraseMeaning}</td>
				<td>${p.sentence}</td>
				<td>${p.sentenceMeaning}</td>
				<td class="text-center">
					<div class="btn-group">
						<button class="btn btn-danger" data-toggle="modal"
							data-target="#phrase-lesson-modal" data-phrase-detail-id="${p.phraseId}">
							<i class="fas fa-plus"></i>
						</button>
						<button class="btn btn-warning" data-toggle="modal"
							data-target="#update-phrase-example-modal" data-id="${p.id}"
							data-phrase-id="${p.phraseId}" data-sentence-id="${p.sentenceId}">
							<i class="fas fa-edit"></i>
						</button>
					</div>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="./fragments/add_phrase_example_modal.jsp" />
<jsp:include page="./fragments/update_phrase_example_modal.jsp" />
<jsp:include page="./fragments/add_phrase_lesson_modal.jsp" />

<script src="/public/js/datatable.js"></script>
<script>
	$(document).ready(function() {
		$("title").text("${title}");
		$('#phrase-example-table').DataTable();

		$('#add-phrase-example-review-btn').click(function(e) {
			e.preventDefault();
			var phraseId = $("#add-pId").val();
			var sentenceId = $("#add-sId").val();
			$.post("/admin/phrase/review/phrase-example", {
				pId : phraseId,
				sId : sentenceId
			}, function(r) {
				$("#add-phrase strong").text(r.phrase);
				$("#add-phrase-meaning").text(r.phraseMeaning);
				$("#add-sentence").css("margin-top", "10px");
				$("#add-sentence strong").text(r.sentence);
				$("#add-sentence-meaning").text(r.sentenceMeaning);
			});
			return false;
		});

		$('#update-phrase-example-review-btn').click(function(e) {
			e.preventDefault();
			var phraseId = $("#update-pId").val();
			var sentenceId = $("#update-sId").val();
			$.post("/admin/phrase/review/phrase-example", {
				pId : phraseId,
				sId : sentenceId
			}, function(r) {
				$("#update-phrase strong").text(r.phrase);
				$("#update-phrase-meaning").text(r.phraseMeaning);
				$("#update-sentence").css("margin-top", "10px");
				$("#update-sentence strong").text(r.sentence);
				$("#update-sentence-meaning").text(r.sentenceMeaning);
			});
			return false;
		});

		$('#update-phrase-example-modal').on('show.bs.modal', function(e) {
			var button = $(e.relatedTarget);
			var pxId = button.data('id');
			var pId = button.data('phrase-id');
			var sId = button.data('sentence-id');
			var modal = $(this);
			modal.find('#update-id').val(pxId);
			modal.find('#update-pId').val(pId);
			modal.find('#update-sId').val(sId);
		});
		
		$('#phrase-lesson-modal').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget);
			var pdId = button.data('phrase-detail-id');
			var modal = $(this);
			modal.find('#phrase-detail-id').val(pdId);
		});

	});
</script>
