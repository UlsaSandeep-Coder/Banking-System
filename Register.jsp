
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RS">
<h1><% out.println("**************Please Fill the Details***************"); %></h1><br>
<h1>Enter the Name<input type="text" name="a"></h1><br>
<h1>Enter the Email<input type="text" name="b"></h1><br>
<h1>Enter the Password<input type="password" name="c"></h1><br>
<input type="submit" value="send">

</form>
</body>
</html>