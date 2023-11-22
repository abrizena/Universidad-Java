<%-- 
    Document   : variablesImplicitas
    Created on : 22 nov 2023, 11:27:11
    Author     : antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>EL y Variables Implícitas</title>
    </head>
    <body>
        <h1>EL y Variables Implícitas</h1>
        <ul>
            <li>Nombre de la aplicación: ${pageContext.request.contextPath}</li> <!-- Indirectamente manda a llamar al método getContextPath -->
            <li>Navegador del Cliente: ${header["User-Agent"]}</li>
            <li>Id Sesión: ${cookie.JSESSIONID.value}</li>
            <li>Web Server: ${pageContext.servletContext.serverInfo}</li>
            <li>Valor parametro: ${param.usuario}</li>
            <li>Valor parametro: ${param["usuario"]}</li>  <!-- También podemos utilizar la sintaxis de arrays -->
        </ul>
        <br/>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
