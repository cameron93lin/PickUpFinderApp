<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
<h1> Welcome to the Home Page</h1>
<h2> Please Enter the requirement</h2>

<form action	=AppartmentSearchQuery   onsubmit="return validate(this)">
Moving Date: <input type=text name=movingDate id="movingDate"> (MM/DD/YYYY) <br>
Range of Price: <input type=text name=minPrice id="minPrice"> To <input type=text name=maxPrice id="maxPrice"> <br>
City: <input type=text name=City id="City"><br>
Apartment Type:<select name=type>
	<option value="Studios">Studios</option>
	<option value="1b">1 Bedroom</option>
	<option value="2b">2 Bedroom</option>
	<option value="3b">3 Bedroom</option>
	</select>
	<br>
	
<input type=submit value=Search> <br> 
<br>
<br>

<!-- Navigation links --> 
<a href="ManageApplication.jsp"> Manage Application</a> <br>
<a href="ShoppingCart.jsp"> check your shopping cart</a> <br>
<a href="Welcome.jsp"> Logout</a> <br>


</form>


</body>
<script>

function validate(form)
{
 if (form.movingDate.value == ""||form.movingDate.value==null)
 {
 alert("Please fill in your moving date");
 form.movingDate.focus();
 return false;
 }
 else if (form.minPrice.value == "" ||form.minPrice.value==null)
 {
 alert("Please fill in your minimum price");
 form.minPrice.focus();
 return false;
 }
 else if (form.maxPrice.value == "" ||form.maxPrice.value==null)
 {
 alert("Please fill in your max price");
 form.maxPrice.focus();
 return false;
 }
 else if (form.City.value == "" ||form.City.value==null)
 {
 alert("Please fill in your city");
 form.City.focus();
 return false;
 }
 else
 {
 return true;
 }
}
</script>
</html>