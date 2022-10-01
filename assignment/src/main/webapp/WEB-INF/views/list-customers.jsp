<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

	<div class="container">
		<h1>Customer Relationship Management</h1>
		<br>
		<h3>Customer Details</h3>
		<hr>

		<!-- Add a search form -->

		<form action="/CustomerRelationshipManagement/customers/search"
			class="form-inline">

			<!-- Add a button -->
			<a href="/CustomerRelationshipManagement/customers/showFormForAdd"
				class="btn btn-primary btn-sm mb-3"> Add Customer </a> <input
				type="search" name="first_name" placeholder="First Name"
				class="form-control-sm ml-5 mr-2 mb-3" /> <input type="search"
				name="last_name" placeholder="Last Name"
				class="form-control-sm mr-2 mr-2 mb-3" /> <input type="search"
				name="email" placeholder="Email" class="form-control-sm mr-2 mb-3" />

			<input type="search" name="mobile" placeholder="Contact No."
				class="form-control-sm mr-2 mb-3" />

			<button type="submit" class="btn btn-success btn-sm mb-3">Search</button>


		</form>
		

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Contact No.</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Customers}" var="tempCustomer">
					<tr>
						<td><c:out value="${tempCustomer.firstName}" /></td>
						<td><c:out value="${tempCustomer.lastName}" /></td>
						<td><c:out value="${tempCustomer.email}" /></td>
						<td><c:out value="${tempCustomer.mobile}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/CustomerRelationshipManagement/customers/showFormForUpdate?customerId=${tempCustomer.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a
							href="/CustomerRelationshipManagement/customers/delete?customerId=${tempCustomer.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>
</body>
</html>



