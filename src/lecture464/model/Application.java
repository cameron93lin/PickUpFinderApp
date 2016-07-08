package lecture464.model;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class Application {
	public int ApartmentId;
	public int Status;
	public String ApplicationNumber;
	public String ApplyingDate;
	public int ApplicantId;
	public String MoveInDate;
	public int LeaseTerm;
	public double Cost;
	public String Notes;
	public int CardId;
	
	public Application(int ApartmentId, int Status, String ApplicationNumber,String ApplyingDate,
			int ApplicantId, String MoveInDate, int LeaseTerm,
			double Cost, String Notes, int CardId) {
		super();
		this.ApartmentId = ApartmentId;
		this.Status = Status;
		this.ApplicationNumber = ApplicationNumber;
		this.ApplyingDate = ApplyingDate;
		this.ApplicantId = ApplicantId;
		this.MoveInDate = MoveInDate;
		this.LeaseTerm = LeaseTerm;
		this.Cost = Cost;
		this.Notes = Notes;
		this.CardId=CardId;
	}



	public int getApartmentId() {
		return ApartmentId;
	}



	public void setApartmentId(int apartmentId) {
		ApartmentId = apartmentId;
	}



	public int getStatus() {
		return Status;
	}



	public void setStatus(int status) {
		Status = status;
	}



	public String getApplicationNumber() {
		return ApplicationNumber;
	}



	public void setApplicationNumber(String applicationNumber) {
		ApplicationNumber = applicationNumber;
	}



	public String getApplyingDate() {
		return ApplyingDate;
	}



	public void setApplyingDate(String applyingDate) {
		ApplyingDate = applyingDate;
	}



	public int getApplicantId() {
		return ApplicantId;
	}



	public void setApplicantId(int applicantId) {
		ApplicantId = applicantId;
	}



	public String getMoveInDate() {
		return MoveInDate;
	}



	public void setMoveInDate(String moveInDate) {
		MoveInDate = moveInDate;
	}



	public int getLeaseTerm() {
		return LeaseTerm;
	}



	public void setLeaseTerm(int leaseTerm) {
		LeaseTerm = leaseTerm;
	}



	public double getCost() {
		return Cost;
	}



	public void setCost(double cost) {
		Cost = cost;
	}



	public String getNotes() {
		return Notes;
	}



	public void setNotes(String notes) {
		Notes = notes;
	}



	public void addApplications(){
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
		  
		  ArrayList<Application> applicationList=new ArrayList<Application>();
		  String sql="INSERT INTO Applications(ApartmentId,Status,ApplicationNumber,ApplyingDate,ApplicantId,MoveInDate,LeaseTerm,Cost,Notes,CardId) VALUES (?,?,?,?,?,?,?,?,?,?)";
		  ps = conn.prepareStatement(sql);
		  ps.setInt(1,ApartmentId);
		  ps.setInt(2,Status);
		  ps.setString(3,ApplicationNumber);
		  ps.setString(4,ApplyingDate);
		  ps.setInt(5,ApplicantId);
		  ps.setString(6,MoveInDate);
		  ps.setInt(7,LeaseTerm);
		  ps.setDouble(8,Cost);
		  ps.setString(9,Notes);
		  ps.setInt(10, CardId);
		  ps.executeUpdate();
		  
		  
		}catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		DataBase.DatabaseRelease(rs, stmt, conn);
    	}
	}
	
	public void removeApplication(){
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
		  String sql="select * from CreditCards where id=? ";
		  ps = conn.prepareStatement(sql);
		  ps.setInt(1, CardId);
		  rs=ps.executeQuery();
		  if(rs.next()){
			  double balance=rs.getDouble("Balance");
			  if(Status==0){
				  balance=balance+Cost;
				  String com="UPDATE CreditCards set Balance=? where Id = ?";
				  ps = conn.prepareStatement(com);
				  ps.setDouble(1, balance);
				  ps.setInt(2, CardId );
				  ps.executeUpdate();
			  }
			  
		  }
		}catch(SQLException e){
    		e.printStackTrace();
    	}finally{
    		DataBase.DatabaseRelease(rs, stmt, conn);
    	}
	}
}
