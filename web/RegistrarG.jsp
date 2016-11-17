<%-- 
    Document   : RegistrarG
    Created on : 17-nov-2016, 10:53:42
    Author     : Michael Sinner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" type="text/css" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hotel Cality - Añadir Huesped</title>
    </head>
    <body>
         <form method="POST" action="ListGuestServlet" name="Añadir">
		<input type="hidden" name="action" value="insert" />
		<table>
                        <caption>Añadir un nuevo huesped</caption>
			<tr>
                                <td><input type="text" name="id" placeholder="Huesped Id" required="required"/></td>
			</tr>
			<tr>
                                <td><input type="text" name="txtNombre" placeholder="Nombre" required="required"/></td>
			</tr>
                        <tr>
                                <td><input type="text" name="txtTelefono" placeholder="Teléfono" required="required"/></td>
			</tr>
                        <tr>
                                <td><input type="text" name="txtCedula" placeholder="Cédula" required="required"/></td>
			</tr>
                        <tr>
                                <td><input type="email" name="txtEmail" placeholder="Email" required="required"/></td>
			</tr>
                        <tr>
                                <td><input type="number" name="txtDaysStayed" placeholder="Dias de hospedaje " required="required"/></td>
			</tr>
                        <tr>
                                <td><input type="number" name="txtNumRoom" placeholder="Número de Habitación" required="required"/></td>
			</tr>
                        			
                        <tr>
                            <td><input type="submit" value="Registrar" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Cancelar" /></td>
			</tr>
		</table>
	</form>
    </body>
</html>
