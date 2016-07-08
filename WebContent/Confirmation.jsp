<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmation</title>
</head>
<body>


<c:choose>
	<c:when test="${validate==0}">
<h1>Your application has been submitted!</h1>
<table >
   <tr>
   <th>Landlord </th>
   <th>Address </th>
   <th>Apartment </th>
   <th>Area </th>
   <th>PricePerMonth </th>
   <th>Total</th>
   </tr>
   <br>
   <tr>
   <th>${selectedApartment.getLandlord()} </th>
   <th>${selectedApartment.getApartmentAddress()} </th> 
   <th>${selectedApartment.getAptType()}</th> 
    <th>${selectedApartment.getArea()}</th> 
    <th>${selectedApartment.getPricePerMonth()}</th> 
    <th>${selectedApartment.getTotalfee()}</th> 
   </tr>
   </table>
   <br>
   <a href=CustomerHomePage.jsp><button type="button">Home</button>
   <br>
   <input type="submit" value="print" onClick="window.print()"/> 
   <br>
   <br>
   <!-- Navigation links --> 
<a href="Welcome.jsp"> Logout</a> <br>

<form action="ApplicationManage" method="post">
<input type=submit value=ApplicationManage> <br>
</form>

	</c:when>
	<c:when test="${validate==1}">
		<h2>Your Balance is Low!</h2>
		<a href=CustomerHomePage.jsp><button type="button">Home Page</button>
	</c:when>
	<c:otherwise>
		<h3>Your Card Information is Invalid!</h3>
		<a href=CustomerHomePage.jsp><button type="button">Home Page</button>
	</c:otherwise>
</c:choose>

</body>
<style>
table{ border-collapse:collapse;}
table th,table td{ border:1px solid #ccc;}
</style>
</html>