package lecture464.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DataBase {

	public static final String url = "jdbc:mysql://cse.unl.edu:3306/tiwang";
	public static final String username = "tiwang";
	public static final String password = "Zxcv514514";
	
	public static void DatabaseRegister(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			System.out.println("InstantiationException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
	Connection conn = null;
	

	try {
		conn = DriverManager.getConnection(DataBase.url, DataBase.username, DataBase.password);//connect the database
	} catch (SQLException e) {
		System.out.println("SQLException: ");
		e.printStackTrace();
		throw new RuntimeException(e);
	} 
	
  }
	
	public static void DatabaseRelease(ResultSet rs, Statement st, Connection conn){
		
	
		 try {
			   if (rs != null) {
			    rs.close();
			   }
			  } catch (SQLException e) {
			   e.printStackTrace();
			  } finally {
			   try {
			    if (st != null) {
			     st.close();
			    }
			   } catch (SQLException e) {
			    e.printStackTrace();
			   } finally {
			    try {
			     if (conn != null) {
			      conn.close();
			     }
			    } catch (SQLException e) {
			     e.printStackTrace();
			    }
			   }
	}
	
	}
}

