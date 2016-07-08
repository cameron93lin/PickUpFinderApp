<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.io.*,java.util.*"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.util.ArrayList" %>




   <h1> Your shopping cart</h1>
  <form action=remove>
   <table >
  
   <tr>
   <th>Landlord </th>
   <th>Address </th>
   <th>Apartment Type </th>
   <th>Bathrooms </th>
   <th>Area </th>
   <th>Price </th>
   <th>remove </th>
   
   </tr>
    <c:forEach var="apartment" items= "${selectedApartmentList}" varStatus="count"> 
     
   <tr>
   <th>${apartment.getLandlord()} </th>
   <th>${apartment.getApartmentAddress()} </th> 
   <th>${apartment.getAptType()}</th> 
   <th>${apartment.getBathrooms()}</th> 
   <th>${apartment.getArea()}</th> 
   <th>${apartment.getPricePerMonth()}</th> 
   <th><input type=submit name="remove" value="${count.count}"><th>
   </tr>
   </c:forEach> 
   </table>
   </form>
  
  
  
   <form action=Applyandview>
   <input type=submit value="check out"> <br>
   </form>
   <a href=ManageApplication.jsp><button type="button">Manage Applications</button></a>
   <a href=Welcome.jsp><button type="button">Logout</button></a> 
   <th><a href=CustomerHomePage.jsp><button type="button">continue shopping</button></a></th>
   
   
   

   
</body>

<style>
table{ border-collapse:collapse;}
table th,table td{ border:1px solid #ccc;}
</style>
</html>