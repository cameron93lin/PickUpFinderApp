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
<c:set var="count" value="0"/>
<h1>Manage Your Applications</h1>
	<form action= "CancelApplication" method="post">
   <table >
   <tr>
   <th>ApplicationNumber </th>
   <th>Status </th>
   <th>Applying Date </th>
   <th>Move In Date </th>
   <th>Lease Term </th>
   <th>Cost </th>
   <th>Notes </th>
   </tr>
   
   <form action="CancelApplication">
    <c:forEach var="application" items="${selectedApplication}"> 
     
<c:set var="count" value="${count+1}"/>;
   <tr>
   <th>${application.getApplicationNumber()} </th>
   <th>${application.getStatus()} </th> 
   <th>${application.getApplyingDate()}</th> 
   <th>${application.getMoveInDate()}</th> 
    <th>${application.getLeaseTerm()}</th> 
    <th>${application.getCost()}</th> 
    <th>${application.getNotes()}</th> 
    <th><input type=submit name="CancelApp" value="${count}"><th>
   
   </tr>
   

<c:set var="count" value="0"/>;
    

   </c:forEach> 
   </form>
   
   

   </table>
<a href=CustomerHomePage.jsp><button type="button">Home</button></a>

</body>
<style>
table{ border-collapse:collapse;}
table th,table td{ border:1px solid #ccc;}
</style>
</html>