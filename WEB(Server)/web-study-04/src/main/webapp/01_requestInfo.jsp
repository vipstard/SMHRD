<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
���ؽ�Ʈ �н� : <%=request.getContextPath() %> <br>
��û��� : <%=request.getMethod() %> <br>
��û�� URL : <%=request.getRequestURL() %> <br>
��û�� URI : <%=request.getRequestURI() %> <br>
������ �̸� : <%=request.getServerName() %> <br>
�������� : <%=request.getProtocol() %> <br>

</body>
</html>