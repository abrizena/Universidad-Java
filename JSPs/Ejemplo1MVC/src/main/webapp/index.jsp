<%-- 
    Document   : index
    Created on : 22 nov 2023, 13:37:49
    Author     : antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo MVC</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Ejemplo MVC</h1>
        <br/>
        <!-- Obtenemos el path de la aplicación de forma dinámica con Expression Language. Esto nos obliga a que sea index.jsp y no index.html -->
        <a href="${pageContext.request.contextPath}/ServletControlador">Link al servlet controlador que despliega las variables</a>
    </body>
</html>
