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
 * Servlet implementation class SearchResults
 */
public class SearchResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResults() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		ArrayList<Apartment> apartmentList= (ArrayList<Apartment>) session.getAttribute("apartmentList");
		String index=request.getParameter("View and apply");
		int Index=Integer.parseInt(index);
		Apartment selectedApartment=apartmentList.get(Index-1);
		// TODO Auto-generated method stub
		 session.setAttribute("selectedApartment", selectedApartment);
		 session.removeAttribute("success");
		 //response.sendRedirect("ApplyAndView.jsp");
		 String address = "ApplyAndView.jsp";
		    RequestDispatcher dispatcher =
		      request.getRequestDispatcher(address);
		    dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);// TODO Auto-generated method stub
	}

}
