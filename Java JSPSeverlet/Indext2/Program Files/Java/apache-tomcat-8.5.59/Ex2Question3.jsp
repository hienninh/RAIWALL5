<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ex2Question3</title>
<style>
form {
	width: 200px;
	border: 1px solid black;
	padding: 5px;
}
</style>
</head>
<body>
	<h2>Question 3</h2>
	<form action="tableEx2Q3.jsp">
		<p>
			<b>STT:</b>
		</p>
		<input type="number" name="stt"><br>
		<p>
			<b>Tên VXL:</b>
		</p>
		<input type="text" name="name"><br>
		<p>
			<b>Hãng: </b>
		</p>
		<input type="text" name="brand"><br>
		<p>
			<b>Ngày ra mắt</b>
		</p>
		<input type="date" name="date"> <br>
		<p>
			<b>Giá</b>
		</p>
		<input type="text" name="price"><br> <br>

		<button type="submit" name="Submit">Thêm</button>
		<button type="reset" name="Cancel">Hủy</button>

		<!-- 
		<input type="text" name="Tên VXL">
		<p><b>Hang:</b></p>
		<input type="text" name="Hang"><br>
		<p><b>Ngay ra mat:</b></p>
		<input type="time" name="ngay ra mat"><br>
		<p><b>Gia:</b></p>
		<input type="text" name="Gia"><br>
		<input type="submit" value="Them"> <input type="submit" value="Huy"> -->
	</form>
</body>
</html>