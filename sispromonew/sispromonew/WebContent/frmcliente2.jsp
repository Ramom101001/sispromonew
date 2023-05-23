<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alterar Cliente</title>
</head>
<body>
    <h1> Alterar Cliente</h1>
    <form method="GET" action="/sispromonew/ClienteAlterar">
        <label for="id">ID: ${cliente.id} </label>
        <input type="hidden" id="id" name="id" value="${cliente.id}"><br><br>  
         <br>  
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="${cliente.nome}"><br><br>  
        <button type="submit">Alterar</button>
    </form>
</body>
</html>