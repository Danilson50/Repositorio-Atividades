<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Livro</title>
</head>
<body>
<a href="livraria?action=inclui">+ Novo</a>
<h4>Livros</h4>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Título</th>
        <th>Autor</th>
        <th>Resumo</th>
        <th>Ano Lançamento</th>
        <th colspan="2">Opções</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${livros}" var="livro">
        <tr>
            <td>${livro.id}</td>
            <td>${livro.titulo}</td>
            <td>${livro.autor}</td>
            <td>${livro.resumo}</td>
            <td>${livro.anoLancamento}</td>
            <td>
                <a href="livraria?action=edita&livroId=${livro.id}">Editar</a>
            </td>
            <td>
                <a href="livraria?action=remove&livroId=${livro.id}">Remover</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>