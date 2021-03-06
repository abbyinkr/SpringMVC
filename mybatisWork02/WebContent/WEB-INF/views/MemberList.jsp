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
<title>MemberList.jsp</title>

<!-- 부트스트랩 css -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 제이쿼리 script -->
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>

<!-- 부트스트랩 script -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
 
	$(function()
	{
		$(".btnDelete").click(function()
		{
			if (confirm("정말 삭제하시겠습니까?")) 
			{
				$(location).attr("href", "memberdelete.action?mid=" + $(this).val());
			}
		});
		
		$(".btnUpdate").click(function()
		{
			$("#title").html("회원 정보 수정").css({"color":"red", "font-weight":"bold"});
			
			var mid = $(this).parents("tr").find("td:eq(0)").text(); // <td>${member.mid }</td> 
			var name = $(this).parents("tr").find("td:eq(1)").text();
			var telephone = $(this).parents("tr").find("td:eq(2)").text();
			
			$("#mid").val(mid);
			$("#name").val(name);
			$("#telephone").val(telephone);
			
			// form(단독이기때문에 인덱스 생략) 의 속성 action 값 변경
			$("form").attr("action", "memberupdate.action");
			
		});
		
		$(".btnCancel").click(function()
		{
			$("#title").html("회원 정보 입력").css({"color":"black", "font-weight":"normal"});
			
			$("form").attr("action", "memberinsert.action");
			
			
		});

		
	
	
	});
	

</script>
	
</head>
<body>

<div>
	<h1>회원 정보</h1>
	<hr />
</div>

<div class="container">
	<div class="panel-group">
		<div class="panel-default">
			<div class="panel-heading" id="title">
			회원 정보 입력
			</div>
			
			<div class="panel-body">
				<!-- 수정버튼 클릭시 action="memberupdate.action" 로 변경됨  -->
				<form role="form" action="memberinsert.action" method="post">
					
					<!-- check~!! 히든 엘리먼트 추가 -->
					<input type="hidden" id="mid" name="mid"/>
				
					<div class="form-group">
						<label for="name">
						NAME : 
						</label>
						<input type="text" class="form-control" id="name" name="name"/>
					</div>
				
					<div class="form-group">
						<label for="telephone">
						TELEPHONE :
						</label>
						<input type="tel" class="form-control" id="telephone" name="telephone"/>
					</div>
				
					<button type="submit" class="btn btn-success btn-sm">SUBMIT</button>
					<button type="reset" class="btn btn-success btn-sm btnCancel">CANCEL</button>
				
				</form>
			</div>
		</div><!-- close . panel-default -->
		
		<div class="panel panel-default">
			<div class="panel-headling">
				
			</div>
			
			<div class="panel-body">
				회원 정보 출력
				<table class="table">
					<thead>
						<tr>
							<th>MID</th>
							<th>NAME</th>
							<th>TELEPHONE</th>
							<th>삭제 / 수정</th>
						</tr>
					</thead>
					<tbody>
						<!-- 					
						<tr>
							<td>1</td>
							<td>전혜림</td>
							<td>010-1111-1111</td>
							<td>
								<button type="button" class="btn btn-default btn-xs btnDelete">삭제</button>
								<button type="button" class="btn btn-default btn-xs btnUpdate">수정</button>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>선혜연</td>
							<td>010-2222-2222</td>
							<td>
								<button type="button" class="btn btn-default btn-xs btnDelete">삭제</button>
								<button type="button" class="btn btn-default btn-xs btnUpdate">수정</button>
							</td>
						</tr>
						 -->
						 
						<c:forEach var="member" items="${list }">
						<tr>
							<td>${member.mid }</td> <!-- td:eq(0) -->
							<td>${member.name }</td> <!-- td:eq(1) -->
							<td>${member.telephone }</td>
							<td>
								<button type="button" class="btn btn-danger btn-xs btnDelete"
								 value="${member.mid }">삭제</button>
								<button type="button" class="btn btn-primary btn-xs btnUpdate"
								 value="${member.mid }">수정</button>
							</td>
						</tr>
						
						</c:forEach>
						 
					</tbody>
				</table>

			<button type="button" class="btn btn-default btn-sm">
				Count <span class="badge">${count }</span>
			</button>

			</div>
			
		</div>
		
	</div>
</div>

</body>
</html>