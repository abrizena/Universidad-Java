<%-- 
    Document   : index
    Created on : 22 nov 2023, 13:37:49
    Author     : antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo MVC 2</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Ejemplo MVC 2</h1>
        <br/>
        
        
        <br/>
        <div style="color:red">
            ${mensaje}
        </div>
        <br/>
        <!-- Obtenemos el path de la aplicación de forma dinámica con Expression Language. Esto nos obliga a que sea index.jsp y no index.html -->
        <a href="${pageContext.request.contextPath}/ServletControlador">Link al servlet controlador SIN parámetros</a>
        <br/>
        <br/>
        <!-- Obtenemos el path de la aplicación de forma dinámica con Expression Language. Esto nos obliga a que sea index.jsp y no index.html -->
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregaVariables">Link al servlet controlador CON parámetros para agregar variables</a>
        <br/>
        <br/>
        <!-- Obtenemos el path de la aplicación de forma dinámica con Expression Language. Esto nos obliga a que sea index.jsp y no index.html -->
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">Link al servlet controlador CON parámetros para listar variables</a>
    </body>
</html>
