<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thong tin Employee</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid #dddddd;
	text-align: left;
}
</style>
</head>
<body>
	<h2>Bang thong tin Employee</h2>

	<%
		String id = request.getParameter("stt");
	int number = Integer.parseInt(id);
	String TXL = request.getParameter("name");
	String hang = request.getParameter("brand");

	/* parse từ dạng String sang date */
	String startDateStr = request.getParameter("date");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date startDate = sdf.parse(startDateStr);
	String gia = request.getParameter("price");
	%>
	<!-- Cach viet ngan gon 
Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
-->
	<table>
		<tr>
			<th>STT</th>
			<th>Ten VXL</th>
			<th>Hang sx</th>
			<th>Ngay ra mat</th>
			<th>Gia(VND)</th>
		</tr>
		<tr>
			<td><%=number%></td>
			<td><%=TXL%></td>
			<td><%=hang%></td>
			<td><%=startDate%></td>
			<td><%=gia%></td>
		</tr>
	</table>
</body>
</html>