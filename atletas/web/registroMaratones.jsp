
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="MARATONES?accion=insertar" method="post">
            
            FECHA<input name="_fecha" type="date">
            <br>
            ORGANIZADOR<input name="_organizador">
            <br>
        
            <input type="submit" value="Registrar maraton">
        </form>
        
         <a href="MARATONES?accion=consultar">maratones</a>
    </body>
</html>
