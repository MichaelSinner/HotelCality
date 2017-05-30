

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" type="text/css" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Restaurante El Colombiano - Añadir Plato</title>
    </head>
    <body>
        <h1>Ingrese la Información del plato</h1>
        <form method="POST" action="PlatosServlet" name="Añadir">
		<input type="hidden" name="action" value="insert" />
		<table>
                        <caption>Añadir un nuevo huesped</caption>
			<tr>
                                <td><input type="text" name="id" placeholder="Plato Id" required="required"/></td>
			</tr>
                        <tr>
                                <td><input type="text" name="txtNombre" placeholder="Nombre :" required="required"/></td>
			</tr>
                        <tr>
                                <td><input type="text" name="txtDescripcion" placeholder="Descripción :" required="required"/></td>
			</tr>
                        <tr>
                                <td><input type="number" name="txtComplejidad" placeholder="Complejidad :" required="required"/></td>
			</tr>
                        <tr>
                                <td><input type="number" name="txtPrecio" placeholder="Precio" required="required"/></td>
			</tr>
                        <tr>
                                <td><input type="text" name="txtRegion" placeholder="Región :" required="required"/></td>
			</tr>
                        <tr>
                                <td><input type="text" name="txtServicio" placeholder="Servicio :" required="required"/></td>
			</tr>
                        <tr>
                                <td><input type="text" name="txtReceta" placeholder="Receta :" required="required"/></td>
			</tr>
                    
                        <tr>
                            <td><input type="submit" value="Registrar" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Cancelar" /></td>
			</tr>
                        
                        
		</table>
	</form>
        <div class="lien">
            <p><a href="menu.view" >Atrás</a></p>
        </div>  
    
    </body>
</html>
