<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Danh sach hoc sinh</title>
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
	<h2>Danh sách học sinh</h2>
	<%
	/* Convert int thành string */
	String id = request.getParameter("stt");
	int number= Integer.parseInt(id);
	
	String name = request.getParameter("name");

	/* parse từ dạng String sang date */
	String birthdayStr = request.getParameter("birthday");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date birthday = sdf.parse(birthdayStr);
	
	/* Cach lay gender */
	String gender1 = request.getParameter("gender");
	if(gender1.equals("Nam")) {
		//Do action
	}
	else if(gender1.equals("Nu")){
		//Do action other
	}
	
	String phone = request.getParameter("sđt");
	%>
	
	<table>
	<tr>
	<th>STT</th>
	<th>Họ tên</th>
	<th>Năm sinh</th>
	<th>Giới tính</th>
	<th>Số điện thoại</th>
	</tr>
	<tr>
	<td><%=number %></td>
	<td><%=name %></td>
	<td><%=birthday %></td>
	<td><%=gender1 %></td>
	<td><%=phone %></td>
	</tr>
	</table>
</body>
</html>