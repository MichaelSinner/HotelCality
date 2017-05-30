/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Plato;
import Model.PlatoDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael Sinner
 */
public class PlatosServlet extends HttpServlet {
    private static final String UserRecord = null;
	private static String INSERT = "/RegistrarPlatos.jsp";
	private static String edit = "/EditPlatos.jsp";
	private static String delete = "/DeletePlato.jsp";
	private static String list = "/ListaPlatos.jsp";
        
        private PlatoDAO dao;
	
	
        public PlatosServlet() 
        {
            super();
            dao = new PlatoDAO();	
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String redirect = "";
        String uId = request.getParameter("id");
        String action = request.getParameter("action");
        
        if(uId != null && "insert".equalsIgnoreCase(action))
        {
            int ID = Integer.parseInt(uId);
            Plato plato = new Plato();
            
            plato.setIdPlato(ID);
            plato.setNombre(request.getParameter("txtNombre"));
            plato.setDescripcion(request.getParameter("txtDescripcion"));
            plato.setComplejidad(Integer.parseInt(request.getParameter("txtComplejidad")));
            plato.setPrecio(Integer.parseInt(request.getParameter("txtPrecio")));
            plato.setRegion(request.getParameter("txtRegion"));
            plato.setServicio(request.getParameter("txtServicio"));
            plato.setReceta(request.getParameter("txtReceta"));
            
            
            dao.addPlato(plato);
            redirect = list;
            request.setAttribute("platos", dao.getAllPlatos());
            
        }else if("delete".equalsIgnoreCase(action)){
            String platoID = request.getParameter("ID");
            int id = Integer.parseInt(platoID);
            dao.removePlato((id));
            redirect = list;
            request.setAttribute("platos", dao.getAllPlatos());
            
        }else if("editForm".equalsIgnoreCase(action)){
            request.setAttribute("id", request.getParameter("ID"));
            redirect = edit;
        }else if("edit".equalsIgnoreCase(action)){
            String platoID = request.getParameter("id");
            int id = Integer.parseInt(platoID);
            Plato plato = new Plato();
            
            plato.setIdPlato(id);
            plato.setNombre(request.getParameter("txtNombre"));
            plato.setDescripcion(request.getParameter("txtDescripcion"));
            plato.setComplejidad(Integer.parseInt(request.getParameter("txtComplejidad")));
            plato.setPrecio(Integer.parseInt(request.getParameter("txtPrecio")));
            plato.setRegion(request.getParameter("txtRegion"));
            plato.setServicio(request.getParameter("txtServicio"));
            plato.setReceta(request.getParameter("txtReceta"));
            
            
            dao.editPlato(plato);
            request.setAttribute("plato", plato);
            redirect = list;
        }else if("ListPlatos".equalsIgnoreCase(action)){
            request.setAttribute("platos", dao.getAllPlatos());
            
        }else{
            redirect = INSERT;
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(redirect);
            rd.forward(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
			doGet(request,response);
                        
		}

    

}
