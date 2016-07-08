package lecture464.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.DataBase;
import lecture464.model.Users;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		int  Contain=0;
		String uN=null;
		String pW=null;
		HttpSession session=request.getSession();
		
		/* The users.properties file is stored in the "WEB-INF" folder.
		   To access this file, you will need its absolute path. */
		 
		/* Following two statements are used to obtain the absolute path 
		   of the users.properies file from its relative path. */
		
		
		
		

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
		  
		  
		 
		  sql = "select * from Users  ";
		  ps = conn.prepareStatement(sql);
          System.out.println("\nProblem: 2");
		   rs = ps.executeQuery();
		  ArrayList<Users> UserList=new ArrayList<Users>();
		  

		  //STEP 5: Extract data from result set
		  while(rs.next()){
			  int id=rs.getInt("Id");
			  String FirstName=rs.getString("FirstName");
			  String LastName=rs.getString("LastName");
			  String Address=rs.getString("Address");
			  String City=rs.getString("City");
			  String State=rs.getString("State");
			  String PostalCode=rs.getString("PostalCode");
			  String EmailAddress=rs.getString("EmailAddress");
			  String PhoneNumber=rs.getString("PhoneNumber");
			  String Birthday=rs.getString("Birthday");
			  String Username=rs.getString("Username");
			  String Password=rs.getString("Password");
			  Users user=new Users(id,FirstName,LastName,Address, City,State, PostalCode,EmailAddress,
					  PhoneNumber,Birthday, Username, Password);
			  UserList.add(user);
			    //Retrieve by column name
			   
			 }
		  Users loginUser=null;
		  for( int i=0;i<UserList.size();i++){
			  if(userName.equals(UserList.get(i).getUserName()))
			  {
				  Contain=1;
				 loginUser=UserList.get(i);
				  uN=UserList.get(i).getUserName();
				  pW=UserList.get(i).getPassword();
				  break;
			  }
		  }
		  
		 
		  
		  if(Contain==0){
			  response.sendRedirect("Register.jsp");
			  
			 
		  }
		  else if(pW.equals(password))
		  {
			  
			  session.removeAttribute("loginUser");
			  session.setAttribute("loginUser", loginUser);
			  response.sendRedirect("CustomerHomePage.jsp");
			  
			  
		  }
		  else if(!pW.equals(password)){
			  response.sendRedirect("InvaildPassword.jsp");
		  }
		  else{
			  response.sendRedirect("Register.jsp");
		  }
			
		  
		  //STEP 6: Clean-up environment
		 
		}catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		DataBase.DatabaseRelease(rs, stmt, conn);
    	}
		
		
		/* The users.properties file is stored in the "WEB-INF" folder.
		   To access this file, you will need its absolute path. */
		 
		/* Following two statements are used to obtain the absolute path 
		   of the users.properies file from its relative path. */
		/*ServletContext sc = this.getServletContext();
		String propFilePath = sc.getRealPath("/WEB-INF/users.properties");
		
		Properties p = new Properties();
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(propFilePath);
			
			p.load(fis);
				
			// Check whether the username exists or not
			if(!p.containsKey(userName)) {			
				// Link-redirection
				response.sendRedirect("Register.jsp");
			} else { // Check whether the password matches or not
				String pword = p.getProperty(userName);  
				if(!pword.equals(password)) {
					response.sendRedirect("Register.jsp"); // Link-redirection
				} else {
					request.setAttribute("username", userName);
					request.getSession().setAttribute("userName", userName);
					RequestDispatcher dis =getServletContext().getRequestDispatcher("/CustomerHomePage.jsp");		
					dis.forward(request,response);
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis != null) {
				fis.close();
			}
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
