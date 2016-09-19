<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Add User</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript"
	src="<c:url value="/resources/js/custom.js" />"></script>
</head>
<body>

	<%@ include file="logout.jsp"%>

	<div id="container" class="col-md-6 col-sm-8">
		<h3 align="center">Add User</h3>
		<form:form modelAttribute="user">
			<c:if test="${!empty user.firstName}">
				<div class="form-group row">
					<form:label path="id" class="col-xs-2 col-form-label">
						<spring:message text="ID: " />
					</form:label>
					<div class="col-xs-8">
						<form:input class="form-control" path="id" readonly="true"
							disabled="true" value="${id}" />
						<form:hidden path="id" />
					</div>
				</div>
			</c:if>
			<div class="form-group row">
				<form:label path="firstName" class="col-xs-2 col-form-label">
					<spring:message text="First Name: " />
				</form:label>
				<div class="col-xs-8">
					<form:input class="form-control" path="firstName"
						value="${firstName}" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="lastName" class="col-xs-2 col-form-label">
					<spring:message text="Last Name: " />
				</form:label>
				<div class="col-xs-8">
					<form:input class="form-control" path="lastName"
						value="${lastName}" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="email" class="col-xs-2 col-form-label">
					<spring:message text="Email: " />
				</form:label>
				<div class="col-xs-8">
					<form:input class="form-control" path="email" value="${email}" />
				</div>
			</div>
			<c:if test="${!empty user.firstName}">

				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-pencil"></span> Update User
				</button>
				&nbsp;&nbsp; &nbsp;				
				<button type="submit" value="Cancel" name="_cancel"
					class="btn btn-warning">Cancel</button>
			</c:if>
			<c:if test="${empty user.firstName}">

				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-eye-open"></span> Add User
				</button>
			</c:if>
		</form:form>
	</div>
</body>
</html>
