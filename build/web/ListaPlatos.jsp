

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Model.Plato" %>
<%@ page import="Model.PlatoDAO" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" type="text/css" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Restaurante El Colombiano - Lista de Platos del menú</title>
    </head>
    <body>
        <%
	PlatoDAO dao = new PlatoDAO();
	List<Plato> guestList = dao.getAllPlatos();
	Iterator<Plato> itr = guestList.iterator();
        Plato plato = null;
        %>
        
        <h1>Restaurante - El Colombiano - Lista de platos del Menú</h1>
        
        <table class="table">
        <caption>Lista de platos</caption>
	<tr>
		<th>Id</th>
		<th>Nombre</th>
		<th>Descripción</th>
		<th>Complejidad</th>
		<th>Precio</th>
                <th>Región</th>
                <th>Servicio</th>
                <th>Receta</th>
	</tr>
	<tr>
		<% 
		while(itr.hasNext()) {
                    plato = itr.next();
		%>
			<td><%= plato.getIdPlato()  %></td>
                        <td><%= plato.getNombre()  %></td>
                        <td><%= plato.getDescripcion() %></td>
                        <td><%= plato.getComplejidad() %></td>
                        <td><%= plato.getPrecio()%></td>
                        <td><%= plato.getRegion()%></td>
                        <td><%= plato.getServicio() %></td>
                        <td><%= plato.getReceta() %></td>
			
                        <td>
                            <form method="POST" action="PlatosServlet">
                                <button class="edit"></button>
                                <input type="hidden" name="action" value="editForm" >
                                <input type="hidden" name="ID" value="<%= plato.getIdPlato()%>" >
                            </form>
                            
                        </td>
			<td>
                            <form method="POST" action="PlatosServlet">
                                <button class="effacer" onclick="if(!confirm('¿Está seguro de eliminar el registro?')) return false;"></button>
                                <input type="hidden" name="action" value="delete" >
                                <input type="hidden" name="ID" value="<%= plato.getIdPlato()%>" >
                            </form>
                            
                        </td>
		</tr>
		<%
			}
		%>	
</table>

    <div class="lien">
        <p><a href="PlatosServlet?action=insert" >Añadir Plato al Menú</a></p>
    </div>
    <div class="lien">
        <p><a href="menu.view" >Atrás</a></p>
    </div>    
    </body>
</html>
