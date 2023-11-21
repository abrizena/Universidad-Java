<%-- 
    Document   : reporteExcel
    Created on : 21 nov 2023, 11:05:02
    Author     : antonio
--%>
<%@page import="utilerias.Conversiones, java.util.Date" %>
<%@page contentType="application/vnd.ms-excel" %>   <!-- // Indicamos que devuelve un Excel -->
<%@page errorPage="/WEB-INF/manejoErrores.jsp" %>   <!-- // Indicamos que JSP debe manejar los errores, si los hay -->
<% 
    String nombreArchivo = "reporte.xls";
    response.setHeader("Content-Disposition", "inline;filename=" + nombreArchivo);  //Para que se muestre en linea el error provocado al pasarle un Date 500 
    //response.setHeader("Content-Disposition", "attachment;filename=" + nombreArchivo);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Reporte de Excel</title>
    </head>
    <body>
        <h1>Reporte de Excel</h1>
        </br>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripción</th>
                <th>Fecha</th>
            </tr>
            <tr>
                <td>1. Fundamentos de Java</td>
                <td>Aprendemos la sintaxis básica de Java</td>
                <!-- El valor 500 como fecha provocará un error, pues no es válido -->
                <!-- El valor 01-02-1988 como fecha es válido -->
                <td><%= 
                    Conversiones.format("01-02-1988") //Conversiones.format("500") 
                %></td> 
            </tr>
            <tr>
                <td>2. Programación con Java</td>
                <td>Pondremos en práctica conceptos programación orientada a objetos</td>
                <td><%= Conversiones.format(new Date()) %></td><!-- El valor fecha actual es válido -->
            </tr>
        </table>
    </body>
</html>
