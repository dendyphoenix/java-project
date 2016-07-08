<%@page import="vo.Dog"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type = "text/css">
	#dogListArea{
		width : 600px;
		margin : auto;
		
	}
	img{
		width : 150px;
		height : 150px;
	}
	h2{
		text-align: center;
	}
	#todayImageArea{
		width : 600px;
		margin : auto;
	
	}
	.todayImage{
		width : 100px;
		height : 100px;
	}


</style>
</head>
<body>
	<%
		ArrayList<Dog> dogList = (ArrayList<Dog>)request.getAttribute("dogList");
	%>
	
	<section id = "dogListArea">
		<%
			if(dogList == null || dogList.size() == 0){
		%>
			<h2>등록된 강아지 상품이 존재하지 않습니다.</h2>
		<%
			}
			else{
		%>
		
		<h2>강아지 목록(강아지 아닌 것도 있음..)</h2>
		<table>
			<tr>
			<%
				for(int i = 0; i<dogList.size();i++){
			%>
				<td><a href = "dogDetail.dog?id=<%=dogList.get(i).getId()%>"><img src = "images/<%=dogList.get(i).getImage() %>"/></a></td>
			<%
					if((i+1) % 4 ==0){
			%>
					</tr><tr>
			<%
					}
				}
			%>
			</tr>
		</table>
		
		<%
			}
		%>
	</section>
	<br><br>
	
	<%
		ArrayList<String> todayImages = (ArrayList<String>)request.getAttribute("todayImages");
		if(todayImages != null && todayImages.size() != 0){
	%>
		<section id = "todayImageArea">
			<table>
				<tr>
				<%
				for(int i = 0; i<todayImages.size();i++){
				%>
				<td><img src = "images/<%=todayImages.get(i) %>" class = "todayImage"/></td>
				<%
				}
				%>
				</tr>
			</table>
				
		</section>
	<%
		}
	%>
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>