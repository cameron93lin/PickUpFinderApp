<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Cancellation Confirm!</h1>
<th>Congratulation! Your application has been cancelled.</th><br>
<th>Your Refund Amount is ${cancelApplication.getCost()}
<form name=form1 action="CustomerHomePage.jsp">

<input type=submit value="Home"><br>
<a href="ManageApplication.jsp"> Manage Application<br>
<a href="Welcome.jsp"> Logout
</form>
</body>
</html>