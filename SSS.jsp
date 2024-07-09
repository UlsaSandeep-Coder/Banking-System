<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit</title>
</head>
<body>
<h1>SucessFully Deposited</h1><br>
<h2>BalanceRemaining<% out.print(request.getAttribute("n"));%></h2>
<h1>*****Thank You for Visting*****</h1><br>
<h1><a href="M.jsp">Go to Methods</a></h1>
</body>
</html>