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
		<label for="job">����</label>
		<select id="job" name="job" size='1'>
			<option value="">�����ϼ���</option>
			<option value="�л�">�л�</option>
			<option value="��ǻ��/���ͳ�">��ǻ��/���ͳ�</option>
			<option value="���">���</option>
			<option value="������">������</option>
			<option value="����">����</option>
			<option value="���񽺾�">���񽺾�</option>
			<option value="����">����</option>
			
		</select>
	</span>
	
	
	<label for="interest" style="float: letf;">���ɺо�</label>
		<select id="interest" name="interest" size='5' multiple="multiple">

			<option value="���">���</option>
			<option value="ķ��">ķ��</option>
			<option value="������">������</option>
			<option value="�">�</option>
			<option value="����">����</option>
		</select>
		<br><br>
		
		<input type="submit" value="����" style="float: right; margin-right=50px">
</form>

</body>
</html>