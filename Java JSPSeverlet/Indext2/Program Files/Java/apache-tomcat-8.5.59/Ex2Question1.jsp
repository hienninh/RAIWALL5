<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Kết quả</title>

</head>
<body>
	<h1>Cộng trừ nhân chia</h1>
	<form action="ketqua1.jsp">

		<p>Số hàng 1</p>
		<input type="number" name="number1"><br>
		<p>Số hàng 2</p>
		<input type="number" name="number2"> <br> <br>
		<button type="radio" name="tinhtoan" value="cong">+</button>
		<button type="radio" name="tinhtoan" value="tru">-</button>
		<button type="radio" name="tinhtoan" value="nhan">x</button>
		<button type="radio" name="tinhtoan" value="chia">/</button>
	</form>
</body>
</html>