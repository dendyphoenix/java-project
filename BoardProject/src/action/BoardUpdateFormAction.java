package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardUpdateFormService;
import vo.ActionForward;
import vo.Article;

public class BoardUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		BoardUpdateFormService boardUpdateFormService = 
				new BoardUpdateFormService();
		Article article = BoardUpdateFormService.getUpdateArticle(num);
		request.setAttribute("article", article);
		request.setAttribute("pageNum", pageNum);
		ActionForward forward = new ActionForward();
		forward.setUrl("/updateForm.jsp");
		return forward;
	}

}
