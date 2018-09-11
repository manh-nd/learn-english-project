<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<nav class="navbar sticky-top navbar-expand-md navbar-dark bg-dark">
	<a class="navbar-brand" href="/admin">
		<spring:message code="admin.navbar.brand" />
	</a>
	<div
		class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<a id="home" class="nav-link ${active_admin_dashboard}"
					href="/admin">
					<spring:message code="admin.navbar.dashboard" />
				</a>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle ${active_admin_user}" href="#"
					id="userDropdown" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">
					<spring:message code="admin.navbar.link.user" />
				</a>
				<div class="dropdown-menu" aria-labelledby="userDropdown">
					<a class="dropdown-item" href="/admin/user/list">
						<spring:message code="admin.navbar.link.user.list" />
					</a>
					<a class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div>
			</li>

			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle ${active_admin_phrase}" href="#"
					id="phraseDropdown" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">
					<spring:message code="admin.navbar.link.phrase" />
				</a>
				<div class="dropdown-menu" aria-labelledby="phraseDropdown">
					<a class="dropdown-item" href="/admin/phrase/list/phrase-detail">
						<spring:message code="admin.navbar.link.phrase.list.phrase_detail" />
					</a>
					<a class="dropdown-item" href="/admin/phrase/list/phrase-example">
						<spring:message
							code="admin.navbar.link.phrase.list.phrase_example" />
					</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="/admin/phrase/list/phrase-lesson">
						<spring:message code="admin.navbar.link.phrase.list.phrase_lesson" />
					</a>
				</div>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle ${active_admin_sentence}"
					href="#" id="phraseDropdown" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">
					<spring:message code="admin.navbar.link.sentence" />
				</a>
				<div class="dropdown-menu" aria-labelledby="phraseDropdown">
					<a class="dropdown-item" href="/admin/sentence/list">
						<spring:message code="admin.navbar.link.sentence.list" />
					</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div>
			</li>
			<li class="nav-item">
				<a id="grammar" class="nav-link ${active_admin_grammar}"
					href="/admin/grammar">
					<spring:message code="admin.navbar.link.grammar" />
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