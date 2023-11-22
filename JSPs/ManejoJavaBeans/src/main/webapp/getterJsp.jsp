<%-- 
    Document   : getterJsp
    Created on : 22 nov 2023, 9:05:24
    Author     : antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP que lee los valores del JavaBean</title>
    </head>
    <body>
        <h1>JSP que lee los valores del JavaBean</h1>
        
        <!-- Recuperamos variable rectangulo de clase Rectangulo mediante jsp:useBean. Utilizamos alcance session para que la variable exista durante toda la sesion, manteniendo valor atributos -->
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        
        Valor base: <jsp:getProperty name="rectangulo" property="base" /><!-- Aunque existe la propiedad base, no accede directamente a su valor si existe getBase, sino que utiliza el getter indirectamente -->
        <br/>
        Valor altura: <jsp:getProperty name="rectangulo" property="altura" /><!-- Aunque existe la propiedad altura, no accede directamente a su valor si existe getAltura, sino que utiliza el getter indirectamente -->
        
        <!-- Aunque no existe la propiedad area, podemos llamar al método getArea, simplemente como propiedad area -->
        <br/>
        Valor area: <jsp:getProperty name="rectangulo" property="area" /> 
        <br/>
        <br/>
        <a href="index.jsp" target="_blank">Regresar al inicio</a>
    </body>
</html>
