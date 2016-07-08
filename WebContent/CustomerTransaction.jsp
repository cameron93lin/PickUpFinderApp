<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
      <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
		</script>

<script>

function update_history_func(){
	var CardNumber=$("#cardNumber").val();
	var CardType=$("#cardType").val();
	var SecurityCode=$("#securityCode").val();
	var InputDatetime=$("#inputDatetime").val();
	var FirstName=$("#firstName").val();
	var LastName=$("#lastName").val();
	
	$("#result").html("<html> \n" + "<body> \n" +"<p>" +" Your Card is Valid!!</p> \n" +"</body> \n" + "</html>");
	$.post("ApplicationUpdate",{cardNumber:CardNumber, cardType:CardType, securityCode:SecurityCode, inputDatetime:InputDatetime, firstName:FirstName, lastName:LastName}, function(data,status){
	});
}

function confirm_func(){
	var CardNumber=$("#cardNumber").val();
	var CardType=$("#cardType").val();
	var SecurityCode=$("#securityCode").val();
	var InputDatetime=$("#inputDatetime").val();
	var FirstName=$("#firstName").val();
	var LastName=$("#lastName").val();
	
	$.post("BankServlet",{cardNumber:CardNumber, cardType:CardType, securityCode:SecurityCode, inputDatetime:InputDatetime, firstName:FirstName, lastName:LastName}, function(data,status){
		
		if(data==1){
			
			//update_history_func();
			$("#result").html("<html> \n" + "<body> \n" +"<p>" +" Your Card is Valid!!</p> \n" +"</body> \n" + "</html>");
			$.post("ApplicationUpdate",{cardNumber:CardNumber, cardType:CardType, securityCode:SecurityCode, inputDatetime:InputDatetime, firstName:FirstName, lastName:LastName}, function(data1,status1){
			});
		}
		else {
			$("#result").html("<html> \n" + "<body> \n" +"<p>" +" Your Card is invalid!!</p> \n" +"</body> \n" + "</html>")
		}
	});
		
	}
</script>


</head>

<body>



  
  
   
   
Application fee: ${appFee}<br>
Damage Deposit: ${damageFee}<br>
Rent: ${rent}<br>
Total: ${totalFee}<br>
<br>
<br>
   




<h2>Please enter your payment information</h2>

Card Number: <input id="cardNumber" type=text name=cardNumber>  <br>
Card Type:<select id="cardType" name=cardType>
	<option value="Visa">Visa</option>
	<option value="Master">Master</option>
	<option value="Discover">Discovery</option>
	</select>
	<br>
Security code: <input id="securityCode" type=password name=securityCode><br>	`  
Expiration Date: <input id="inputDatetime" name="" class="" type="text">(MMYYYY)<br>
Name: First Name<input id="firstName" type=text name=firstName> Last Name <input id="lastName" type=text name=lastName> <br>
Billing Address: <input type=text name=bAddress><br>

<input type="button" value="Confirm" onClick="confirm_func()"> <br> 

<br>
<br>

<!-- Results will be displayed here -->
<p id="result"></p>

<a href=ApartmentSearchResult.jsp><button type="button">Cancel Payment</button></a><br>

<br>
<br>

<!-- Navigation links --> 
<a href="Welcome.jsp"> Logout</a> <br>
<a href="ManageApplication.jsp"> Manage Application </a> <br>
<a href="ShoppingCart.jsp"> check your shopping cart</a> <br>


   
</body>
<style>
table{ border-collapse:collapse;}
table th,table td{ border:1px solid #ccc;}
</style>


</html>