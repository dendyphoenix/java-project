<%@page import="vo.ReplyInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--writerForm.jsp 에서는 원글을 작성할 수도 있고, 답글을 작성할 수 있다.
    		따라서 지금 작성한 글이 원글인지 답글인지를 구분할 수 있는 방법이 필요하다.
    		구분하는 방법으로 답변하기 요청을 했을 때만 writeForm.jsp로 파라미터로 넘어오는
    		값이 본 페이지에 넘어왔는지로 답글/원글을 구분함.  -->
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
		ReplyInfo replyInfo = (ReplyInfo)request.getAttribute("replyInfo");
		int num = replyInfo.getNum();
		int ref = replyInfo.getRef();
		int re_step = replyInfo.getRe_step();
		int re_level = replyInfo.getRe_level();
		%>
		<form action="boardWritePro.bo" method = "POST">
		<input type = "hidden" name = "num" value = "<%=num%>"/>
		<input type = "hidden" name = "ref" value = "<%=ref%>"/>
		<input type = "hidden" name = "re_step" value = "<%=re_step%>"/>
		<input type = "hidden" name = "re_level" value = "<%=re_level%>"/>
		<section id = "writerFormArea">
				<h2>게시판 글쓰기</h2>
				<table>
						<tr>
							<td class = "td_left"><label for = "writer">작성자</label></td>
							<td class = "td_right"><input type= "text" name = "writer" id = "writer"></td>
						</tr>
						<tr>
							<td class = "td_left"><label for = "subject">글제목</label></td>
							<td class = "td_right"><input type= "text" name = "subject" id = "subject"></td>
						</tr>
						<tr>
							<td class = "td_left"><label for = "email">이메일</label></td>
							<td class = "td_right"><input type= "text" name = "email" id = "email"></td>
						</tr>
						<tr>
							<td class = "td_left"><label for = "content">글내용</label></td>
							<td class = "td_right"><textarea rows="20" cols="40" name = "content" id = "content"></textarea></td>
						</tr>
						<tr>
							<td class = "td_left"><label for = "passwd">비밀번호</label></td>
							<td class = "td_right"><input type = "password" id = "passwd" name = "passwd"></td>
						</tr>
						<tr id = "tr_command">
								<td colspan ="2">
										<input type = "reset" value = "취소">
										<input type = "submit" value = "글등록">
										
				</table>
		</section>
		</form>
</body>
</html>