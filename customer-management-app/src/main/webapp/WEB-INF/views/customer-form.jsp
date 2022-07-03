<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value="/resources/css/styles.css" />"></link>
<title>Save Customer</title>
</head>
<body>
	<div class="main">
		<header>
			<h1>Customer Relationship Management</h1>
		</header>
		<div>
			<h2>Save customer</h2>
			<form action="save" method="post">
				<input type="hidden" name="id" value="${customer.id}" /> <label
					for="firstName">First Name:</label> <input type="text"
					id="firstName" name="firstName" value="${customer.firstName}" /><br />
				<label for="lastName">Last Name:</label> <input type="text"
					id="lastName" name="lastName" value="${customer.lastName}" /><br />
				<label for="email">Email:</label> <input type="email" id="email"
					name="email" value="${customer.email}" /><br /> <label
					for="btn-save"></label> <input type="submit" id="btn-save"
					value="Save" class="btn-save" />
			</form>
			<a href="${pageContext.request.contextPath}/customer/list">Back
				to List</a>
		</div>
	</div>
</body>
</html>