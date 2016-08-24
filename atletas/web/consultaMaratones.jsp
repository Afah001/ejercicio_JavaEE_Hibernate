

<%@page import="java.util.List"%>
<%@page import="modelo.maraton"%>
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
                <td>organizador</td>
                <td>carreras</td>
                
            </tr>
            
            <% for(maraton m:(List<maraton>)request.getAttribute("lista")){ %>
                <tr>
                    <td><%= m.getFecha()%></td>
                    <td><%= m.getOrganizador()%></td>
                    <td><% out.print((m.getCarreras()!=null)? m.getCarreras().size() : "0"); %></td>
                    <td><a href="MARATONES?accion=delete&id=<%= m.getIdmaraton()%>">Eliminar</a> </td>
                </tr>
            <% } %>
        </table>
    </body>
</html>
