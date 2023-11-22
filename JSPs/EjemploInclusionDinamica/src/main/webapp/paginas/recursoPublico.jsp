<%-- 
    Document   : recursoPublico
    Created on : 21 nov 2023, 22:42:09
    Author     : antonio
--%>

<!-- Como es un include dinámico, lo que se va a incluir es la salida del html, y por tanto podemos dejar todas las etiquetas HTML -->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <br/>
        Inclusión de contenido dinámico desde un JSP público
        <br/>
        Nombre de la aplicación: <%= request.getContextPath() %>
    </body>
</html>
