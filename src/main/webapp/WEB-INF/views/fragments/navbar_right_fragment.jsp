<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
	<ul class="navbar-nav ml-auto">
		<li class="nav-item nav-link">

			<a href="#" data-lang="en" data-toggle="tooltip"
				data-placement="bottom" title="English">
				<img src="/public/images/flag_en.png" />
			</a>
			<a href="#" data-lang="vi" data-toggle="tooltip"
				data-placement="bottom" title="Tiếng Việt" class="mr-2">
				<img src="/public/images/flag_vi.png" />
			</a>

			<sec:authorize access="authenticated" var="authenticated" />
			<c:choose>
				<c:when test="${authenticated}">
					<div class="btn-group">
						<button type="button" class="btn btn-secondary dropdown-toggle"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<sec:authentication property="name" var="username" />
							<spring:message code="global.message.welcome"
								arguments="${username}" htmlEscape="false" argumentSeparator=";" />
						</button>
						<div class="dropdown-menu dropdown-menu-right">
							<a href="/profile" class="dropdown-item">
								<spring:message code="global.link.text.profile" />
							</a>
							<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
								<a href="/admin" class="dropdown-item">
									<spring:message code="global.link.text.go_dashboard" />
								</a>
							</sec:authorize>
							<div class="dropdown-divider"></div>
							<a href="/logout" class="dropdown-item">
								<spring:message code="global.link.text.logout" />
							</a>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<a class="btn btn-success" href="/register">
						<spring:message code="global.link.text.register" />
					</a>
					<a class="btn btn-primary" href="/login">
						<spring:message code="global.link.text.login" />
					</a>
				</c:otherwise>
			</c:choose>
		</li>
	</ul>
</div>