<%-- 
    Document   : scriptlets
    Created on : 20 nov 2023, 22:21:30
    Author     : antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP con Scriptlets</title>
    </head>
    <body>
        <h1>JSP con Scriptlets</h1>
        <br> 
        <%-- Scriptlet para enviar información al navegador --%>
        <% 
            out.print("Saludos desde un Scriptlet\n");           
        %>
        <%-- Scriptlet para manipular objetos implicitos --%>
        <% 
            String nombreAplicacion = request.getContextPath();
            out.print("Nombre de la aplicación: "+ nombreAplicacion);
        %>
        <br>
        <%-- Scriptlet con codigo condicionado --%>
        <% 
            if(session != null && session.isNew()){
        %>
        la sesion SI es nueva
        <%   } else if(session !=null){
        %>
        la sesion NO es nueva
        <% } %>
        <br>
        <a href="index.html">Volver al inicio</a>
    </body>
</html>
