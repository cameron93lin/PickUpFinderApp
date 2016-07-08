<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC Web Application</title>
</head>

<body>

<h1> A Simple MVC Web Application</h1>
<h2> Register here</h2>

<form action=Register method="POST" onsubmit="return validate(this)" >

User Name: <input type=text name=userName id="userName"><br>
Password: <input type=password name=password id="password"><br>
First Name: <input type=text name="firstName" ><br>
Last Name: <input type=text name="lastName" ><br>
address: <input type=text name="address" ><br>
city: <input type=text name="city" ><br>
state: <input type=text name="state" ><br>
Postal code: <input type=text name="postalCode" ><br>
Email Address: <input type=text name="emailAddress" ><br>
Phone Number: <input type=text name="phoneNumber" ><br>
Birtyday(YYYYMMDD): <input type=text name="birthday" ><br>

<input type=submit value=Register> <br> 

</form>
<br>
<br>

<!-- Navigation links --> 
<a href="Welcome.jsp"> Home Page </a> <br>


</body>
<script>

function validate(form)
{
 if (form.userName.value == ""||form.userName.value==null)
 {
 alert("Please fill in your username");
 form.userName.focus();
 return false;
 }
 else if (form.password.value == "" ||form.password.value==null)
 {
 alert("Please fill in your password");
 form.password.focus();
 return false;
 }
 else
 {

 return true;
 }
}
</script>
</html>