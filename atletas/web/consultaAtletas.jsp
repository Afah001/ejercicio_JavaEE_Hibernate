
<%@page import="java.util.List"%>
<%@page import="modelo.atleta"%>
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
                <td>nombre</td>
                <td>apellido</td>
                <td>fecha nacimiento</td>
                <td>documento</td>
                <td>carreras</td>
            </tr>
            
            <% for(atleta a:(List<atleta>)request.getAttribute("lista")){ %>
                <tr>
                    <td><%= a.getNombre() %></td>
                    <td><%= a.getApellido()%></td>
                    <td><%= a.getFecha()%></td>
                    <td><%= a.getDocumento()%></td>
                    <td><% out.print((a.getCarreras()!=null)? a.getCarreras().size() : "0"); %></td>
                    
                    <td><a href="ATLETAS?accion=delete&id=<%= a.getIdatleta() %>">Eliminar</a> </td>
                </tr>
            <% } %>
        </table>
    </body>
</html>
