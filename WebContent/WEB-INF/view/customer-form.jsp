<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Add Customer Page</title>
<link type="text/css" 
	rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/style.css"/>
	<link type="text/css" 
	rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>
<div id="container">
<form:form action="addCustomer" modelAttribute="customer" method="POST">
<!-- Need to associate data with a given customer -->
<form:hidden path="id"/>
<br>
<table>
<tbody>
<tr>
<td><label>First Name:</label></td>
<td><form:input path="firstName"/></td>
</tr>
<tr>
<td><label>Last Name:</label></td>
<td><form:input path="lastName"/></td>
</tr>
<tr>
<td><label>Email:</label></td>
<td><form:input path="email"/></td>
</tr>
</tbody>
</table>
<br>
<input type="submit" value="Submit"/>
</form:form>
<div style="clear; both;"></div>
<p>
<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
</p>
</div>
</body>
</html>