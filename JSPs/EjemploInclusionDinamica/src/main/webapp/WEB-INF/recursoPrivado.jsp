<%-- 
    Document   : recursoPrivado
    Created on : 21 nov 2023, 22:42:43
    Author     : antonio
--%>
<%
    String colorFondo = request.getParameter("colorFondo");
%>
<!DOCTYPE html>
<!-- Como es un include dinámico, lo que se va a incluir es la salida del html, y por tanto podemos dejar todas las etiquetas HTML -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="<%= colorFondo %>">
    </body>
</html>
