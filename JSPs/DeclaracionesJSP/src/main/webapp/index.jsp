<%-- 
    Document   : index
    Created on : 21 nov 2023, 9:02:03
    Author     : antonio
--%>

<%-- Agregamos una declaración de JSP --%>
<%!
//Declaramos una variable con su método GET
private String usuario="Alberto";

public String getUsuario(){
    return this.usuario;
}

//Declaramos un contador de visitas
private int contadorVisitas = 1;

%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uso de Declaraciones con JSPs</title>
    </head>
    <body>
        <h1>Uso de Declaraciones con JSPs</h1>
        Valor de usuario por medio del atributo: <%= this.usuario %>
        <br> 
        Valor de usuario por medio del método: <%= this.getUsuario() %>
        <br> 
        Contador visitas: <%= this.contadorVisitas++ %>
    </body>
</html>
