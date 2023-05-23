<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sispromonew - Listar Promotor </title>
</head>
<body>
<form action ="/sispromonew/PromotorListar" method="get">
	Descrição do Promotor <input type="text" name="nome">
	<input type="submit"> <br>
</form>

	<table border="1"> 
	<tr>
    <th>ID</th>
    <th>Nome</th>
    <th>Telefone</th>
    <th>Excluir</th>
    <th>Alterar</th>
  </tr>
		<c:forEach var="promotor" items="${promotores}">
			<tr>
			<td> ${promotor.id} </td>
			<td> ${promotor.nome} </td>
			<td> ${promotor.telefone} </td>
			<td> <a href="/sispromonew/PromotorExcluir?id=${promotor.id}"> Excluir </a></td>
			<td> <a href="/sispromonew/PromotorPreparaAlteracao?id=${promotor.id}"> Alterar </a></td>		
			</tr>
		</c:forEach>
	</table>
</body>
</html>