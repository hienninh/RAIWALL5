<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<%
	/* Convert string thanh float */
		/*  String a1= request.getParameter("number1");
	float a = Float.parseFloat(a1) */
	float a = Float.parseFloat(request.getParameter("number1"));
	float b = Float.parseFloat(request.getParameter("number2"));
	String tinhtoan = request.getParameter("tinhtoan");
	

	if(tinhtoan.equals("cong")){
		float cong = a + b;
		out.print("Tổng cộng 2 số là: " + cong);
	}
	 if (tinhtoan.equals("tru")){
		float tru = a-b;
		out.print("Hiệu của 2 số là: " + tru);
	}
	 if (tinhtoan.equals("nhan")){
		float nhan = a*b;
		out.print("Phép nhân của 2 số là: " + nhan);
	}
	 if (tinhtoan.equals("chia")){
		float chia = a/b;
		out.print("Thương của 2 số là: " + chia);
	}
	
	%>
</body>
</html>