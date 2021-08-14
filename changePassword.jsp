<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
<link rel="stylesheet" href="style.css">
	
		<style>body{background-color:#DEEEEA;
	color:#39A6A3;}
	</style>
	
	<script>
	function checkPass()
	{
		password=document.getElementById("password").value;
		confirm_password=document.getElementById("confirm_password").value;
		if(password!=confirm_password)
		{
			document.getElementById("password").value="";
			document.getElementById("confirm_password").value="";
			document.getElementById("res").innerHTML="Password Not Matched.\nTry again..";
			document.getElementById("res").style.color="red";
			return false;
		}
		else
		{
			return true;
		}
	}
	</script>
	
</head>
<body>
<center>
<h1>Change Password</h1>
<form method="post" action="change" onsubmit="return checkPass()">
<table>
	<tr><td>Current Password:
	<td><input type="password" name="cpsw" required></tr>
	
	<tr><td>New Password:
	<td><input type="password" id="password" name="psw" required></tr>
	
	<tr><td>Confirm New Password:
	<td><input type="password" name="npsw" id="confirm_password" required></tr>
	
	<tr><td><h1 id="res"></tr>
	
	</table>
	<input type="submit" class="btn" value="Change">
	</form>
	
	<br><br><a href='signup.html'>Home</a>
	
	</center>
	
</body>
</html>