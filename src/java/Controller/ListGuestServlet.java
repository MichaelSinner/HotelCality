/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Guest;
import Model.GuestDAO;
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
public class ListGuestServlet extends HttpServlet {
    private static final String UserRecord = null;
	private static String INSERT = "/RegistrarG.jsp";
	private static String edit = "/ModifyGuest.jsp";
	private static String delete = "/DeleteGuest.jsp";
	private static String list = "/Lista.jsp";
        private final int paymentPerDay = 100000;
	private GuestDAO dao;
	
        public ListGuestServlet() 
        {
            super();
            dao = new GuestDAO();	
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
            Guest guest = new Guest();
            
            guest.setId(ID);
            guest.setName(request.getParameter("txtNombre"));
            guest.setTelephone(request.getParameter("txtTelefono"));
            guest.setCedula(request.getParameter("txtCedula"));
            guest.setEmail(request.getParameter("txtEmail"));
            guest.setDaysStay(Integer.parseInt(request.getParameter("txtDaysStayed")));
            guest.setNumRoom(Integer.parseInt(request.getParameter("txtNumRoom")));
            guest.setPayment(paymentPerDay*Integer.parseInt(request.getParameter("txtDaysStayed")));
            
            dao.addGuest(guest);
            redirect = list;
            request.setAttribute("guests", dao.getAllGuest());
        }else if("delete".equalsIgnoreCase(action)){
            String guestId = request.getParameter("ID");
            int id = Integer.parseInt(guestId);
            dao.removeGuest(id);
            redirect = list;
            request.setAttribute("guests", dao.getAllGuest());
        }else if("editForm".equalsIgnoreCase(action)){
            request.setAttribute("id", request.getParameter("ID"));
            redirect = edit;
        }else if("edit".equalsIgnoreCase(action)){
            String guestID = request.getParameter("id");
            int id = Integer.parseInt(guestID);
            Guest guest = new Guest();
            guest.setId(id);
            guest.setName(request.getParameter("txtNombre"));
            guest.setTelephone(request.getParameter("txtTelefono"));
            guest.setCedula(request.getParameter("txtCedula"));
            guest.setEmail(request.getParameter("txtEmail"));
            guest.setDaysStay(Integer.parseInt(request.getParameter("txtDaysStayed")));
            guest.setNumRoom(Integer.parseInt(request.getParameter("txtNumRoom")));
            guest.setPayment(paymentPerDay*Integer.parseInt(request.getParameter("txtDaysStayed")));
            dao.editGuest(guest);
            request.setAttribute("guest", guest);
            redirect = list;
        }else if("ListGuest".equalsIgnoreCase(action)){
            request.setAttribute("guests", dao.getAllGuest());
            
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
