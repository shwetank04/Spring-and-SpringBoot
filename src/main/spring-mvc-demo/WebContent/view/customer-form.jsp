<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title>Customer Registration Form</title>

</head>
<body>

	<br>
	<br>

	<form:form action="processForm" modelAttribute="customer">
	
		First name: <form:input path="firstName" />

		<br>
		<br>
		
		Last name (*): <form:input path="lastName" />
		<br>
		<br>

		<input type="submit" value="Submit" />

	</form:form>

</body>

</html>
