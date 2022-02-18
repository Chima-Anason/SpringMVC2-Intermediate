<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>send-email-page</title>
</head>
<body>

<h1>Hi ${userName}</h1>
<h2>Send result to your Email</h2>

<form:form action="process-email" method="GET" modelAttribute="emailDTO">

<label>Enter your Email id</label>
<form:input path="userEmail"/>
<input type="submit" value="send">


</form:form>

</body>
</html>