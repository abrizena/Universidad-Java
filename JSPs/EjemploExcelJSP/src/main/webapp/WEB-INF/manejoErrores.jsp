<%-- 
    Document   : manejoErrores
    Created on : 21 nov 2023, 15:26:32
    Author     : antonio
--%>

<%@page isErrorPage="true"%> <%-- Al tratarse de un JSP para tratar errores, debemos poner a TRUE este atributo de la directiva @page isErrorPage, para poder acceder al objeto exception--%>
<%@page import="java.io.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manejo de errores</title>
    </head>
    <body>
        <h1>Manejo de errores</h1>
        Ocurrió una excepción: <% exception.getMessage(); %>
        <br/>
        <textarea cols="120" rows="40">
                <% exception.printStackTrace(new PrintWriter(out)); %>
        </textarea>

    </body>
</html>
