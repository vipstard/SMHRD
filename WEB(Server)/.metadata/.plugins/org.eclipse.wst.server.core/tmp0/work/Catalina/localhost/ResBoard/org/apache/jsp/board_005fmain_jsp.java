/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.58
 * Generated at: 2022-02-28 06:51:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.model.MemberVO;
import java.util.ArrayList;
import com.model.ReplyVO;
import com.model.BoardVO;
import com.model.BoardDAO;

public final class board_005fmain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.model.MemberVO");
    _jspx_imports_classes.add("com.model.ReplyVO");
    _jspx_imports_classes.add("com.model.BoardVO");
    _jspx_imports_classes.add("com.model.BoardDAO");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=EUC-KR");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"EUC-KR\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\" integrity=\"sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==\" crossorigin=\"anonymous\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("	background-image: url('asset/img/bg.jpg');\r\n");
      out.write("	padding-left: 200px;\r\n");
      out.write("	padding-right: 200px;\r\n");
      out.write("	font-family: 'Do Hyeon', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".card-body {\r\n");
      out.write("	background-color: whitesmoke;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("p {\r\n");
      out.write("	padding-top: 5px;\r\n");
      out.write("	padding-left: 20px;\r\n");
      out.write("	font-size: 30px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");

		int num = Integer.parseInt(request.getParameter("num"));
	
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getOneList(num);
		
		ArrayList<ReplyVO> al = dao.getReply(num);
		System.out.println(al.size());
		
		MemberVO vo2 = (MemberVO)session.getAttribute("member");
		
		//조회수 1증가
		if(!vo.getWriter().equals(vo2.getId())){
		dao.updateViews(num);
		}
	
      out.write("\r\n");
      out.write("	<div class=\"card-body\" style=\"margin-top: 100px; margin-bottom: 10px; height: 50px\">\r\n");
      out.write("		<p>");
      out.print(vo.getName() );
      out.write(' ');
      out.write('/');
      out.write(' ');
      out.print(vo.getWriter() );
      out.write("</p>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<!-- 장소, 및 지도 -->\r\n");
      out.write("	<div id=\"map\" style=\"width: 100%; height: 350px;\">%지도자리%</div>\r\n");
      out.write("	\r\n");
      out.write("	<!-- 댓글작성 -->\r\n");
      out.write("	<div class=\"card mb-2\">\r\n");
      out.write("		<div class=\"card-body\">\r\n");
      out.write("			<p>한줄 평 : ");
      out.print(vo.getContent() );
      out.write("</p>\r\n");
      out.write("			<ul class=\"list-group list-group-flush\">\r\n");
      out.write("				<li class=\"list-group-item\">\r\n");
      out.write("					<textarea class=\"form-control\" id=\"exampleFormControlTextarea1\" rows=\"3\"></textarea>\r\n");
      out.write("					<button type=\"button\" class=\"btn btn-dark mt-3\"onclick=\"addReply()\">post reply</button>\r\n");
      out.write("				</li>\r\n");
      out.write("			</ul>\r\n");
      out.write("			<ul class=\"list-group list-group-flush\" id=\"reply\">\r\n");
      out.write("				\r\n");
      out.write("				");
for(int i = al.size()-1;i >= 0;i--){
      out.write("\r\n");
      out.write("				<li class=\"list-group-item\"><span>");
      out.print(al.get(i).getContent() );
      out.write(' ');
      out.write('/');
      out.write(' ');
      out.print(al.get(i).getWriter() );
      out.write("</span></li>\r\n");
      out.write("				");
} 
      out.write("\r\n");
      out.write("			</ul>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	<script type=\"text/javascript\" src=\"//dapi.kakao.com/v2/maps/sdk.js?appkey=dac4065a7a1dada3f8ae562756260926&libraries=services\"></script>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	<script>\r\n");
      out.write("		function addReply(){\r\n");
      out.write("			let ta = document.querySelector(\"textarea\"); //댓글 작성창\r\n");
      out.write("			let replyDiv = document.querySelector(\"#reply\"); //댓글 출력창\r\n");
      out.write("			\r\n");
      out.write("			//JSON({키 : 실제값}) 형식 데이터 만들기\r\n");
      out.write("            let data = {'boardnum':");
      out.print(num);
      out.write(" , 'reply':ta.value}\r\n");
      out.write("            \r\n");
      out.write("            let xhr = new XMLHttpRequest()\r\n");
      out.write("            \r\n");
      out.write("            //요청방식 , 요청경로\r\n");
      out.write("            xhr.open('post', 'replyService')\r\n");
      out.write("            \r\n");
      out.write("            //전송데이터의 형식\r\n");
      out.write("            xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8')\r\n");
      out.write("            \r\n");
      out.write("            //요청 & 전송할 데이터\r\n");
      out.write("            xhr.send(JSON.stringify(data))\r\n");
      out.write("            \r\n");
      out.write("            xhr.onreadystatechange = function(){\r\n");
      out.write("               if(xhr.readyState===XMLHttpRequest.DONE){  //요청성공\r\n");
      out.write("                  if(xhr.status===200){ //응답성공\r\n");
      out.write("                     console.log(\"응답성공\")\r\n");
      out.write("                     console.log(xhr.responseText) //응답데이터 확인 (responseXML)\r\n");
      out.write("                     if(xhr.responseText === \"success\"){\r\n");
      out.write("                        //location.href = \"board_list.jsp\"\r\n");
      out.write("                        \r\n");
      out.write("                        let li = document.creatElement('li')\r\n");
      out.write("                        li.className = 'list-group-item' //li태그에 클래스 추가\r\n");
      out.write("                        let span = document.createElement('span')\r\n");
      out.write("                        span.innerText = ta.value + '/ ");
      out.print(vo2.getId());
      out.write("'\r\n");
      out.write("                        \r\n");
      out.write("                        li.appendChild(span) //li태그 자식요소로 span 태그 추가\r\n");
      out.write("                        \r\n");
      out.write("                        replyDiv.insertBefore(li, replyDiv.firstChild ) //replyDiv 첫 번째 자식으로 추가\r\n");
      out.write("                        \r\n");
      out.write("                        ta.value=''\r\n");
      out.write("                        \r\n");
      out.write("                     }else{\r\n");
      out.write("                        //check_p.innerText = '아이디/비밀번호를 확인해주세요'\r\n");
      out.write("                     }\r\n");
      out.write("                  }else{\r\n");
      out.write("                     console.log(\"응답실패\")\r\n");
      out.write("                  }\r\n");
      out.write("               }else{  //요청실패\r\n");
      out.write("                  console.log(\"요청실패\")\r\n");
      out.write("               }\r\n");
      out.write("            }\r\n");
      out.write("		}\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("		// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다\r\n");
      out.write("		var infowindow = new kakao.maps.InfoWindow({zIndex:1});\r\n");
      out.write("	\r\n");
      out.write("		var mapContainer = document.getElementById('map'), // 지도를 표시할 div \r\n");
      out.write("		    mapOption = {\r\n");
      out.write("		        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표\r\n");
      out.write("		        level: 3 // 지도의 확대 레벨\r\n");
      out.write("		    };  \r\n");
      out.write("	\r\n");
      out.write("		// 지도를 생성합니다    \r\n");
      out.write("		var map = new kakao.maps.Map(mapContainer, mapOption); \r\n");
      out.write("	\r\n");
      out.write("		// 장소 검색 객체를 생성합니다\r\n");
      out.write("		var ps = new kakao.maps.services.Places(); \r\n");
      out.write("	\r\n");
      out.write("		// 키워드로 장소를 검색합니다\r\n");
      out.write("		ps.keywordSearch('");
      out.print(vo.getLocation());
      out.write("', placesSearchCB); \r\n");
      out.write("	\r\n");
      out.write("		// 키워드 검색 완료 시 호출되는 콜백함수 입니다\r\n");
      out.write("		function placesSearchCB (data, status, pagination) {\r\n");
      out.write("		    if (status === kakao.maps.services.Status.OK) {\r\n");
      out.write("	\r\n");
      out.write("		        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해\r\n");
      out.write("		        // LatLngBounds 객체에 좌표를 추가합니다\r\n");
      out.write("		        var bounds = new kakao.maps.LatLngBounds();\r\n");
      out.write("	\r\n");
      out.write("		        for (var i=0; i<data.length; i++) {\r\n");
      out.write("		            displayMarker(data[i]);   //마커\r\n");
      out.write("		            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));\r\n");
      out.write("		        }       \r\n");
      out.write("	\r\n");
      out.write("		        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다\r\n");
      out.write("		        map.setBounds(bounds);\r\n");
      out.write("		    } \r\n");
      out.write("		}\r\n");
      out.write("	\r\n");
      out.write("		// 지도에 마커를 표시하는 함수입니다\r\n");
      out.write("		function displayMarker(place) {\r\n");
      out.write("		    \r\n");
      out.write("		    // 마커를 생성하고 지도에 표시합니다\r\n");
      out.write("		    var marker = new kakao.maps.Marker({\r\n");
      out.write("		        map: map,\r\n");
      out.write("		        position: new kakao.maps.LatLng(place.y, place.x) \r\n");
      out.write("		    });\r\n");
      out.write("	\r\n");
      out.write("		    // 마커에 클릭이벤트를 등록합니다\r\n");
      out.write("		    kakao.maps.event.addListener(marker, 'mouseover', function() {\r\n");
      out.write("		        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다\r\n");
      out.write("		        infowindow.setContent('<div style=\"padding:5px;font-size:12px;\"><img src=\"./asset/img/img.jpg\" style=\"width:150px;height:150px;\"></div>');\r\n");
      out.write("		        infowindow.open(map, marker);\r\n");
      out.write("		    });\r\n");
      out.write("		    \r\n");
      out.write("		    kakao.maps.event.addListener(marker, 'mouseout', function() {\r\n");
      out.write("		    	infowindow.close();\r\n");
      out.write("		    });\r\n");
      out.write("		    \r\n");
      out.write("		}\r\n");
      out.write("	</script>\r\n");
      out.write("	\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
