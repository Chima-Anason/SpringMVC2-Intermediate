<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result page</title>
</head>
<body>

	<h1 align="center">Love Calculator</h1>
	<hr>
	
	<h2>The Love Calculator Predicts :</h2>
	<br>

	${userInfo.userName} and ${userInfo.crushName} are 
	<br>
	${userInfo.result}
	
	<br>
	
	<!-- <a href = "/Spring-love-calculator/sendEmail">Send Result to Your Email</a> -->
	
	<a href = "<c:url value = "/sendEmail"/>">Send Result to Your Email</a>
	
</body>
</html>