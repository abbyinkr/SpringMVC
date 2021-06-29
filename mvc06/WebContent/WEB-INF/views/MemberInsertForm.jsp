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
<title>MemberInsertForm.jsp</title>
</head>
<body>

<div>
	<h1>회원 등록</h1>
	<hr />
</div>

<div>
	<form action="memberinsert.action" id="memberForm">
		<table>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" id="id"/>	<!-- MemberDTO 의 속성값과 name 의 속성값 일치하게 구성!! -->
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="text" name="pw" id="pw"/>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" id="name"/>
				</td>
			</tr>
			<tr>
				<td>전화</td>
				<td>
					<input type="text" name="tel" id="tel"/>
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input type="text" name="email" id="email"/>
				</td>
			</tr>
			<tr>
			<td colspan="2">
				<button type="submit">추가</button>
				<button type="button" onclick="location.href='memberlist.action'">회원 명단</button>
				
			</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>