<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>homePage</title>
</head>
<body>

	<h1 align="center">LOVE CALCULATOR</h1>
	<hr>
	<form action="process-homepage" method="get">
	<div align="center">
		<p>
			<label for="yn">Your Name :</label> 
			<input type="text" id="yn" name="userName" />
		</p>

		<p>
			<label for="cn">Crush Name :</label> 
			<input type="text" id="cn" name="crushName" />
		</p>

		<input type="submit" value="calculate" />
	</div>
	</form>

</body>
</html>