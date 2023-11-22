<%-- 
    Document   : jstlCore
    Created on : 22 nov 2023, 12:02:27
    Author     : antonio
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- No va a internet, busca en las librerias de dependencias de nuestro proyecto -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSTL core</title>
    </head>
    <body>
        <h1>JSTL core (Jsp Standard Tag Library)</h1>
        <!-- Manipulación de variables -->
        <c:set var="nombre" value="Ernesto" /> <!-- Definimos la variable -->
        Variable nomber: <c:out value="${nombre}"/> <!-- Desplegamos el valor de la variable con EL -->
        <br/>
        <br/>
        Variable con código html: <c:out value="<h4>Hola</h4>" escapeXml="false"/>
        <br/>
        <!-- Código condicionado, uso de if -->
        <c:set var="bandera" value="true"/>
        <c:if   test="${bandera}">
            La bandera es verdadera
        </c:if>
        <br/>
        <!-- Simula el uso de if para comprobar que opcion no es nulo y switch para seleccionar la salida correspondiente -->
        <c:if test="${param.opcion != null}">
            <c:choose>  
                <c:when test="${param.opcion==1}">
                    <br/>
                    Opcion 1 seleccionada
                </c:when>   
                <c:when test="${param.opcion==2}">
                    <br/>
                    Opcion 2 seleccionada
                </c:when>
                <c:otherwise>
                    <br/>
                    Opcion proporcionada desconocida: ${param.opcion}
                </c:otherwise>
            </c:choose>
        </c:if>
        <!-- Iteración de un arreglo --> 
        <!-- Con un scriptlet creamos una variable nombers con el array y lo compartimos como un atributo con cualquier nombre, en este caso "nombres"  -->
        <!-- La variable nombres tiene de scope request -->
        <%
            String nombres[]={"Claudia", "Pedro", "Juan"};
            request.setAttribute("nombres", nombres);
        %>
        <!-- Recorremos la lista de nombres con EL -->
        <br/>
        <br/>
        Lista de nombres:
        <br/>
        <ul>
            <c:forEach var="persona" items="${nombres}">
                <li>${persona}</li>
            </c:forEach>
        </ul>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>

    </body>
</html>
