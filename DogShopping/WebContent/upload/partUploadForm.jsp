<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" encType="multipart/form-data" action = "/DogShopping/upload.do">
	작성자 : <input type = "text" name= "user"/><br>
	제목 : <input type = "text" name= "title"/><br>
	파일명 : <input type="file" name="uploadFile"><br>
	<input type = "submit" value = "파일 올리기"/>
</form>





</body>
</html>