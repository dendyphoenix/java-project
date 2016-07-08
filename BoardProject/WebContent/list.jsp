<%@page import="vo.PageInfo"%>
<%@page import="vo.Article"%>
<%@page import="dao.BoardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		#listArea{
				width : 600px;
				margin : auto;
				border : 3px double brown;
				border-radius : 15px;
		}
		h1,h2{
				text-align : center;
		}
		table{
		        margin-top : 10px;
				width : 580px;
				margin : auto;
				text-align : center;
		}
		#tr_title{
				background: orange;
		}
		.td_left{
				width : 150px;
				text-align : center;
		}
		.td_right{
				width : 430px;
				text-align : left;
		}
		#writer{
		width : 200px;
		}
		#tr_command{
		text-align : center;
		}
		.td_num{
		width : 200px;
		text-align : left;
		}
		.td_subject{
		width : 200px;
		text-align: left;
		}
		.td_writer,.td_regdate,.td_readcount{
		width : 100px;
		}
		#pageArea{
		text-align : center;
		}
</style>
</head>
<body>
<%	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<%
	ArrayList<Article> articleList = 
		(ArrayList<Article>)request.getAttribute("articleList");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	int count = pageInfo.getCount();
	int currentPage = pageInfo.getCurrentPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
	int pageBlock = pageInfo.getPageBlock();
	int number = pageInfo.getNumber();
	int pageCount = pageInfo.getPageCount();
%>
<section id = "listArea">
<h1>글 목록<a href = "boardWriteForm.bo">글쓰기</a></h1>
<%
	if(count == 0){
%>
<h2>작성된 글이 없습니다.</h2>
<%
	}
	else{
%>
<table>
	<tr id = "tr_title">
	<td>번호</td>
	<td class = "td_writer">작성자</td>
	<td>제목</td>
	<td class  = "td_regdate">작성일</td>
	<td class = "td_readcount">조회수</td>
	</tr>
	<%
		for(int i=0;i<articleList.size();i++){
	%>
	<tr>
	<td><%=number-- %></td>
	<td><%=articleList.get(i).getWriter() %></td>
	<td class = "td_subject">
	<%
	 if(articleList.get(i).getRe_level() > 0){
		 for(int j=0;j<articleList.get(i).getRe_level();j++){
	%>
		&nbsp;&nbsp;&nbsp;
	<%
	 }
	%>
	re : 
	<%
	 }
	%>
	<a href = "boardContent.bo?num=<%=articleList.get(i).getNum()%>&pageNum=<%=currentPage %>"><%=articleList.get(i).getSubject() %></a>
	</td>
	<td><%=sdf.format(articleList.get(i).getReg_date()) %></td>
	<td><%=articleList.get(i).getReadcount() %></td>
	</tr>
	<%
		}
	%>
</table>
<%
	}
%>
<!-- 페이징 처리 -->
<section id = "pageArea">
<%
	if(count > 0){
	}
		
	
	if(startPage > 10){
	//첫번째 페이지 그룹이 아니면...
	//[이전]을 클릭하면 이전 그룹의 첫 페이지로 이동함.
	%>
	<a href = "boardList.bo?pageNum=<%=startPage - 10%>">[이전]</a>
		<%	
	}
	for(int i = startPage;i <= endPage;i++){
	//[이전][11][12][13].....[20]
	%>
	<a href = "boardList.bo?pageNum=<%=i %>">[<%=i%>]</a>
	<%
	}
	if(endPage < pageCount){
	//마지막 페이지 그룹이 아니면...
	//[이전][11][12][13].....[20][다음]
	//[다음]을 클릭하면 다음 페이지 그룹의 첫 페이지로 이동
		%>
	<a href = "boardList.bo?pageNum=<%=startPage + 10 %>">[다음]</a>
	<% 
		} 
	%>
	
</section>
</section>
</body>
</html>