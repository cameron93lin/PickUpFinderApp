package lecture464.model;

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

import javax.servlet.http.HttpSession;

public class Bank {
	public String cardNumber;
	public String cardType;
	public String securityCode;
	public String exDate;
	public String firstName;
	public String lastName;
	public String CardholderName;
	public int validate=-1;
	public double balance=0;
	public double totalFee;
	public int CardId;
	public int AId=0;
	public Bank (String cardNumber, String cardType, String securityCode, String exDate, String CardholderName, double totalFee){
		super();
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.securityCode = securityCode;
		this.exDate = exDate;
		this.CardholderName=CardholderName;
		this.validate=validate;
		this.totalFee=totalFee;
	}

	public void verifation (){
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try{
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
		  String sql="select * from CreditCards where CardholderName=? and CreditCardNumber=? and CardType=? and CVV=? and ExpirationDate=?";
		  ps = conn.prepareStatement(sql);
		  ps.setString(1, CardholderName);
		  ps.setString(2, cardNumber);
		  ps.setString(3,cardType);
		  ps.setString(4, securityCode);
		  ps.setString(5, exDate);
		  
		  rs = ps.executeQuery();
		  
		  if(rs.next()){
			  double tempbalance=0;
			  tempbalance=rs.getDouble("Balance");
			  if(totalFee>tempbalance){
				  validate=1;
			  }
			  else{
				  validate=0;
				  balance=tempbalance-totalFee;
				  String com="UPDATE CreditCards set Balance=? where CreditCardNumber = ?";
				  ps = conn.prepareStatement(com);
				  ps.setDouble(1, balance);
				  ps.setString(2, cardNumber );
				  ps.executeUpdate();
				  CardId=rs.getInt("Id");
				  com="UPDATE Apartments set Availability=0 where Id = ?";
				  ps = conn.prepareStatement(com);
				  ps.setInt(1,getAId());
				  ps.executeUpdate();
			  }
			 
		  }
		  else{
			  validate=2;
		  }
    	}catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		DataBase.DatabaseRelease(rs, stmt, conn);
    	}
		
	}
	
	public int getValidate(){
		return validate;
	}
	
	public int getCardId(){
		return CardId;
	}
	public void setAId(int id)
	{
		this.AId=id;
		
	}
	public int getAId(){
		return this.AId;
	}
}