<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="SelectServlet" style="float:left; margin-right: 20px" method="get">
	<span style="float: left; margin-right: 20px">
		<label for="job">직업</label>
		<select id="job" name="job" size='1'>
			<option value="">선택하세요</option>
			<option value="학생">학생</option>
			<option value="컴퓨터/인터넷">컴퓨터/인터넷</option>
			<option value="언론">언론</option>
			<option value="공무원">공무원</option>
			<option value="군인">군인</option>
			<option value="서비스업">서비스업</option>
			<option value="교육">교육</option>
			
		</select>
	</span>
	
	
	<label for="interest" style="float: letf;">관심분야</label>
		<select id="interest" name="interest" size='5' multiple="multiple">

			<option value="등산">등산</option>
			<option value="캠핑">캠핑</option>
			<option value="자전거">자전거</option>
			<option value="운동">운동</option>
			<option value="게임">게임</option>
		</select>
		<br><br>
		
		<input type="submit" value="전송" style="float: right; margin-right=50px">
</form>

</body>
</html>