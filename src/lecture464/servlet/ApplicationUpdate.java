package lecture464.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.Apartment;
import lecture464.model.Application;
import lecture464.model.Bank;
import lecture464.model.Users;

/**
 * Servlet implementation class ApplicationUpdate
 */
public class ApplicationUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("skdkfjieuaiu"+"Tianyi Wang");
		HttpSession session=request.getSession();
		ArrayList<Application> applicationList=new ArrayList<Application>(); 
		ArrayList<Apartment> selectedApartmentList= (ArrayList<Apartment>) session.getAttribute("selectedApartmentList");
		//session.removeAttribute("selectedApartment");
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
		String cardNumber= request.getParameter("cardNumber");
		String cardType=request.getParameter("cardType");
		String securityCode=request.getParameter("securityCode");
		String inputDatetime=request.getParameter("inputDatetime");
		//String eYear=request.getParameter("eYear");
		String exDate=inputDatetime;
		System.out.println("alksdjfalksdjf asdf"+exDate);
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String CardholderName=firstName+lastName;
		Apartment apartment=null;
		
		
		for(int i=0;i<selectedApartmentList.size();i++){
			apartment=selectedApartmentList.get(i);
			
		double totalFee=apartment.getTotalfee();
		System.out.println("Upadate application");
		Bank tran=new Bank(cardNumber, cardType, securityCode, exDate, CardholderName,totalFee);
		
		
		
        	
        	int ApartmentId=apartment.getApartmentId();
        	int Status=1;
        	String ApplicationNumber="00000000"+(applicationList.size()+1);
        	int LeaseTerm= apartment.getleaseLength();
        	double Cost=apartment.getTotalfee();
        	int AgentId=apartment.getAgentId();
        	String ApplyingDate =format.format(cal.getTime());
        	Users loginUser=(Users) session.getAttribute("loginUser");
        	int ApplicantId=loginUser.getId();
        	String MoveInDate=apartment.getAvailableDate();
        	String Notes="Hmmmmmmmmmmm";
        	int CardId=tran.getCardId();
        	
        	Application application=new Application( ApartmentId, Status,  ApplicationNumber, ApplyingDate, ApplicantId,  MoveInDate,  LeaseTerm, Cost,  Notes,CardId);	
        	applicationList.add(application);
        	
        	session.setAttribute("selectedApartment", apartment);
        	session.setAttribute("applicationList", applicationList);
        	
        	application.addApplications();
	}
        		
        	
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
