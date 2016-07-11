<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC Web Application</title>
</head>
<body>

<h1> Apartment Finder Web Application</h1>
<h2> Login here</h2>

<form action	=Login method="POST" onsubmit="return validate(this)">

User Name: <input type=text name=userName id="userName"><br>
Password: <input type=password name=password id="password"><br>
<input type=submit value=Login> <br> 

</form>

<br>
<br>

<!-- Navigation links --> 
<a href="Register.jsp"> Are you a New User? </a> <br>

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