<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> Registrar Promotor</title>
</head>
<body>
    <h1> Registrar Promotor</h1>
    	<!--  Promotor novo -->
     	<c:if test="${promotor==null}">
    	<form method="GET" action="/sispromonew/ServletRegistrarPromotor">
    </c:if>
    <!--  Promotor alterar -->
     <c:if test="${promotor!=null}">
    	<form method="GET" action="/sispromonew/PromotorAlterar">
    	<input type="hidden" id="id" name="id" value="${promotor.id}"><br><br>
    	
    </c:if>
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="${promotor.nome}"><br><br>
         
       	<label for="cpf">Cpf:</label>
        <input type="text" id="cpf" name="cpf" value="${promotor.cpf}"><br><br>
        
        <label for="telefone">Telefone:</label>
        <input type="text" id="telefone" name="telefone" value="${promotor.telefone}"><br><br>
    	
    	<label for="login">Login:</label>
        <input type="text" id="login" name="login" required><br><br>
        
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required><br><br>
    	
    
	    <button type="submit"> Inserir</button>
	    
    </form>
</body>
</html>