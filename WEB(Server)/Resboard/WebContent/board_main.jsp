<%@page import="java.util.ArrayList"%>
<%@page import="com.model.ReplyVO"%>
<%@page import="com.model.BoardVO"%>
<%@page import="com.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap"
	rel="stylesheet">
<style>
body {
	background-image: url('asset/img/bg.jpg');
	padding-left: 200px;
	padding-right: 200px;
	font-family: 'Do Hyeon', sans-serif;
}

.card-body {
	background-color: whitesmoke;
}

p {
	padding-top: 5px;
	padding-left: 20px;
	font-size: 30px;
}
</style>
</head>
<body>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
	
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getOneList(num);
		
		ArrayList<ReplyVO> al = dao.getReply(num);
		System.out.println(al.size());
	%>
	<div class="card-body" style="margin-top: 100px; margin-bottom: 10px; height: 50px">
		<p><%=vo.getName() %> / <%=vo.getWriter() %></p>
	</div>

	<!-- ���, �� ���� -->
	<div id="map" style="width: 100%; height: 350px;">%�����ڸ�%</div>
	
	<!-- ����ۼ� -->
	<div class="card mb-2">
		<div class="card-body">
			<p>���� �� : <%=vo.getContent() %></p>
			<ul class="list-group list-group-flush">
				<li class="list-group-item">
					<textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
					<button type="button" class="btn btn-dark mt-3"onclick="addReply()">post reply</button>
				</li>
			</ul>
			<ul class="list-group list-group-flush" id="reply">
				<%
					for(int i = al.size()-1;i >= 0;i--){
				%>
				<li class="list-group-item"><span><%=al.get(i).getContent() %> / <%=al.get(i).getWriter() %></span></li>
				<%} %>
			</ul>
		</div>
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=dac4065a7a1dada3f8ae562756260926&libraries=services"></script>
	<script>
		function addReply(){
			let ta = document.querySelector("textarea"); //��� �ۼ�â
			let replyDiv = document.querySelector("#reply"); //��� ���â
			
			//JSON({Ű : ������}) ���� ������ �����
            let data = {'boardnum':<%=num%> , 'reply':ta.value}
            
            let xhr = new XMLHttpRequest()
            
            //��û��� , ��û���
            xhr.open('post', 'replyService')
            //���۵������� ����
            xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8')
            //��û & ������ ������
            xhr.send(JSON.stringify(data))
            
            xhr.onreadystatechange = function(){
               if(xhr.readyState===XMLHttpRequest.DONE){  //��û����
                  if(xhr.status===200){ //���伺��
                     console.log("���伺��")
                     console.log(xhr.responseText) //���䵥���� Ȯ�� (responseXML)
                     if(xhr.responseText === "success"){
                        //location.href = "board_list.jsp"
                     }else{
                        //check_p.innerText = '���̵�/��й�ȣ�� Ȯ�����ּ���'
                     }
                  }else{
                     console.log("�������")
                  }
               }else{  //��û����
                  console.log("��û����")
               }
            }
		}
	
	
	
	
		// ��Ŀ�� Ŭ���ϸ� ��Ҹ��� ǥ���� ���������� �Դϴ�
		var infowindow = new kakao.maps.InfoWindow({zIndex:1});
	
		var mapContainer = document.getElementById('map'), // ������ ǥ���� div 
		    mapOption = {
		        center: new kakao.maps.LatLng(37.566826, 126.9786567), // ������ �߽���ǥ
		        level: 3 // ������ Ȯ�� ����
		    };  
	
		// ������ �����մϴ�    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
	
		// ��� �˻� ��ü�� �����մϴ�
		var ps = new kakao.maps.services.Places(); 
	
		// Ű����� ��Ҹ� �˻��մϴ�
		ps.keywordSearch('<%=vo.getLocation()%>', placesSearchCB); 
	
		// Ű���� �˻� �Ϸ� �� ȣ��Ǵ� �ݹ��Լ� �Դϴ�
		function placesSearchCB (data, status, pagination) {
		    if (status === kakao.maps.services.Status.OK) {
	
		        // �˻��� ��� ��ġ�� �������� ���� ������ �缳���ϱ�����
		        // LatLngBounds ��ü�� ��ǥ�� �߰��մϴ�
		        var bounds = new kakao.maps.LatLngBounds();
	
		        for (var i=0; i<data.length; i++) {
		            displayMarker(data[i]);   //��Ŀ
		            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
		        }       
	
		        // �˻��� ��� ��ġ�� �������� ���� ������ �缳���մϴ�
		        map.setBounds(bounds);
		    } 
		}
	
		// ������ ��Ŀ�� ǥ���ϴ� �Լ��Դϴ�
		function displayMarker(place) {
		    
		    // ��Ŀ�� �����ϰ� ������ ǥ���մϴ�
		    var marker = new kakao.maps.Marker({
		        map: map,
		        position: new kakao.maps.LatLng(place.y, place.x) 
		    });
	
		    // ��Ŀ�� Ŭ���̺�Ʈ�� ����մϴ�
		    kakao.maps.event.addListener(marker, 'mouseover', function() {
		        // ��Ŀ�� Ŭ���ϸ� ��Ҹ��� ���������쿡 ǥ��˴ϴ�
		        infowindow.setContent('<div style="padding:5px;font-size:12px;"><img src="./asset/img/img.jpg" style="width:150px;height:150px;"></div>');
		        infowindow.open(map, marker);
		    });
		    
		    kakao.maps.event.addListener(marker, 'mouseout', function() {
		    	infowindow.close();
		    });
		    
		}
	</script>
	
</body>
</html>