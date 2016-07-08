package lecture464.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;



public class Users {
	public int Id=0;
	public String firstName = null;
	public String lastName = null;
	public String address = null;
	public String city = null;
	public String state = null;
	public String postalCode = null;
	public String emailAddress=null;
	public String phoneNumber = null;
	public String birthday=null;
	public String userName = null;;
	public String password = null;
	
	
	
	public void registerUser(Users aUser, String propFilePath) {
		
		
	}
	
	 public Users(int id, String firstName, String lastName, String address,
			String city, String state, String postalCode, String emailAddress,
			String phoneNumber, String birthday, String userName,
			String password) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.userName = userName;
		this.password = password;
	}
	 

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void validateUser(Users aUser, String propFilePath) {}
	// public void removeUser(Users aUser, String propFilePath) {}
	
	
}