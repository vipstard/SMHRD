<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- JSP ���������� ������ �߻��Ͽ��� �� ������ ���� �������� error.jsp�� ���� --%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
 0���� ������ ���� �Ҵ��Դϴ�.
 <%--������ ���ܸ� �߻���Ŵ --%>
 <%= 2/0 %>

</body>
</html>