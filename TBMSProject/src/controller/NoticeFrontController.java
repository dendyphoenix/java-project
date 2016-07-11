package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.NoticeListAction;
import vo.ActionForward;
@WebServlet("*.tbms")
public class NoticeFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public NoticeFrontController() {
		// TODO Auto-generated constructor stub
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("noticeList.tbms")){
			action = new NoticeListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}
}
