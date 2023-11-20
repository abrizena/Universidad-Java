<%-- 
    Document   : index
    Created on : 20 nov 2023, 13:53:17
    Author     : antonio
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> <%-- @ directiva, para indicar el tipo de contenido --%>
<!DOCTYPE html>
<html>
    <head>
        <title>HolaMundo JSPs</title>
    </head>
    <body>
        <h1>HolaMundo JSPs</h1>
        <ul>
            <li> <% out.print("HolaMundo con Scriptlets"); %></li>
            <li> ${"HolaMundo con Expression Language (EL)"}</li>
            <li> <%= "HolaMundo con Expresiones" %></li>
            <li> <c:out value="HolaMundo con JSTL"/></li>
        </ul>

    </body>
</html>
