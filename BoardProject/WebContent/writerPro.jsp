<%@page import="dao.BoardDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id = "article" class = "vo.Article"/>
<jsp:setProperty name = "article" property = "*"/>

<%
		article.setReg_date(new Timestamp(System.currentTimeMillis()));
		//1970년 1월 1일 자정부터 현재까지의 시간을 밀리세컨 단위로 반환
		article.setIp(request.getRemoteAddr());
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.insertArticle(article);
		response.sendRedirect("list.jsp");
%>