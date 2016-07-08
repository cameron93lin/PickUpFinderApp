package lecture464.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;

import lecture464.model.Apartment;
import lecture464.model.DataBase;

/**
 * Servlet implementation class AppartmentSearchQuery
 */
public class AppartmentSearchQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppartmentSearchQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String movingDate= request.getParameter("movingDate");
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date Df1=null;
		try {
			 Df1=df.parse(movingDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String minPrice=request.getParameter("minPrice");
		String maxPrice=request.getParameter("maxPrice");
		String Location=request.getParameter("City");
		String type=request.getParameter("type");
		double minP=Double.parseDouble(minPrice);
		double maxP=Double.parseDouble(maxPrice);
		HttpSession session = request.getSession();
		session.removeAttribute("apartmentList"); 
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		//ArrayList<Apartment> apartmentList=new ArrayList<Apartment>();
		 ArrayList<Apartment> apartmentList = new ArrayList<Apartment>();
			
		    
		   
			      
		    
		
		try{
			  //STEP 2: Register JDBC driver
			  
			  //STEP 3: Open a connection
			  System.out.println("Connecting to database...");
			  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			  conn=DriverManager.getConnection(DataBase.url,DataBase.username,DataBase.password);
			  
			  System.out.println("\nSuccessfully connected to database...");

			  //STEP 4: Execute a query
			  System.out.println("\nCreating statement...");
			  
			  stmt = conn.createStatement();
			 
			  /** Following sql statements create an Employee table
			   * Insert values into the table
			   * Read all the rows and attributes from the table
			   */
			  String sql;
			  //sql = "select * from Apartments where PricePerMonth>= ? and PricePerMonth<= ? and AptType=?";
			  sql="select * from Apartments";
	
			 
			
			  ps = conn.prepareStatement(sql);
			  System.out.println("lalala");
			  System.out.println("\nProblem: 2");
			 // ps.setDouble(1, minP);
			 // ps.setDouble(2, maxP);
			 // ps.setString(3,type);
			  
			  
			   rs = ps.executeQuery();
			  

			  
			 
			  while(rs.next()){
				   int id  = rs.getInt("Id");
				    String Landlord = rs.getString("Landlord");
				    String AptNumber=rs.getString("AptNumber");
				    String AptType=rs.getString("AptType");
				    String ApartmentAddress = rs.getString("Address");
				    String City=rs.getString("City");
				    String State=rs.getString("State");
				    String Area=rs.getString("Area");
				    String Bathrooms=rs.getString("Bathrooms");
				    double PricePerMonth=rs.getDouble("PricePerMonth");
				    double ApplicationFee=rs.getDouble("ApplicationFee");
				    double DamageDeposit=rs.getDouble("DamageDeposit");
				    String Description=rs.getString("Description");
				    int Availability=rs.getInt("Availability");
				    String AvailableDate = rs.getString("AvailableDate");
				    Date Df2=null;
				    try {
						 Df2=df.parse(AvailableDate);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    int AgentId=rs.getInt("AgentId");
				    
				    
				    if(PricePerMonth>minP&&PricePerMonth<maxP&&AptType.equals(type)&&Location.equals(City)&&Df1.getTime() > Df2.getTime()&&Availability==1)
				    {
				    Apartment apartment = new Apartment(id,Landlord,AptNumber,AptType,ApartmentAddress,City,State,Area,
				    		Bathrooms, PricePerMonth,ApplicationFee,DamageDeposit,Description, Availability,movingDate,AgentId);
				    apartmentList.add(apartment);
				    }
				    
                    
				 }
			  
			  session.setAttribute("apartmentList", apartmentList);
			  String address = "ApartmentSearchResult.jsp";
			    RequestDispatcher dispatcher =
			      request.getRequestDispatcher(address);
			    dispatcher.forward(request, response);
			  
			    
			   System.out.println(apartmentList.size());
			   
			   apartmentList=new ArrayList<Apartment>();
			   
			  
			  
			}catch(SQLException e){
	    		e.printStackTrace();
	    	}finally{
	    		DataBase.DatabaseRelease(rs, stmt, conn);
	    	}//end try
		   
		   //response.sendRedirect("ApartmentSearchResult.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);// TODO Auto-generated method stub
	}

}
