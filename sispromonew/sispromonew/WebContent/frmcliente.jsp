<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Cliente</title>
</head>
<body>
    <h1>Registrar Cliente</h1>
    <form method="post" action="/sispromonew/ServletRegistrarCliente">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required><br><br>
        
        <label for="cnpj">Cnpj:</label>
        <input type="text" id="cnpj" name="cnpj" required><br><br>
        
        <label for="cep">CEP:</label>
        <input type="text" id="cep" name="cep" required><br><br>
        
        <label for="endereco">Endereço:</label>
        <input type="text" id="endereco" name="endereco" required><br><br>
        
        <label for="numero">Número:</label>
        <input type="text" id="numero" name="numero" required><br><br>
        
        <label for="complemento">Complemento:</label>
        <input type="text" id="complemento" name="complemento"><br><br>
        
        <label for="bairro">Bairro:</label>
        <input type="text" id="bairro" name="bairro" required><br><br>
        
        <label for="cidade">Cidade:</label>
        <input type="text" id="cidade" name="cidade" required><br><br>
        
        <label for="uf">UF:</label>
        <input type="text" id="uf" name="uf" maxlength="2" required><br><br>
        
        <label for="Promotor">Promotor </label>
        <select name="idpromotor">
	        <c:forEach var="promotor" items="${promotores}">
		    	<!--  selecionar cliente para alterar promotor -->
		    		<option value= "${promotor.id}"
		    			<c:if test="${cliente.promotor.id==promotor.id}">
		    		      selected
		    			</c:if>
		    		> ${promotor.nome}</option> 	   
		    	</c:forEach>
	    	</select>
	    	<c:if test="${cliente==null}">
		        <button type="submit">Cadastrar</button>
	    	</c:if>
	    	<c:if test="${cliente!=null}">
		        <button type="submit"> Inserir</button>
	    	</c:if>
    </form>
</body>
</html>