<%@page import="vo.Article"%>
<%@page import="dao.BoardDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		#contentArea{
				width : 600px;
				margin : auto;
				border : 3px double brown;
		}
		h2{
				height : 40px;
				text-align : center;
				border-bottom : 2px solid brown;
		}
		#basicContent{
		        margin-top : 10px;
				height : 40px;
				border-bottom : 2px solid brown;
				text-align : center;
		}
		#detailArea{
				height: 460px;
				overflow: auto;
		}
		#commandArea{
				height: 40px;
				text-align : center;
		}
</style>
</head>
<body>
<%
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	Article article = (Article)request.getAttribute("article");
	String pageNum = (String)request.getAttribute("pageNum");

	//답변하기 요청에 필요한 값들을 변수에 할당
	int num = article.getNum();
	int ref = article.getRef();
	int re_step = article.getRe_step();
	int re_level = article.getRe_level();
%>
<section id = "contentArea">
	<h2>글내용보기</h2>
	<section id = "basicContent">
	작성자 : <%=article.getWriter() %> | 글내용 : <%=article.getSubject() %> | 작성일 : <%=article.getReg_date() %>
	</section>
	<section id = "detailArea">
	<%=article.getContent() %>
	</section>
	<section id = "commandArea">
	<a href = "writerForm.jsp?num=<%=num%>&ref=<%=ref%>&re_step=<%=re_step %>&re_level=<%=re_level%>">[답변하기]</a>
	<a href = "boardUpdateForm.bo?num=<%=num%>&pageNum=<%=pageNum%>">[수정하기]</a>
	<a href = "boardDeleteForm.bo?num=<%=num%>&pageNum=<%=pageNum%>">[삭제하기]</a>
	<a href = "boardList.bo?pageNum=<%=pageNum%>">[목록보기]</a>
	</section>
</section>
</body>
</html>