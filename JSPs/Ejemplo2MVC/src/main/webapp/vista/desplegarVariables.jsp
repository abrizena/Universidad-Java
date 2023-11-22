<%-- 
    Document   : desplegarVariables
    Created on : 22 nov 2023, 13:31:23
    Author     : antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Despliegue de Variables con JSP</title>
    </head>
    <body>
        <h1>Despliegue de Variables con JSP</h1>
        Variable en alcance request: ${mensaje}
        <br/>
        <br/>
        Variable en alcance session: 
        <br/>
        <strong>Rectangulo:</strong>
        <%-- Accede indirectamente a los atributos mediante los getters, aunque parezca por la sintaxis que se acceda directamente --%>
        Base: ${rectangulo.base}
        Altura: ${rectangulo.altura}
        Area: ${rectangulo.area}
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Regresar al inicio</a>
    </body>
</html>
