<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
	
	if(deleteCount > 0){
		response.sendRedirect("list.jsp?pageNum=" + pageNum);
	}
	else{
		%>
		<script>
			alert("삭제실패");
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
</body>
</html>