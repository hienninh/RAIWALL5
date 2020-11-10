<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thông tin học sinh</title>
<style>
form {
	width: 200px;
	border: 1px solid black;
	padding: 5px;
}
</style>
</head>
<body>
	<form action="tableEx2Q6.jsp">
		<p>
			<b>STT</b>
		</p>
		<input type="number" name="stt"><br>
		<p>
			<b>Họ và tên</b>
		</p>
		<input type="text" name="name"><br>
		<p>
			<b>Năm sinh</b>
		</p>
		<input type="date" name="birthday"><br>
		<p>
			<b>Giới tính</b>
		</p>
		<input type="radio" name="gender" value="Nam">Nam <input
			type="radio" name="gender" value="Nu">Nu<br>
		<p>
			<b>Số điện thoại</b>
		</p>
		<input type="text" name="sđt"><br> <br>

		<button type="submit" name="Submit">Thêm</button>
		<button type="reset" name="cancel">Hủy</button>
	</form>

</body>
</html>