<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send.jsp</title>
</head>
<body>
<div>
	<h1>Spring MVC 데이터 송수신 실습</h1>
	<hr>
</div>

<div>
	<!-- <form action="ReceiveController.java"> --> <!-- 이렇게 쓰면 안된다! -->
	<form action="receive.do"> <!-- 요청할 url 주소 -->
		이름 <input type="text" name="userName" />
		<button type="submit">submit</button>
	</form>
</div>

</body>
</html>