package lecture464.servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture464.model.DataBase;
import lecture464.model.Users;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String postalCode = request.getParameter("postalCode");
		String emailAddress=request.getParameter("emailAddress");
		String phoneNumber = request.getParameter("phoneNumber");
		String birthday=request.getParameter("birthday");
		
		/* The users.properties file is stored in the "WEB-INF" folder.
		   To access this file, you will need its absolute path. */
		 
		/* Following two statements are used to obtain the absolute path 
		   of the users.properies file from its relative path. */
		
		
		
		
		boolean existed=false;

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
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
		  
		  
		 
		  sql = "select Username , Password from Users";
		  ps = conn.prepareStatement(sql);
          System.out.println("\nProblem: 2");
		   rs = ps.executeQuery();
		  ArrayList<String> NameList=new ArrayList<String>();
		  ArrayList<String> pwList=new ArrayList<String>();
		  
		  

		  //STEP 5: Extract data from result set
		  while(rs.next()){
			  String Username=rs.getString("Username");
			  String Password=rs.getString("Password");
			  NameList.add(Username);
			  pwList.add(Password);
			    //Retrieve by column name
			   
			 }
		  for(int i=0;i<NameList.size();i++)
		  {
			  if(userName.equals(NameList.get(i)))
			  {
				  existed=true;
			  }
		  }
		  if(existed)
		  {
			  response.sendRedirect("ExistName.jsp");
			
		  }
		  else{
		  sql="INSERT INTO Users (Id, FirstName, LastName,Address, City,State,PostalCode, EmailAddress,PhoneNumber,Birthday,Username, Password) VALUES(?,?,?,?,?,?,?,?,?,?,?,? )";
		  ps = conn.prepareStatement(sql);
		  System.out.println(NameList.size());
		  if(NameList.size()==0)
		  {
			  
			  ps.setInt(1, 1);
			  
		  }
		  else{
			  
			  ps.setInt(1, NameList.size()+1);
		  }
		  ps.setString(2,firstName);
		  ps.setString(3,lastName);
		  ps.setString(4,address);
		  ps.setString(5,city);
		  ps.setString(6,state);
		  ps.setString(7,postalCode);
		  ps.setString(8,emailAddress);
		  ps.setString(9,phoneNumber);
		  ps.setString(10,birthday);
		  ps.setString(11,userName);
		  ps.setString(12,password);
		  ps.executeUpdate();
		  response.sendRedirect("Welcome.jsp");
		 
		  }
		  //STEP 6: Clean-up environment
		 
		}catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		DataBase.DatabaseRelease(rs, stmt, conn);
    	}//end try
		
		
		
		
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
