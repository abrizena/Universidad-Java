<%-- 
    Document   : procesaFormulario
    Created on : 20 nov 2023, 15:35:25
    Author     : antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procesa Formulario</title>
    </head>
    <body>
        <h1>Resultado de Procesar el Formulario</h1>
        <br/>
        Usuario: <%= request.getParameter("usuario")%>
        <br/>
        Password: <%= request.getParameter("password")%>
        <br/>
        <br/>
        <a href="index.html">Regresar al inicio</a>
    </body>
</html>
