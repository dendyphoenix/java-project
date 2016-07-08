<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="article" class = "vo.Article"></jsp:useBean>
<jsp:setProperty name = "article" property = "*"/>

<%
	
	
	if(updateCount > 0){
		response.sendRedirect("list.jsp?pageNum=" + pageNum);
	}
	else{
		%>
		<script>
			alert("수정실패");
			history.back();
			//history.go(-1) : 한 단계 이전으로 이동
			//history.go(1)
			//history.go(2)
			//history : 방문했던 URL 정보를 저장하는 객체
			//back : 이전 URL로 이동
		</script>
		<%
	}
%>