<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/sispromonew/ServletLogar" method="post">
	Login: <input type="text" name="login"> <br>
	Senha: <input type="password" name="senha"> <br>
	<input type="submit"> ${msg}
	</form>
<a href="/sispromonew/frmpromotor.jsp"> Registrar-se</a>
</body>
</html>