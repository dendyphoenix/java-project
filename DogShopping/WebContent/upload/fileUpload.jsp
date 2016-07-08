<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		String realFolder = "";//파일이 업로드될 서버상의 실제 경로
		String saveFolder = "/fileSave";//파일이 업로드될 폴더의 상대경로
		String encType = "UTF-8";
		int maxSize = 5 * 1024 * 1024;//한번에 업로드 할 수 있는 최대 크기 5M
		
		ServletContext context = getServletContext();
		realFolder = context.getRealPath(saveFolder);
		//C:\JSPstudy\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\DogShopping
		
		MultipartRequest multi = new MultipartRequest(request,realFolder,maxSize,encType, new DefaultFileRenamePolicy());
		
		Enumeration params = multi.getParameterNames();
		
		while(params.hasMoreElements()){
			String name = (String)params.nextElement();
			String value = multi.getParameter(name);
			out.println("name = " + name + ", value = " + value+"<br>");
		}
		
		out.println("---------------------------------------------------<br>");
		
		
		
		Enumeration files = multi.getFileNames();
		
		while(files.hasMoreElements()){
			String name = (String)files.nextElement();
			
			//서버상에 업로드된 실제 파일명
			String fileName = multi.getFilesystemName(name);
			
			//원본 파일명
			String original = multi.getOriginalFileName(name);
			
			//마임타입
			String type = multi.getContentType(name);
			
			//업로드된 파일객체 자체
			File file = multi.getFile(name);
			
			//업로드된 파일 정보 출력
			out.println("파라미터 이름 : "+name+"<br>");
			out.println("원본 파일명 : "+original+"<br>");
			out.println("업로드 파일명 : "+fileName+"<br>");
			out.println("마임타입 : "+type+"<br>");
			
			if(file != null){
				out.println("크기 : "+file.length() + "<br>");
			}
		}
		
		
		
		
		
		
		
		
		
	%>
	
	
	
	
	
	
	
	
	
</body>
</html>