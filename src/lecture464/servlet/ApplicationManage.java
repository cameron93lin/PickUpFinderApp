package lecture464.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.Apartment;
import lecture464.model.Application;
import lecture464.model.Users;

/**
 * Servlet implementation class ApplicationManage
 */
public class ApplicationManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Users loginUser=(Users) session.getAttribute("loginUser");
    	int ApplicantId=loginUser.getId();
    	ArrayList<Application> selectedApplication=new ArrayList<Application>();
    	
		/*ArrayList<Application> applicationList= (ArrayList<Application>) session.getAttribute("applicationList");
		
    	Application selectedApplication=applicationList.get(ApplicantId);
		session.setAttribute("selectedApplication", selectedApplication);
		String address = "ManageApplication.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);*/
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  // TODO Auto-generated method stub
		final String DB_URL = "jdbc:mysql://cse.unl.edu/tiwang";
		final String USER = "tiwang"; // CSE_LOGIN
		final String PASS = "Zxcv514514";
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		try{
			  //STEP 2: Register JDBC driver
			  Class.forName("com.mysql.jdbc.Driver");

			  //STEP 3: Open a connection
			  System.out.println("Connecting to database...");
			  conn = DriverManager.getConnection(DB_URL,USER,PASS);
			  
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
			  sql="select * from Applications where ApplicantId=?";
			  
	
			 
			
			  ps = conn.prepareStatement(sql);
			  ps.setInt(1,ApplicantId);
			  System.out.println("\nProblem: 2");
			 // ps.setDouble(1, minP);
			 // ps.setDouble(2, maxP);
			 // ps.setString(3,type);
			  
			  
			  ResultSet rs = ps.executeQuery();
			  

			  
			 
			 
			  while(rs.next()){
				  int ApartmentId=rs.getInt("ApartmentId");
		        	int Status=rs.getInt("Status");
		        	String ApplicationNumber=rs.getString("ApplicationNumber");
		        	int LeaseTerm= rs.getInt("LeaseTerm");
		        	double Cost=rs.getDouble("Cost");
		        	int AgentId=rs.getInt("AgentId");
		        	String ApplyingDate =rs.getString("ApplyingDate");
		        	int ApplicantId1=rs.getInt("ApplicantId");
		        	String MoveInDate=rs.getString("MoveInDate");
		        	String Notes=rs.getString("Notes");
		        	int CardId=rs.getInt("CardId");
		        	Application application=new Application( ApartmentId, Status,  ApplicationNumber, ApplyingDate, ApplicantId1,  MoveInDate,  LeaseTerm, Cost,  Notes, CardId);	
		        	selectedApplication.add(application);
				  
                  
				 }
		
			  rs.close();
			  stmt.close();
			  ps.close();
			  conn.close();
			}catch(SQLException se){
			  //Handle errors for JDBC
			  se.printStackTrace();
			}catch(Exception e){
			  //Handle errors for Class.forName
			  e.printStackTrace();
			}finally{
			  //finally block used to close resources
			  try{
			     if(ps!=null)
			        ps.close();
			  }catch(SQLException se2){
			  }// nothing we can do
			  try{
			     if(conn!=null)
			        conn.close();
			  }catch(SQLException se){
			     se.printStackTrace();
			  }//end finally try
			}//end try
		session.setAttribute("selectedApplication", selectedApplication);
		String address = "ManageApplication.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
		   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
