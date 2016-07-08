<%@page import="vo.Article"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		#writerFormArea{
				width : 600px;
				margin : auto;
				border : 3px double brown;
				border-radius : 15px;
		}
		h2{
				text-align : center;
				border-bottom : 2px solid brown;
		}
		table{
		        margin-top : 10px;
				width : 580px;
				margin : auto;
				text-align : center;
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
</style>
</head>
<body>
		<%
		//해당 글을 등록할 때 작성한 글을 정보를 디비에서 가져와서 화면에 보여주는 것이 필요함.
		String pageNum = (String)request.getAttribute("pageNum");
		Article article = (Article)request.getAttribute("article");
		int num = article.getNum();
		
		%>
		<form action="boardUpdatePro.bo" method = "POST">
		<input type = "hidden" name = "num" value = "<%=num%>"/>
		<input type = "hidden" name = "pageNum" value = "<%=pageNum%>"/>
		<section id = "writerFormArea">
				<h2>게시판 글쓰기</h2>
				<table>
						<tr>
							<td class = "td_left"><label for = "writer">작성자</label></td>
							<td class = "td_right"><input type= "text" name = "writer" id = "writer" 
							value = "<%=article.getWriter()%>" readonly="readonly"/></td>
						</tr>
						<tr>
							<td class = "td_left"><label for = "subject">글제목</label></td>
							<td class = "td_right"><input type= "text" name = "subject" id = "subject" 
							value = "<%=article.getSubject()%>"/></td>
						</tr>
						<tr>
							<td class = "td_left"><label for = "email">이메일</label></td>
							<td class = "td_right"><input type= "text" name = "email" id = "email" 
							value = "<%=article.getEmail()%>"/></td>
						</tr>
						<tr>
							<td class = "td_left"><label for = "content">글내용</label></td>
							<td class = "td_right"><textarea rows="20" cols="40" name = "content" id = "content" 
							><%=article.getContent()%></textarea></td>
						</tr>
						<tr>
							<td class = "td_left"><label for = "passwd">비밀번호</label></td>
							<td class = "td_right"><input type = "password" id = "passwd" name = "passwd"></td>
						</tr>
						<tr id = "tr_command">
								<td colspan ="2">
										<input type = "reset" value = "취소">
										<input type = "submit" value = "글수정">
										
				</table>
		</section>
		</form>

</body>
</html>