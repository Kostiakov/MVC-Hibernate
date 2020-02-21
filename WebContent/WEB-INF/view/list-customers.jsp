<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>List Customers</title>
<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
		<!-- Add button -->
		<input type="button" value="Add Customer"
			onclick="window.location.href='showFormForAdd'; return false;"
			class="add-button"/>
		<!-- Add search -->	
		<form:form action="searchCustomer">
		Enter name: <input type="text" name="theSearchName"/>
		<input type="submit" value="Search" class="addButton">
		</form:form>
		<!-- add html table -->
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			<!-- loop over and print customers -->
			<c:forEach var="tempCustomer" items="${customers}">
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id}"></c:param>
				</c:url>
				<c:url var="deleteLink" value="/customer/deleteCustomer">
					<c:param name="customerId" value="${tempCustomer.id}"></c:param>
				</c:url>
			<tr>
				<td> ${tempCustomer.firstName} </td>
				<td> ${tempCustomer.lastName} </td>
				<td> ${tempCustomer.email} </td>
				<td><a href="${updateLink}">Update</a> 
				<a href="${deleteLink}"
				onclick="if(!(confirm('Are you sure you want to delete user?'))) return false">Delete</a></td>
			</tr>
			
			</c:forEach>
		</table>
		</div>
	</div>
</body>
</html>