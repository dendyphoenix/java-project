<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			border : 5px double hotpink;
			background : pink;
			height : 30px;
			width : 1260px;
		}
		.main_menu{
			height : 30px;
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
			<a href = "noticeMain.jsp">커뮤니티</a>
			<a href = "noticeMain.jsp">계량기</a>
			<a href = "noticeMain.jsp">편의시설</a>
			
		</section>
	
	</section>




</body>
</html>