<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>
	<spring:message code="user.grammar.quiz.result.title" var="title" />
	<span>${title} ${lesson}</span>
</h1>
<hr>

<div class="text-center mb-2">
	<span class="badge badge-danger">
		<spring:message code="user.grammar.quiz.result.mark.text" />
		: ${qnaList.mark}
	</span>
</div>

<c:forEach items="${qnaList.questions}" var="q" varStatus="qs">
	<div>
		<b>
			<spring:message code="user.grammar.quiz.question.text" />
			<span> ${qs.count}: ${q.question}</span>
		</b>
	</div>
	<div class="mt-2">
		<table class="table table-sm table-hover">
			<thead>
				<tr>
					<th>
						<spring:message
							code="user.grammar.quiz.result.table.column.select" />
					</th>
					<th>
						<spring:message
							code="user.grammar.quiz.result.table.column.meaning" />
					</th>
					<th>
						<spring:message
							code="user.grammar.quiz.result.table.column.description" />
					</th>
				</tr>
			</thead>
			<c:forEach items="${q.grammarAnswers}" var="a" varStatus="as">
				<c:set var="selected"
					value="${qnaList.list[qs.index].answerId==a.id}" />
				<tbody>
					<tr
						${a.rightAnswer?'class="alert-success"':selected?'class="alert-danger"':''}>
						<td>
							<label>
								<input type="radio" name="qna${qs.count}"
									${selected?'checked':''} disabled="disabled" />
								<span> ${a.answer}</span>
							</label>
						</td>
						<td>${empty a.meaning?'Không có dữ liệu cho phần này':a.meaning}</td>
						<td>${a.description}</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
</c:forEach>
<script>
	$(document).ready(function(e) {
		$("title").text("${title}");
	});
</script>
