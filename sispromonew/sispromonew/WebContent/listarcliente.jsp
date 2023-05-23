<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>sispromonew - Listar Cliente </title>
</head>
<body>
	<table border="1"> 
	<tr>
    <th>ID</th>
    <th>Nome</th>
    <th>Excluir</th>
    <th>Alterar</th>
  </tr>
		<c:forEach var="cliente" items="${clientes}">
			<tr>
			<td> ${cliente.id} </td>
			<td> ${cliente.nome} </td>
			<td> <a href="/sispromonew/ClienteExcluir?id=${cliente.id}"> Excluir </a></td>
			<td> <a href="/sispromonew/ClientePreparaAlteracao?id=${cliente.id}"> Alterar </a></td>		
			</tr>
		</c:forEach>
	</table>
</body>
</html>