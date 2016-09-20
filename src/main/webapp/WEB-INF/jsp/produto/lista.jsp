<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="../bootstrap/css/bootstrap.css">
    <title>Listagem de Produtos</title>
</head>
<body>
<h1>Listagem de Produtos</h1>

<a href="<c:url value='/produto/formulario'/>"> Adicionar mais produtos! </a>
<br/>
<a href="<c:url value='/produto/listaEmXml'/>"> Lista XML! </a>
<br/>
<a href="<c:url value='/produto/listaEmJson'/>"> Lista JSON! </a>

<form action="<c:url  value='/produto/remover'/>">
    <table class="table table-stripped table-hover table-bordered">
        <thead>
        <tr>
            <td>Nome</td>
            <td>Valor</td>
            <td>Quantidade</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${produtoList}" var="produto">
            <tr>
                <td>${produto.nome}</td>
                <td>${produto.valor}</td>
                <td>${produto.quantidade}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:if test="${not empty mensagem}">
        <div class="alert alert-success">${mensagem}</div>
    </c:if>
</form>
</body>
</html>