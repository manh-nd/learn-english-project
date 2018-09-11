<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@  taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>
	<spring:message code="user.dictionary.text.title" var="title" />
	${title}
</h1>
<hr>
<form action="/dictionary/search" method="get">
	<div class="input-group">
		<input type="text" name="key" class="form-control mr-1" value="${key}"
			placeholder=" <spring:message code="user.dictionary.text.input.search.placeholder" />" />
		<div class="input-group-append">
			<button class="btn btn-success">
				<i class="fas fa-search"></i>
				<spring:message code="user.dictionary.text.button.search" />
			</button>
		</div>
	</div>
</form>

<p class="text-danger mt-2">
	<spring:message code="user.dictionary.text.result"
		arguments="<strong>${totalResult}</strong>;<strong>${key}</strong>;<strong>${totalTime}</strong>"
		htmlEscape="false" argumentSeparator=";" />
</p>
<table id="table-result" class="table table-sm table-hover">
	<c:forEach items="${result}" var="d" varStatus="s">
		<tr>
			<td>
				<div class="text-success">
					<strong>${d.en}</strong>
				</div>
				<div>${d.vi}</div>
			</td>
		</tr>
	</c:forEach>
</table>

<c:if test="${totalResult>40}">
	<div class="text-center">
		<button id="getMore" class="btn btn-success">
			<i class="fas fa-chevron-circle-down"></i>
		</button>
	</div>
</c:if>

<script type="text/javascript">
	$(document).ready(function(e) {
		$("title").text("${title}");
		
		var currentPage = 1;
		$("#getMore").click(function(e) {
			$.get("/dictionary/more-result", {
				key : "${key}",
				page : currentPage
			}, function(data, status) {
				if (data.length < 40) {
					$("#getMore").off("click");
					$("#getMore").remove();
				}
				for ( var x in data) {
					var str1 = '<tr><td><div class="text-success"><strong>';
					var str2 = data[x].en;
					var str3 = "</strong></div><div>";
					var str4 = data[x].vi;
					var str5 = "</div></td></tr>";
					var str = str1.concat(str2, str3, str4, str5);
					$("#table-result tr:last").after(str);
				}
			});
			currentPage++;
		});
	});
</script>
