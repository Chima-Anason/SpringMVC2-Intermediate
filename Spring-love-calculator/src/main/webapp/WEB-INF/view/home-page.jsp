<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>homePage</title>


<style type="text/css">

.error {
     color: red;
     position: fixed;
     text-align: left;
     margin-left: 30px;
}


</style>

<script type="text/javascript">
	function validateTextbox() {
		console.log("i am in")
		var userName = document.getElementById("yn").value
		var crushName = document.getElementById("cn").value

		if (userName.length < 3 || crushName.length < 3) {

			alert("Name should have at least 3 characters");
			return false;
		} else {
			return true;
		}
	}
</script>

</head>
<body>


	<h1 align="center">LOVE CALCULATOR</h1>
	<hr>
	<form:form action="process-homepage" method="get" modelAttribute="userInfo" onsubmit="return validateTextbox()">
		<div align="center">
			<p>
				<label for="yn">Your Name :</label>
				<form:input id="yn" path="userName" />
				<form:errors path="userName" cssClass="error"/>
			</p>

			<p>
				<label for="cn">Crush Name :</label>
				<form:input id="cn" path="crushName" />
				<form:errors path="crushName" cssClass="error"/>
			</p>
			
			<p>
			    <form:checkbox id="check" path="termAndCondition"/>
				<label for="check">I agree that this is for fun</label>
				<form:errors path="termAndCondition" cssClass="error"/>
			</p>

			<input type="submit" value="calculate" />
		</div>
	</form:form>
</body>
</html>