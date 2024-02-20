
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saludos desde Struts</title>
    </head>
    <body>
        <h1><s:property value="saludosAtr"/></h1>  <!--Se va a llamar indirectamente al método getSaludosAtr()"), mostrando el contenido del atributo saludosAtr-->
    </body>
</html>
