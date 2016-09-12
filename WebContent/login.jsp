<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>LOGIN SMS</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="<c:url value="/resources/js/login.js" />" type="text/javascript"></script>
</head>
<script type="text/javascript">

	function show() {
		obj = document.getElementById("loginPhone");
		obj.style.display = (obj.style.display=='none') ? 'block' : 'none';
/* 		$('#loginPhone').show(); */
	}

</script>
<body>

	<h1>LOGIN</h1>
	<button id="btnAcc" onclick="show()">Mobile Access</button>
	
	<div id="loginPhone" style="display:none">
	<form method="POST" action="/loginSMS/waiting">
		Introduce tu número de teléfono
		<input type="text" value="689172619" name="tlfn"/>
		<br/>
		<input type="submit" value="LOGIN" />
	</form>		
	</div>
	<div id="loginPhone" style="display:none">
		<p>Se ha producido un error</p>
	</div>
</body>
</html>