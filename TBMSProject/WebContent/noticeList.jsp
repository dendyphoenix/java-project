<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	
	<style>
		.maintopimg{
			height : 150px;
			width : 1270px;
		}
		#main_menuArea{
			border : 5px double gray;
			background : black;
			height : 30px;
			width : 1260px;
		}
		.main_menu{
			height : 30px;
		}
		#noticeMain_left{
			background : black;
			border : 3px double gray;
			width : 200px;
			height : 700px;
			float : left;
			margin-right : 10px;
			
		}
		#notice_table{
			color : white;
		}
		#noticeMain_right{
			float : right;
			height : 500px;
			width : 700px;
			float : left;
		}
		
	
	</style>


</head>
<body>
	
	<section id = "main_top">
		<header>
		<a href = "Main.jsp">
		<img src = "images/maintop.jpg" class = "maintopimg">
		</a></header>
	
		<section id = "main_menuArea">
			
			<a href = "noticeMain.jsp"><img src = "images/main_notice.jpg" class = "main_menu"></a>
			<a href = "boardMain.jsp"><img src = "images/main_board.png" class = "main_menu"></a>
			<a href = "noticeMain.jsp"><img src = "images/main_coco.png" class = "main_menu"></a>
			<a href = "noticeMain.jsp"><img src = "images/main_meter.png" class = "main_menu"></a>
			<a href = "noticeMain.jsp"><img src = "images/main_sisul.png" class = "main_menu"></a>
			
		</section>
	
	</section>

	<section id = "noticeMain">
		<aside id = "noticeMain_left">
				<table id = "notice_table">
					<tr>
						<td><a href = "noticeList.tbms">공지사항</a></td>
					</tr>
					<tr>
						<td><a href = "images/ej.jpg">왠지 클릭하고싶을거같음</a></td>
					</tr>
				
				</table>
		</aside>
	
	</section>
	
	<section id = "noticeList">
		<aside id = "noticeMain_right">
			
	
			<sql:query var = "rs" dataSource="jdbc/jsptest">
				SELECT writer,subject FROM noticeBoard

			</sql:query>
			<table border = "1">
			<tr><!-- 제목행 -->
				<c:out var = "ㅎㅎㅎ" items = "${rs.writer }">
				</c:out>
				<%-- <c:forEach var = "columnName" items = "${rs.columnNames }"> --%>
				<th><!-- 제목 셀 : 가운데 정렬되면서 진하게나옴 -->
				<%-- <c:out value = "${columnName }"/> --%>
					</th>
				<%-- </c:forEach> --%>
			</tr>
		</aside>
			</table>

</body>
</html>