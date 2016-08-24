
<%@page import="modelo.maraton"%>
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
          <form action="CARRERAS?accion=insertar" method="post">
            
            FECHA<input name="_fecha" type="date">
            <br>
         
            ATLETA
            <select name="atleta">
                <% for(atleta a:(List<atleta>)request.getAttribute("lista1")){ %>
                <option value="<%= a.getIdatleta()%>"> <%= a.getNombre() %></option>
                <% } %>
            </select><br>
            
            MARATON
            <select name="maraton">
                <% for(maraton m:(List<maraton>)request.getAttribute("lista2")){ %>
                <option value="<%= m.getIdmaraton()%>"> <%= m.getOrganizador()%></option>
                <% } %>
            </select><br>
        
            <input type="submit" value="Registrar carrera">
        </form>
            <a href="CARRERAS?accion=consultar">carreras</a>
    </body>
</html>
