<%-- 
    Document   : listadoUsuarios
    Created on : 8 feb 2024, 11:36:19
    Author     : antonio
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Usuarios</title>
    </head>
    <body>
        <h1>Listado de Usuarios</h1>
        <ul>
            <c:forEach items="${usuarios}" var="usuario">
                <li>${usuario.idUsuario} ${usuario.username}</li>
            </c:forEach>
        </ul>
    </body>
</html>