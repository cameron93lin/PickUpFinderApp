package lecture464.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.Apartment;

/**
 * Servlet implementation class remove
 */
public class remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public remove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		ArrayList<Apartment> selectedApartmentList= (ArrayList<Apartment>) session.getAttribute("selectedApartmentList");
		String index=request.getParameter("remove");
		int Index=Integer.parseInt(index);
		selectedApartmentList.remove(Index-1);
		session.setAttribute("selectedApartmentList", selectedApartmentList);
		
		
		 String address = "ShoppingCart.jsp";
		 RequestDispatcher dispatcher =
		 request.getRequestDispatcher(address);
		 dispatcher.forward(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
