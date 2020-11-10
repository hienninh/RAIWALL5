<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Lesson1</title>
</head>
<body>
	<!-- Exercise 1 
Question1.a-->

	<%-- <h1>Hello World</h1>
	<br>
	<br>
	<!--Question1.b  -->
	<%
		out.print("Welcome to jsp");
	%>
	<br>
	<br> --%>
	<!-- Question2 -->
<%-- 	Current time:
	<%=java.util.Calendar.getInstance().getTime()%>
	<br>
	<br> --%>
	<!-- Question3 -->
<%-- 	<%!String name = "Hien";%>

	<%="Hello " + name%>
	<br>
	<br>
	<%@ page import="java.util.Date"%>
	Today is:
	<%=new Date()%>
	<br>
	<br> --%>
	
<!--Demo include  -->
<%-- <%@ include file="header.html" %>
<%@ include file="footer.html" %> --%>

<br> <br>

<!-- Question5 -->
<form action="header.jsp">
<input type="text" name="uname">
<input type="submit" value="submit">
<br>
</form>

</body>
</html>