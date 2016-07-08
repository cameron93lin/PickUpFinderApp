package lecture464.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import lecture464.model.Apartment;
import lecture464.model.Application;
import lecture464.model.Bank;
import lecture464.model.Users;

/**
 * Servlet implementation class Tran
 */
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

				
				HttpSession session=request.getSession();
				Connection conn = null;
				Statement stmt = null;
				PreparedStatement ps = null;
				ResultSet rs=null;
				
				int msg = 0;
		        response.setContentType("text/html;charset=UTF-8");
		        PrintWriter out = response.getWriter();
		        
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
				System.out.println("transaction");
				
				//session.removeAttribute("selectedApartment");
				String cardNumber= request.getParameter("cardNumber");
				System.out.println(cardNumber);
				String cardType=request.getParameter("cardType");
				String securityCode=request.getParameter("securityCode");
				String inputDatetime=request.getParameter("inputDatetime");
				//String eYear=request.getParameter("eYear");
				String exDate=inputDatetime;
				System.out.println("alksdjfalksdjf asdf"+exDate);
				String firstName=request.getParameter("firstName");
				String lastName=request.getParameter("lastName");
				String CardholderName=firstName+lastName;
				ArrayList<Apartment> selectedApartmentList =(ArrayList<Apartment>) session.getAttribute("selectedApartmentList");
				 Bank bank=null;
				Apartment apartment= null;
				for(int i=0;i<selectedApartmentList.size();i++){
					apartment=selectedApartmentList.get(i);
		        double totalFee=apartment.getTotalfee();
		        bank=new Bank(cardNumber, cardType, securityCode, exDate, CardholderName,totalFee);
		        bank.setAId(apartment.getApartmentId());
		        bank.verifation();
		       
			}
				 if(bank.getValidate()==0){
			        	msg=1;
			        	out.print(msg);
			        }
			        else{
			        	msg=0;
			        	out.print(msg);
			        	
			        }
		       
//		        if(tran.getValidate()==0){
//		        	
//		        	int ApartmentId=selectedApartment.getApartmentId();
//		        	int Status=1;
//		        	String ApplicationNumber="00000000"+(applicationList.size()+1);
//		        	int LeaseTerm= selectedApartment.getleaseLength();
//		        	double Cost=selectedApartment.getTotalfee();
//		        	int AgentId=selectedApartment.getAgentId();
//		        	String ApplyingDate =format.format(cal.getTime());
//		        	Users loginUser=(Users) session.getAttribute("loginUser");
//		        	int ApplicantId=loginUser.getId();
//		        	String MoveInDate=selectedApartment.getAvailableDate();
//		        	String Notes="Hmmmmmmmmmmm";
//		        	int CardId=tran.getCardId();
//		        	
//		        	Application application=new Application( ApartmentId, Status,  ApplicationNumber, ApplyingDate, ApplicantId,  MoveInDate,  LeaseTerm, Cost,  Notes,CardId);	
//		        	applicationList.add(application);
//		        	
//		        	session.setAttribute("selectedApartment", selectedApartment);
//		        	session.setAttribute("applicationList", applicationList);
//		        	
//		        	application.addApplications();
		        		
		        	
		        
		        
//		        session.setAttribute("validate", bank.getValidate());
//		        
//		        String address = "Confirmation.jsp";
//		    	RequestDispatcher dispatcher = request.getRequestDispatcher(address);
//		    	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
