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

	<!-- 장소, 및 지도 -->
	<div id="map" style="width: 100%; height: 350px;">%지도자리%</div>
	
	<!-- 댓글작성 -->
	<div class="card mb-2">
		<div class="card-body">
			<p>한줄 평 : <%=vo.getContent() %></p>
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
			let ta = document.querySelector("textarea"); //댓글 작성창
			let replyDiv = document.querySelector("#reply"); //댓글 출력창
			
			//JSON({키 : 실제값}) 형식 데이터 만들기
            let data = {'boardnum':<%=num%> , 'reply':ta.value}
            
            let xhr = new XMLHttpRequest()
            
            //요청방식 , 요청경로
            xhr.open('post', 'replyService')
            //전송데이터의 형식
            xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8')
            //요청 & 전송할 데이터
            xhr.send(JSON.stringify(data))
            
            xhr.onreadystatechange = function(){
               if(xhr.readyState===XMLHttpRequest.DONE){  //요청성공
                  if(xhr.status===200){ //응답성공
                     console.log("응답성공")
                     console.log(xhr.responseText) //응답데이터 확인 (responseXML)
                     if(xhr.responseText === "success"){
                        //location.href = "board_list.jsp"
                     }else{
                        //check_p.innerText = '아이디/비밀번호를 확인해주세요'
                     }
                  }else{
                     console.log("응답실패")
                  }
               }else{  //요청실패
                  console.log("요청실패")
               }
            }
		}
	
	
	
	
		// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
		var infowindow = new kakao.maps.InfoWindow({zIndex:1});
	
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };  
	
		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
	
		// 장소 검색 객체를 생성합니다
		var ps = new kakao.maps.services.Places(); 
	
		// 키워드로 장소를 검색합니다
		ps.keywordSearch('<%=vo.getLocation()%>', placesSearchCB); 
	
		// 키워드 검색 완료 시 호출되는 콜백함수 입니다
		function placesSearchCB (data, status, pagination) {
		    if (status === kakao.maps.services.Status.OK) {
	
		        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
		        // LatLngBounds 객체에 좌표를 추가합니다
		        var bounds = new kakao.maps.LatLngBounds();
	
		        for (var i=0; i<data.length; i++) {
		            displayMarker(data[i]);   //마커
		            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
		        }       
	
		        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
		        map.setBounds(bounds);
		    } 
		}
	
		// 지도에 마커를 표시하는 함수입니다
		function displayMarker(place) {
		    
		    // 마커를 생성하고 지도에 표시합니다
		    var marker = new kakao.maps.Marker({
		        map: map,
		        position: new kakao.maps.LatLng(place.y, place.x) 
		    });
	
		    // 마커에 클릭이벤트를 등록합니다
		    kakao.maps.event.addListener(marker, 'mouseover', function() {
		        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
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