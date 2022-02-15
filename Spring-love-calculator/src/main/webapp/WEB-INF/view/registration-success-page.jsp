<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registration-success-page</title>
</head>
<body>

	<h1>Your registration is successful!</h1>
	<h2>The details entered by you are :</h2>

	User: ${userReg.name}<br />
    User Name: ${userReg.userName}<br /> 
    Password: ${userReg.password}<br /> 
    Country: ${userReg.countryName}<br /> 
    Hobbies:
	<c:forEach var="temp" items="${userReg.hobbies}">
          ${temp}
    </c:forEach>

	<br /> 
	Gender: ${userReg.gender}
	
	<br /> 
	Age: ${userReg.age}
	
	<br /> 
	Email: ${userReg.communicationDTO.email}
	
	
	<br /> 
	Phone: ${userReg.communicationDTO.phone}

</body>
</html>