package lecture464.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import lecture464.model.Apartment;

/**
 * Servlet implementation class Applyandview
 */
public class Applyandview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Applyandview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		ArrayList<Apartment> selectedApartmentList=(ArrayList<Apartment>) session.getAttribute("selectedApartmentList");
		double appFee=0;
		double damageFee=0;
		double rent=0;
		double totalFee=0;
		for(int i=0; i<selectedApartmentList.size();i++){
			appFee+=selectedApartmentList.get(i).getApplicationFee();
			damageFee+=selectedApartmentList.get(i).getDamageDeposit();
			rent+=selectedApartmentList.get(i).getRent();
			totalFee+=selectedApartmentList.get(i).getTotalfee();
			
			
		}
				
		session.setAttribute("appFee",  appFee);
		session.setAttribute("damageFee",  damageFee);
		session.setAttribute("rent",  rent);
		session.setAttribute("totalFee",  totalFee);
		
		
		
		 String address = "CustomerTransaction.jsp";
		    RequestDispatcher dispatcher =
		      request.getRequestDispatcher(address);
		    dispatcher.forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);// TODO Auto-generated method stub
	}

}
