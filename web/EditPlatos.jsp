
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Plato"%>
<%@page import="Model.PlatoDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" type="text/css" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Restaurante El Colombiano - Editar Plato</title>
    </head>
    <body>
        <h1>Editar Plato</h1>
         <%
            PlatoDAO dao = new PlatoDAO();
            int ida = Integer.parseInt((String)request.getAttribute("id"));
            Plato plato = (Plato)dao.getPlatobyID(ida);
        %>
    
        <form method="POST" action="PlatosServlet" name="Agregar">
		<input type="hidden" name="action" value="edit" /> 
		<input type="hidden" name="id" value="<%= plato.getIdPlato()%>" /> 
                <table class="tableModifier">
                        <caption>Modificar Huesped</caption>
			<tr>
				<td class="l">Plato Id : </td>
                                <td class="r"><input type="text" name="" disabled value="<%= plato.getIdPlato()%>"/></td>
			</tr>
			<tr>
				<td class="l">Nombre del plato: </td>
                                <td class="r"><input type="text" name="txtNombre" value="<%= plato.getNombre() %>"/></td>
			</tr>
			<tr>
				<td class="l">Descripción del plato: </td>
                                <td class="r"><input type="text" name="txtDescripcion" value="<%= plato.getDescripcion()%>"/></td>
			</tr>
                        <tr>
				<td class="l">Complejidad de preparación: </td>
                                <td class="r"><input type="text" name="txtComplejidad" value="<%= plato.getComplejidad() %>"/></td>
			</tr>
                        <tr>
				<td class="l">Precio: </td>
                                <td class="r"><input type="text" name="txtPrecio" value="<%= plato.getPrecio()%>"/></td>
			</tr>
                        <tr>
				<td class="l">Región del plato: </td>
                                <td class="r"><input type="text" name="txtRegion" value="<%= plato.getRegion()%>"/></td>
			</tr>
                        <tr>
				<td class="l">Servicio: </td>
                                <td class="r"><input type="text" name="txtServicio" value="<%= plato.getServicio() %>"/></td>
			</tr>
                        
                        <tr>
				<td class="l">Receta: </td>
                                <td class="r"><input type="text" name="txtReceta" value="<%= plato.getReceta() %>"/></td>
			</tr>
                      
			<tr>
				<td class="l"><input type="submit" value="edit" /></td>
				<td class="r"><input type="reset" value="Cancelar" /></td>
			</tr>
		</table>
	</form>
                        
        <div class="lien">
            <p><a href="menu.view" >Atrás</a></p>
        </div>  
        
    </body>
</html>
