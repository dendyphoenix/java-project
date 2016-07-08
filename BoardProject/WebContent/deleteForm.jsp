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
	int num = (Integer)(request.getAttribute("num"));
	String pageNum = (String)request.getAttribute("pageNum"); 
%>
<form action="boardDeletePro.bo" method = "POST">
	<input type = "hidden" name = "num" value = "<%=num %>"/>
	<input type = "hidden" name = "pageNum" value = "<%=pageNum %>"/>
	비밀번호 : <input type = "password" name = "passwd"/><br>
	<input type = "submit" value = "삭제"/>
</form>
</body>
</html>