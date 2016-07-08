<%@page import="vo.Dog"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<style>
		#wrap{
			width : 800px;
			margin : auto;
		}
		header{
			height : 150px;
			background: red;
		}
		#main{
			margin-top : 10px;
		}
		#main_left{
			height : 300px;		
			width : 180px;
			background: green;
			margin-right: 10px;
			float:left
		}
		#main_right{
			height : 300px;		
			width : 610px;
			background: green;
			float:left
		}
		footer{
		 height : 150px;
		 margin-top: 10px;
		 background: orange;
		 
		}
		.bigImage{
			width : 180px;
			height : 300px;
		}
	
	</style>



</head>
<body>
	<%-- <%
		Dog dog = (Dog)request.getAttribute("dog");
		
	
	%> --%>
	<section id = "wrap">
	
		<header>
			<h1><%-- <%=dog.getKind() %> --%>${dog.kind}의 상세정보</h1>
		</header>
		
		<section id = "main">
			<aside id = "main_left">
				<img src = "images/<%-- <%=dog.getImage() %> --%>${dog.image}" class = "bigImage"/>
			</aside>
			
			<section id = "main_right">
				<b>원산지 : </b><%-- <%=dog.getCountry() %> --%>${dog.country }<br>
				<b>가격 : </b><%-- <%=dog.getPrice() %> --%>${dog.price }원<br>
				<b>신장 : </b><%-- <%=dog.getHeight() %> --%>${dog.height }<br>
				<b>체중 : </b><%-- <%=dog.getWeight() %> --%>${dog.weight }<br>
				<b>설명 : </b><%-- <%=dog.getContent() %> --%>${dog.content }<br>
				<b>조회수 : </b><%-- <%=dog.getReadcount() %> --%>${dog.readcount }<br>
				
			</section>
		
		</section>
			<div style = "clear:both;"></div>
			<footer>
				<a href = "dogList.dog" style = "float:left">쇼핑계속하기</a>
				<a href = "dogCartAdd.dog?id=<%-- <%=dog.getId() %> --%>${dog.id }" style = "float:right">장바구니담기</a>
				
			</footer>
			
			
	</section>
</body>
</html>