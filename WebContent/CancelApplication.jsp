<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Cancel Application</h1>
Do you really want to cancel the Application?<br>

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
   
  
   <tr>
   <th>${cancelApplication.getApplicationNumber()} </th>
   <th>${cancelApplication.getStatus()} </th> 
   <th>${cancelApplication.getApplyingDate()}</th> 
   <th>${cancelApplication.getMoveInDate()}</th> 
    <th>${cancelApplication.getLeaseTerm()}</th> 
    <th>${cancelApplication.getCost()}</th> 
    <th>${cancelApplication.getNotes()}</th> 
   
   
   </tr>
   

    


   
  
   

   </table>

<form  action="CancelConfirm" method="post">
<input type=submit value="Confirm Cancellation">
</form>
<a href=ManageApplication.jsp><button type="button">Discard Cancel</button></a><br>

<a href="ManageApplication.jsp"> Manage Your Applications<br>
<a href="Welcome.jsp"> Logout



</body>
<style>
table{ border-collapse:collapse;}
table th,table td{ border:1px solid #ccc;}
</style>
</html>