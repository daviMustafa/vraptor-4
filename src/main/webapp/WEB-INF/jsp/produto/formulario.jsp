<%--
  Created by IntelliJ IDEA.
  User: davi.oliveira
  Date: 12/09/16
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
<head>
    <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../base.css">
    <title>Novo Produto</title>
</head>
<br>

<div class="container">
    <h1>Adicionar Produto</h1>

    <form action="<c:url value='/produto/adiciona' />" method="post">
    	Nome:
	    <input class="form-control" type="text" name="produto.nome" value="${produto.nome}"/>
	    Valor:
	    <input class="form-control" type="text" name="produto.valor" value="${produto.valor}"/>
	    Quantidade:
	    <input class="form-control" type="text" name="produto.quantidade" value="${produto.quantidade}"/>
	
	    <input class="btn btn-primary" type="submit" value="Adicionar">
    </form>
</div>

<c:forEach items="${errors}" var="erro">
    <div class="alert alert-danger"> ${erro.category} - ${erro.message} </div></br>
</c:forEach>

</body>
</html>
