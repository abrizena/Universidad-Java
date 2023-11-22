<%-- 
    Document   : setterJsp
    Created on : 22 nov 2023, 9:03:42
    Author     : antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP que modifica a un JavaBean</title>
    </head>
    <body>
        <h1>JSP que modifica a un JavaBean</h1>
        
        <!-- Creamos variable de clase Rectangulo mediante jsp:useBean. Utilizamos alcance session para que la variable exista durante toda la sesion, manteniendo valor atributos -->
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session"></jsp:useBean> 
        
        Modificamos los atributos:
        <br/>
        <br/>
        <!-- scriplet para crear los valores de base y altura, para asignarlos después a los atributos de la clase Rectangulo -->
        <%
            int baseValor=5;
            int alturaValor=10;
        %>
        <jsp:setProperty name="rectangulo" property="base" value="<%=baseValor%>"/><!-- Aunque existe la propiedad base, no accede directamente a su valor si existe setBase, sino que utiliza el setter indirectamente -->
        <jsp:setProperty name="rectangulo" property="altura" value="<%=alturaValor%>"/><!-- Aunque existe la propiedad altura, no accede directamente a su valor si existe setAltura, sino que utiliza el setter indirectamente -->
        <br/>
        Nuevo valor de base: <%=baseValor%>
        <br/>
        Nuevo valor de altura: <%=alturaValor%>
        <br/>
        <br/>
        <a href="index.jsp" target="_blank">Regresar al inicio</a>
    </body>
</html>
