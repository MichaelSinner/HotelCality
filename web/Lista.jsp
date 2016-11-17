<%-- 
    Document   : Lista
    Created on : 17-nov-2016, 10:41:12
    Author     : Michael Sinner
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Model.Guest" %>
<%@ page import="Model.GuestDAO" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/style.css" type="text/css" />
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hotel Cality - Huespedes</title>
    </head>
    
    <body>
        <%
	GuestDAO dao = new GuestDAO();
	List<Guest> guestList = dao.getAllGuest();
	Iterator<Guest> itr = guestList.iterator();
        Guest guest = null;
        %>
        <h1>Menú Huespedes</h1>
        <table class="table">
        <caption>Lista de Huespedes</caption>
	<tr>
		<th>Id</th>
		<th>Nombre</th>
		<th>Teléfono</th>
		<th>Cédula</th>
		<th>E-mail</th>
                <th>Dias Hospedaje</th>
                <th>Num Habitación</th>
                <th>Pago</th>
	</tr>
	<tr>
		<% 
		while(itr.hasNext()) {
                    guest = itr.next();
		%>
			<td><%= guest.getId()  %></td>
                        <td><%= guest.getName()  %></td>
                        <td><%= guest.getTelephone()  %></td>
                        <td><%= guest.getCedula()  %></td>
                        <td><%= guest.getEmail()  %></td>
                        <td><%= guest.getDaysStay()  %></td>
                        <td><%= guest.getNumRoom()  %></td>
                        $<td><%= guest.getPayment()  %></td>
			<td>
                            <form method="POST" action="ListGuestServlet">
                                <button class="edit"></button>
                                <input type="hidden" name="action" value="editForm" >
                                <input type="hidden" name="ID" value="<%= guest.getId()%>" >
                            </form>
                            
                        </td>
			<td>
                            <form method="POST" action="ListGuestServlet">
                                <button class="effacer" onclick="if(!confirm('¿Está seguro de eliminar el registro?')) return false;"></button>
                                <input type="hidden" name="action" value="delete" >
                                <input type="hidden" name="ID" value="<%= guest.getId()%>" >
                            </form>
                            
                        </td>
		</tr>
		<%
			}
		%>	
</table>
<div class="lien">
    <p><a href="ListGuestServlet?action=insert" >Añadir Huesped</a></p>
</div>
<div class="lien">
    <p><a href="menu.view" >Atrás</a></p>
</div>    
</body>
</html>
