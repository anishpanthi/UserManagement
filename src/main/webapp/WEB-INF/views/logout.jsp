<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</div>
<div>
	<ul class="nav navbar-nav navbar-right"
		style="margin-top: 1%; margin-right: 2%;">
		<li><c:if
				test="${pageContext.request.userPrincipal.name != null}">
				<p class=" text-info">
					Welcome : ${pageContext.request.userPrincipal.name} | <a
						style="color: inherit; text-decoration: none;"
						href="javascript:formSubmit()"><span
						class="glyphicon glyphicon-off"></span> Logout</a>
				</p>
			</c:if></li>
	</ul>
</div>