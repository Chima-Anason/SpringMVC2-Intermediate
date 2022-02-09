<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bill-Form</title>

</head>
<body>

	<h1 align="center">Bill</h1>

	<form:form action="bill-success" modelAttribute="billDTO">
		<div align="center">
			<label>Card Number :</label>
			<form:input path="creditCard" />

			<br /> 
			
			<label>Amount :</label>
			<form:input path="amount" />

		</div>
		<br />

		<div align="center">
			<input type="submit" value="PAY BILL">
		</div>

	</form:form>


</body>
</html>