
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ATLETAS</h1>
        
        <form action="ATLETAS?accion=insertar" method="post">
            
            NOMBRE<input name="_nombre">
            <br>
            APELLIDO<input name="_apellido">
            <br>
            FECHA NACIMIENTO<input name="_fechaNacimiento" type="date">
            <br>
            DOCUMENTO<input name="_documento" >
            <br>
            
            <input type="submit" value="Registrar Atleta">
        </form>
        
        <a href="ATLETAS?accion=consultar">atletas</a>
    </body>
</html>
