<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<style>
h1 {
	text-align: center;
	background-color: #8780d6;
}
</style>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/css/bootstrap.min.css"
 integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" 
 crossorigin="anonymous">

<title>Customer Relationship Management</title>
</head>

<body>
	<h1>Customer Relationship Management</h1>
	<br>
	<br>
	<div class="container">
		<h3>Customer Registration Form</h3>
		<hr>
		<p class="h4 mb-4">Enter Customer Detail</p>
		<form action="/CustomerRelationshipManagement/customers/save"
			method="POST">
			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Customer.id}" />

			<div class="form-inline">
				<input type="text" name="first_name" value="${Customer.firstName}"
					class="form-control mb-4 col-4" placeholder="First Name">
			</div>

			<div class="form-inline">
				<input type="text" name="last_name" value="${Customer.lastName}"
					class="form-control mb-4 col-4" placeholder="Last Name">
			</div>

			<div class="form-inline">
				<input type="text" name="email" value="${Customer.email}"
					class="form-control mb-4 col-4" placeholder="Email">
			</div>

			<div class="form-inline">
				<input type="text" name="mobile" value="${Customer.mobile}"
					class="form-control mb-4 col-4" placeholder="Contact No.">
			</div>
			<button type="submit" class="btn btn-info col-2">Save</button>
		</form>

		<hr>
		<a href="/CustomerRelationshipManagement/customers/list">Back to
			Customers List</a>

	</div>
	
</body>

</html>










