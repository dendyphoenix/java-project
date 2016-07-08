<%@page import="vo.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#cartListArea{
		width : 400px;
		border : 1px solid red;
		margin : auto;
	}
	table{
		margin : auto;
		text-align : center;
	}
	h1{
		text-align : center;
	}
	#tr_title{
		background : orange;
	}
	.cartImage{
		width : 70px;
		height : 70px;
	}
	#totalMoney{
		text-align : right;
	}
	.updown{
		width : 15px;
		height : 15px;
	}
</style>

<script>
	function checkall(){
		/*
			html영역의 각 엘리먼트(태그)들은 인터프리터에 의해서 파싱되면
			메모리에 모두 객체로 생성됨
			각 객체들은 name속성과 id속성으로 자바스크립트에서 쉽게 접근 가능
			동일한 name을 가지고 있는 객체가 여러개가 존재하면 자동으로 배열 객체가 생성된다.
		*/
		//document : HTML 문서 자체 객체
		if(document.myform.delete1.length == undefined){
			//생성된 체크박스가 하나인 경우
			document.myform.delete1.checked = document.getElementById("allCheck").checked;;
			//checked : 현재 체크박스가 체크되어 있으면 true를 반환
			//체크박스가 해제되어 있으면 false을 반환
		}
		else{
			//생성된 체크박스가 여러 개인 경우
			for(i=0;i<document.myform.delete1.length; i++){
				document.myform.delete1[i].checked = document.getElementById("allCheck").checked;
			}
		}
	}
	
	function checkQty(id,qty){
		if(qty != 1){
			location.href = "dogCartQtyDown.dog?id="+id;
		}
	}
	
	function removeCart(id){
		location.href="dogCartRemove.dog?delete1="+id;
	}

</script>

</head>
<body>
<%
	ArrayList<Cart> cartList = (ArrayList<Cart>)request.getAttribute("cartList");
	int totalMoney = (Integer)request.getAttribute("totalMoney");
%>
	<section id = "cartListArea">
		<%
			if(cartList == null || cartList.size() ==0){
		%>
				<h1>장바구니 항목이 존재하지 않습니다.</h1>	
		<%	
			}
			else{
		%>
				<h1>장바구니 항목<a href = "dogList.dog">쇼핑계속하기</a></h1>
				<form action="dogCartRemove.dog" method = "POST" name="myform">
				<table>
					<tr id = "tr_title">
						<td><input type = "checkbox" id = "allCheck"
						onclick="checkall()"/></td>
						<td>번호</td>
						<td>상품이미지</td>
						<td>상품명</td>
						<td>가격</td>
						<td>수량</td>
						<td><input type = "submit" value = "삭제"/></td>
					</tr>
					<%
						int num=1;
						for(int i = 0; i < cartList.size(); i++){
					%>
					<tr>
						<td><input type = "checkbox" name = "delete1" value = "<%=cartList.get(i).getId() %>"/></td>
						<td><%=num++ %></td>
						<td><img src = "images/<%=cartList.get(i).getImage()%>" class="cartImage"/></td>
						<td><%=cartList.get(i).getKind() %></td>
						<td><%=cartList.get(i).getPrice() %></td>
						<td><a href = "dogCartQtyUp.dog?id=<%=cartList.get(i).getId()%>"><img src = "images/up.jpg" class = "updown"/></a><br>
							<%=cartList.get(i).getQty() %>
							<br><a href = "javascript:checkQty(<%=cartList.get(i).getId()%>, <%=cartList.get(i).getQty()%>)"><img src = "images/down.jpg" class = "updown"/></a>
						</td>
						<td><input type = "button" value = "삭제" onclick="removeCart(<%=cartList.get(i).getId()%>)"/></td>
					</tr>
					<%		
						}
					%>
					<tr id = "totalMoney">
						<td colspan = "7">
						 <%=totalMoney %>원
						</td>
					</tr>
				</table>
		<%
			}
		%>
		</form>
	</section>
</body>
</html>