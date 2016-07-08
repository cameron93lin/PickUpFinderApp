package lecture464.model;

public class Apartment {
	public int    ApartmentId=0;
	public String landLord=null;
	public String aptNumber=null;
	public String aptType=null;
	public String apartmentAddress=null;
    public String City=null;
    public String State=null;
    public String area=null;
	public String bathrooms=null;
	public double pricePerMonth=0;
	public double ApplicationFee=0;
	public double DamageDeposit=0;
	public String Description=null;
	public int Availability=0;
	public String AvailableDate = null;
	public int AgentId=0;
	public int leaseLength=0;
	public double totalfee=0;
	
	
	public Apartment(){}


	public Apartment(int apartmentId, String landlord, String aptNumber,
			String aptType, String apartmentAddress, String city, String state,
			String area, String bathrooms, double pricePerMonth,
			double applicationFee, double damageDeposit, String description,
			int availability, String availableDate, int agentId) {
		super();
		this.ApartmentId = apartmentId;
		this.landLord = landlord;
		this.aptNumber = aptNumber;
		this.aptType = aptType;
		this.apartmentAddress = apartmentAddress;
		this.City = city;
		this.State = state;
		this.area = area;
		this.bathrooms = bathrooms;
		this.pricePerMonth = pricePerMonth;
		this.ApplicationFee = applicationFee;
		this.DamageDeposit = damageDeposit;
		this.Description = description;
		this.Availability = availability;
		this.AvailableDate = availableDate;
		this.AgentId = agentId;
	}


	public int getApartmentId() {
		return this.ApartmentId;
	}


	public void setApartmentId(int apartmentId) {
		this.ApartmentId = apartmentId;
	}


	public String getLandlord() {
		return this.landLord;
	}


	public void setLandlord(String landlord) {
		this.landLord = landlord;
	}


	public String getAptNumber() {
		return this.aptNumber;
	}


	public void setAptNumber(String aptNumber) {
		this.aptNumber = aptNumber;
	}


	public String getAptType() {
		return this.aptType;
	}


	public void setAptType(String aptType) {
		this.aptType = aptType;
	}


	public String getApartmentAddress() {
		return this.apartmentAddress;
	}


	public void setApartmentAddress(String apartmentAddress) {
		this.apartmentAddress = apartmentAddress;
	}


	public String getCity() {
		return this.City;
	}


	public void setCity(String city) {
		this.City = city;
	}


	public String getState() {
		return this.State;
	}


	public void setState(String state) {
		this.State = state;
	}


	public String getArea() {
		return this.area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getBathrooms() {
		return this.bathrooms;
	}


	public void setBathrooms(String bathrooms) {
		this.bathrooms = bathrooms;
	}


	public double getPricePerMonth() {
		return this.pricePerMonth;
	}


	public void setPricePerMonth(double pricePerMonth) {
		pricePerMonth = pricePerMonth;
	}


	public double getApplicationFee() {
		return ApplicationFee;
	}


	public void setApplicationFee(double applicationFee) {
		ApplicationFee = applicationFee;
	}


	public double getDamageDeposit() {
		return DamageDeposit;
	}


	public void setDamageDeposit(double damageDeposit) {
		DamageDeposit = damageDeposit;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public int getAvailability() {
		return Availability;
	}


	public void setAvailability(int availability) {
		Availability = availability;
	}


	public String getAvailableDate() {
		return AvailableDate;
	}


	public void setAvailableDate(String availableDate) {
		AvailableDate = availableDate;
	}


	public int getAgentId() {
		return AgentId;
	}


	public void setAgentId(int agentId) {
		AgentId = agentId;
	}
	

	public int getleaseLength() {
		return this.leaseLength;
	}


	public void setleaseLength(int LeaseLength) {
		this.leaseLength = LeaseLength;
	}
	
	public void calculateTotalfee(){
		this.totalfee= this.pricePerMonth*this.leaseLength+ this.ApplicationFee+this.DamageDeposit;
	}
	public double getTotalfee(){
		calculateTotalfee();
		return this.totalfee;
	}
	public double getRent(){
		return this.pricePerMonth*this.leaseLength;
	}
	
	

}
