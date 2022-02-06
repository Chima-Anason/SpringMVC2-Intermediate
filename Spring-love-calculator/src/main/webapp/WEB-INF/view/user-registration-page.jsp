<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registration-page</title>
</head>
<body>
	<h1 align="center">Please register here</h1>

	<form:form action="registration-success" method="GET" modelAttribute="userReg">

      <div align="center">
		<label>User :</label>
		<form:input path="name" />

		<br />

		<label>User Name :</label>
		<form:input path="userName" />

		<br />

		<label>Password :</label>
		<form:password path="password" />

		<br />

		<label>Country :</label>
		<form:select path="countryName">
			<form:option value="NG" label="Nigeria"></form:option>
			<form:option value="Ind" label="India"></form:option>
			<form:option value="usa" label="United States"></form:option>
			<form:option value="Cn" label="China"></form:option>
			<form:option value="Pl" label="Poland"></form:option>
		</form:select>

		<br />
		
		<label>Hobbies :</label>
		Cricket : <form:checkbox path="hobbies" value="cricket"/>
		Football : <form:checkbox path="hobbies" value="football"/>
		Travel : <form:checkbox path="hobbies" value="travel"/>
		Programming : <form:checkbox path="hobbies" value="programming"/>
		
		<br />
		
		<label>Gender :</label>
		Male<form:radiobutton path="gender" value="male"/>
		Female<form:radiobutton path="gender" value="female"/>
		
		<br />
		
		</div>
		
		<div align="center">
			<h3>Communication</h3>
			
			<label>Email :</label>
			<form:input path="communicationDTO.email"/>
		</div>
		
		<div align="center">
			<input type="submit" value="register">
		</div>
		
      

	</form:form>

</body>
</html>