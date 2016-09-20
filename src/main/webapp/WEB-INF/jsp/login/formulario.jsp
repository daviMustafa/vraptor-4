<%--
  Created by IntelliJ IDEA.
  User: davi.oliveira
  Date: 12/09/16
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../base.css">
    <title>Formulário de Login</title>
</head>
<br>

<body>

<div class="container">
    <h1>Logar</h1>

    <form class="form-signin" action="<c:url value='/login/autentica' />" method="post">
        <h2 class="form-signin-heading">Faça login para acessar o VRaptor-Produtos</h2>
        <input class="form-control" type="text" name="usuario.nome" value="${usuario.nome}"/>
        <input class="form-control" type="password" name="usuario.senha" value="${usuario.senha}"/>

        <input class="btn btn-primary" type="submit" value="Login">
    </form>
</div>

<c:forEach items="${errors}" var="erro">
    <div class="alert alert-danger"> ${erro.category} - ${erro.message} </div>
    </br>
</c:forEach>
</body>
</html>



