<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<nav class="navbar sticky-top navbar-expand-md navbar-dark bg-dark">
	<a class="navbar-brand" href="/">
		<spring:message code="user.navbar.brand" />
	</a>
	<div
		class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<a class="nav-link ${active_home}" href="/">
					<spring:message code="user.navbar.link.home" />
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link ${active_phrase}" href="/phrase">
					<spring:message code="user.navbar.link.phrase" />
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link ${active_grammar}" href="/grammar">
					<spring:message code="user.navbar.link.grammar" />
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link ${active_dictionary}" href="/dictionary">
					<spring:message code="user.navbar.link.dictionary" />
				</a>
			</li>
		</ul>
	</div>

	<jsp:include page="navbar_right_fragment.jsp" />

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target=".dual-collapse2">
		<span class="navbar-toggler-icon"></span>
	</button>
</nav>
