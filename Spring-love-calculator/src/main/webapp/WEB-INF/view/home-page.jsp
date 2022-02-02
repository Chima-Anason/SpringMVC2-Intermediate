<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>homePage</title>
</head>
<body>
<!-- Two-way-Data-Binding: using Spring MVC form Tags and changing Name = Path -->
	<h1 align="center">LOVE CALCULATOR</h1>
	<hr>
	<form:form action="process-homepage" method="get" modelAttribute="userInfo">
	<div align="center">
		<p>
			<label for="yn">Your Name :</label> 
			<form:input id="yn" path="userName" />
		</p>

		<p>
			<label for="cn">Crush Name :</label> 
			<form:input id="cn" path="crushName" />
		</p>

		<input type="submit" value="calculate" />
	</div>
	</form:form>

</body>
</html>