package controller;
/* 서블릿(컨트롤러)에서 해야 하는 작업
 * 1. 요청 파악
 * 2. 파악된 요청을 처리하는 비지니스 로직을 모델(Service클래스)로 호출
 * 3. 뷰 페이지로 포워딩
 * 
 */

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.DogCartAddAction;
import action.DogCartListAction;
import action.DogCartQtyDownAction;
import action.DogCartQtyUpAction;
import action.DogCartRemoveAction;
import action.DogDetailAction;
import action.DogListAction;
import vo.ActionForward;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.dog")
public class DogFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DogFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //공통적으로 하는 작업
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 요청 파악
		String requestURI = request.getRequestURI();
		//requestURI : 요청 주소 http://localhost:8088/boardProject/boardWriteForm.bo
		//반환값 : /boradProject/boardWriteForm.bo
		
		String contextPath = request.getContextPath();
		// /boardProject
		
		String command = requestURI.substring(contextPath.length());
		// /boardWriteForm.bo
		
		//다형성 이용해서 요청 처리
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/dogList.dog")){
			action = new DogListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogDetail.dog")){
			action = new DogDetailAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogCartAdd.dog")){
			action = new DogCartAddAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogCartList.dog")){
			action = new DogCartListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogCartRemove.dog")){
			action = new DogCartRemoveAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogCartQtyUp.dog")){
			action = new DogCartQtyUpAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/dogCartQtyDown.dog")){
			action = new DogCartQtyDownAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
		if(forward != null){
			//action 객체의 execute 메소드가 정상적으로 실행되어 
			//ActionForward 객체가 리턴됬으면..
			if(forward.isRedirect()){
				response.sendRedirect(forward.getUrl());
			}
			else{
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher(forward.getUrl());
				dispatcher.forward(request, response);
			}
		}
		
		
	}

	//get,post 어느것으로 넘어오든 doProcess 처리됨
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

}
