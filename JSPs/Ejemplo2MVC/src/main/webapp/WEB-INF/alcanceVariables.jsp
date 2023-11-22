<%-- 
    Document   : alcanceVariables
    Created on : 22 nov 2023, 15:49:13
    Author     : antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Alcance de Variables</title>
    </head>
    <body>
        <h1>Alcance de Variables (Scope)</h1>
        <br/>
        <!-- El alcance de request no contiene la variable, pues es un nuevo request. -->
        Variable request:
        Base: ${rectanguloRequest.base}
        Altura: ${rectanguloRequest.altura}
        Area: ${rectanguloRequest.area}
        <br/>
        <br/>
        Variable session:
        Base: ${rectanguloSesion.base}
        Altura: ${rectanguloSesion.altura}
        Area: ${rectanguloSesion.area}
        <br/>
        <br/>
        Variable application:
        Base: ${rectanguloAplicacion.base}
        Altura: ${rectanguloAplicacion.altura}
        Area: ${rectanguloAplicacion.area}
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Regresar al inicio</a>
        
        <h3>NOTAS:</h3>
        <ul>
            <li>El alcance de request: NO contiene información la variable, pues es un nuevo request. </li>
            <li>El alcance de session: SI contiene información la variable, pues se mantiene durante 30 minutos por defecto la sesión </li>
            <li>El alcance de application: SI contiene información la variable, pues se mantiene mientras se ejecute la aplicación. </li>
        </ul>
        
    </body>
</html>
