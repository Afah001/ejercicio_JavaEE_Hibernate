

<%@page import="java.util.List"%>
<%@page import="modelo.carrera"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <td>fecha</td>
                <td>estado</td>
                <td>Atleta</td>
                <td>Maraton</td>
         
            </tr>
            
            <% for(carrera c:(List<carrera>)request.getAttribute("lista")){ %>
                <tr>
                    <td><%= c.getFecha() %></td>
                    <td><%= c.getEstado()%></td>
                    <td><%= c.getAtleta().getNombre() %></td>
                    <td><%= c.getMaraton().getFecha()%></td>
                    <td><a href="CARRERAS?accion=delete&id=<%= c.getIdcarrera()%>">Eliminar</a> </td>
                </tr>
            <% } %>
        </table>
    </body>
</html>
