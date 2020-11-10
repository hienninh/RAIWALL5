<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Question6:  -->
	<%@ page errorPage="error.jsp"%>
	<%
	String a = "10";
	String b = "Hien";
	int number1 = Integer.parseInt(a);
	int number2 = Integer.parseInt(b);
	out.print(number2);
	%>
</body>
</html>