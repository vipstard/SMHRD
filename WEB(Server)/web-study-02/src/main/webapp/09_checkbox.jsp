<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>악세사리</h2>
관심항목을 선택하세요.<hr>
<form method="get" action="CheckboxServlet">
	<input type="checkbox" name="item" value="신발"> 신발
	<input type="checkbox" name="item" value="가방"> 가방
	<input type="checkbox" name="item" value="벨트"> 벨트
	<input type="checkbox" name="item" value="모자"> 모자
	<input type="checkbox" name="item" value="시계"> 시계
	<input type="checkbox" name="item" value="쥬얼리"> 쥬얼리
	<input type="submit" value="전송"> 
	
</form>

</body>
</html>