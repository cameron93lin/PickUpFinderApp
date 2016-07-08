<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> View and Apply</h1>


<h2>Apartment Information</h2>
<table >
   <tr>
   <th>ApartmentId: </th>
   <th id="AId">${selectedApartment.getApartmentId()} </th>
   </tr>
   <tr>
   <th>Landlord: </th>
   <th>${selectedApartment.getLandlord()} </th>
   </tr>
   <tr>
   <th>Apartment Number: </th>
   <th>${selectedApartment.getAptNumber()} </th>
   </tr>
    <tr>
   <th>Apartment Type: </th>
   <th>${selectedApartment.getAptType()} </th>
   </tr>
   <tr>
   <th>Apartment Address: </th>
   <th>${selectedApartment.getApartmentAddress()} </th>
   </tr>
   <tr>
   <th>City: </th>
   <th>${selectedApartment.getCity()} </th>
   </tr>
   <tr>
   <th>State: </th>
   <th>${selectedApartment.getState()} </th>
   </tr>
   <tr>
   <th>Area: </th>
   <th>${selectedApartment.getState()} </th>
   </tr>
    <tr>
   <th>Bathrooms: </th>
   <th>${selectedApartment.getBathrooms()} </th>
   </tr>
    <tr>
   <th>Price Per Month: </th>
   <th>${selectedApartment.getPricePerMonth()} </th>
   </tr>
    <tr>
   <th>Application: </th>
   <th>${selectedApartment.getApplicationFee()} </th>
   </tr>
   <tr>
   <th>Damage Deposit: </th>
   <th>${selectedApartment.getDamageDeposit()} </th>
   </tr>
   <tr>
   <th>Damage Deposit: </th>
   <th>${selectedApartment.getDamageDeposit()} </th>
   </tr>
   <tr>
   <th>Description: </th>
   <th>${selectedApartment.getDescription()} </th>
   </tr>
   <tr>
   <th>Availability: </th>
   <th>${selectedApartment.getAvailability()} </th>
   </tr>
   <tr>
   <th>Available Date: </th>
   <th>${selectedApartment.getAvailableDate()} </th>
   </tr>
  
  
   
   
  </table>


<h2>Amenities</h2>
Air Conditioning<br>
Cable or Satellite<br>
Dishwasher<br>
Fireplace<br>
Garbage Disposal<br>
Microwave<br>
Patio or Balcony<br>
Washer and Dryer in Unit<br>
<h2>community features</h2>
Club House<br>
Utility included<br>
Fitness center<br>
Pool<br>
Garages<br>
Smoke free community<br>
Pet friendly<br>
Disability Access<br>


<form action=shopCart>

    Lease length<select name=eMonth>
	<option value="6">six months</option>
	<option value="10">ten months</option>
	<option value="12">twelve months</option>
	
	</select>
	<br>
<input type=submit value="Add to Card"> <br>
 
</form>
 <div id="myDiv">${success}</div>
 <th><a href=ShoppingCart.jsp><button type="button">Check out</button></a></th>



 <th><a href=ApartmentSearchResult.jsp><button type="button">Back</button></a></th>
 <th><a href=CustomerHomePage.jsp><button type="button">Search for a new apartment</button></a></th>
 
</body>
 <script   src="js/jquery-1.6.2.js" type="text/javascript"></script>
<script>

</script>
<style>
table{ border-collapse:collapse;}
table th,table td{ border:1px solid #ccc;}
</style>
</html>