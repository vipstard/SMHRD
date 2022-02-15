<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body bgcolor="red">
이 파일은 red.jsp입니다 <br>
브라우저에 배경색이 빨간색으로 나타날까요? <br>
노란색으로 나타날까요 ? <hr>
forward  액션 태그가 실행되면 이 페이지의 내용은 출력되지 않습니다. <br>
<jsp:forward page = "08_yellow.jsp" />
</body>
</html>