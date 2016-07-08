package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardContentService;
import vo.ActionForward;
import vo.Article;

public class BoardContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		//파라미터로 전송된 num값을 가지고 있는 글의 정보를 얻어보기
		BoardContentService boardContentService 
			= new BoardContentService();

		Article article = boardContentService.getArticle(num);
		
		//데이터 공유
		request.setAttribute("article", article);
		request.setAttribute("pageNum", pageNum);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("/content.jsp");
		
		return forward;
	}

}
