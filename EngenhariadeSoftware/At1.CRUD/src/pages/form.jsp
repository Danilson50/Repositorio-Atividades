<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Livro</title>
</head>
<body>
<h3>Livro</h3>
<form action="livraria" method="post">
    <input name="id" type="hidden" value="${livro.id}" />

    <table border="1">
        <tr>
            <td>Título</td>
            <td><input name="titulo" type="text" value="${livro.titulo}"/></td>
        </tr>
        <tr>
            <td>Autor</td>
            <td><input name="autor" type="text" value="${livro.autor}"/></td>
        </tr>
        <tr>
            <td>Resumo</td>
            <td><input name="resumo" type="text" value="${livro.resumo}"/></td>
        </tr>
        <tr>
            <td>Ano Lançamento</td>
            <td><input name="anoLancamento" type="text" value="${livro.anoLancamento}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="salvar" value="Salvar" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>