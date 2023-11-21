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
                <th>Descripci�n</th>
                <th>Fecha</th>
            </tr>
            <tr>
                <td>1. Fundamentos de Java</td>
                <td>Aprendemos la sintaxis b�sica de Java</td>
                <!-- El valor 500 como fecha provocar� un error, pues no es v�lido -->
                <!-- El valor 01-02-1988 como fecha es v�lido -->
                <td><%= 
                    Conversiones.format("01-02-1988") //Conversiones.format("500") 
                %></td> 
            </tr>
            <tr>
                <td>2. Programaci�n con Java</td>
                <td>Pondremos en pr�ctica conceptos programaci�n orientada a objetos</td>
                <td><%= Conversiones.format(new Date()) %></td><!-- El valor fecha actual es v�lido -->
            </tr>
        </table>
    </body>
</html>
