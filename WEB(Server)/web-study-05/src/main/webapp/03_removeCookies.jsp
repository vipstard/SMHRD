<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie cookie = new Cookie("id", "");
	cookie.setMaxAge(0); //��Ű�� ��ȿ�Ⱓ�� �����Ŵ
	response.addCookie(cookie);
%>

 <h3> id ��Ű�� ���� �Ǿ����ϴ�.</h3>
 <a href="02_getCookies.jsp"> ��Ű������ Ȯ���Ϸ��� Ŭ���ϼ���</a>

</body>
</html>