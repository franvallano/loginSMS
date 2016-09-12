<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMS Enviado</title>
</head>
<script type="text/javascript">

	function cargaPagina() {
		window.location.href="http://localhost:8080/loginSMS/fullLogin?token=${token}";
	}
</script>


<body onLoad="cargaPagina()">
Se ha enviado un SMS al número ${phone }
<br/>
LINK : http://localhost:8080/loginSMS/validation?token=${token}
</body>
</html>