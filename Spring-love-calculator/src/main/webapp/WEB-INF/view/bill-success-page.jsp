<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bill-success-page</title>
</head>
<body>

	<h1 align="center">BILL</h1>

	<div align="center">
		<p>BILL AGAINST THE CREDIT CARD NUMBER</p>
		<p>${billDTO.creditCard} for an amount of ${billDTO.amount} has been
			generated</p>
	</div>

</body>
</html>