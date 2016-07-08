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
 * Servlet implementation class ShoppingCart
 */
public class shopCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shopCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Apartment apartment=(Apartment) session.getAttribute("selectedApartment");// TODO Auto-generated method stub
		ArrayList <Apartment> selectedApartmentList=(ArrayList<Apartment>) session.getAttribute("selectedApartmentList");
		String length=request.getParameter("eMonth");
		int leaseLength=Integer.parseInt(length);
		apartment.setleaseLength(leaseLength);
		String success=null;
		if (selectedApartmentList == null) {		    
			selectedApartmentList = new ArrayList <Apartment>();
		     
		    }
		int exist=0;
		for(int i=0;i<selectedApartmentList.size();i++)
		{
			if(apartment.getApartmentId()==selectedApartmentList.get(i).getApartmentId())
			{
				exist=1;
				success="The apartment has already been added to the shpping cart";
				
			}
		}
		if(exist==0)
		{
		selectedApartmentList.add(apartment);
		success="The apartment be added into the shopping cart successfully";
		}
		session.setAttribute("selectedApartmentList", selectedApartmentList);
		session.setAttribute("success",success);
	
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
	}
	public String GetJson(String RID)
	{
		return RID;
	}

}
