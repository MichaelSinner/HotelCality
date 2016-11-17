<%-- 
    Document   : ModifyGuest
    Created on : 17-nov-2016, 11:12:17
    Author     : Michael Sinner
--%>
<%@page import="Model.Guest"%>
<%@page import="Model.GuestDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" type="text/css" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hotel Cality - Modificar Huesped</title>
    </head>
    <body>
        
         <%
            GuestDAO dao = new GuestDAO();
            int ida = Integer.parseInt((String)request.getAttribute("id"));
            Guest guest = (Guest)dao.getGuestbyID(ida);
        %>
        <form method="POST" action="ListGuestServlet" name="Agregar">
		<input type="hidden" name="action" value="edit" /> 
		<input type="hidden" name="id" value="<%= guest.getId()%>" /> 
                <table class="tableModifier">
                        <caption>Modificar Huesped</caption>
			<tr>
				<td class="l">Huesped Id : </td>
                                <td class="r"><input type="text" name="" disabled value="<%= guest.getId() %>"/></td>
			</tr>
			<tr>
				<td class="l">Nombre Huesped : </td>
                                <td class="r"><input type="text" name="txtNombre" value="<%= guest.getName() %>"/></td>
			</tr>
			<tr>
				<td class="l">Teléfono Huesped : </td>
                                <td class="r"><input type="text" name="txtTelefono" value="<%= guest.getTelephone() %>"/></td>
			</tr>
                        <tr>
				<td class="l">Cédula Huesped : </td>
                                <td class="r"><input type="text" name="txtCedula" value="<%= guest.getCedula() %>"/></td>
			</tr>
                        <tr>
				<td class="l">Email Huesped : </td>
                                <td class="r"><input type="text" name="txtEmail" value="<%= guest.getEmail() %>"/></td>
			</tr>
                        <tr>
				<td class="l">Dias de hospedaje : </td>
                                <td class="r"><input type="text" name="txtDaysStayed" value="<%= guest.getDaysStay() %>"/></td>
			</tr>
                        <tr>
				<td class="l">Número de la habitacion asignada al Huesped : </td>
                                <td class="r"><input type="text" name="txtNumRoom" value="<%= guest.getNumRoom() %>"/></td>
			</tr>
                      
			<tr>
				<td class="l"><input type="submit" value="edit" /></td>
				<td class="r"><input type="reset" value="Cancelar" /></td>
			</tr>
		</table>
	</form>
    </body>
</html>
