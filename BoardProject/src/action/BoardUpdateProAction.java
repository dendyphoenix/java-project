package action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardUpdateProService;
import vo.ActionForward;
import vo.Article;

public class BoardUpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Article article = new Article();
		article.setContent(request.getParameter("content"));
		article.setEmail(request.getParameter("email"));
		article.setIp(request.getRemoteAddr());
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setPasswd(request.getParameter("passwd"));
		article.setSubject(request.getParameter("subject"));
		article.setWriter(request.getParameter("writer"));
		article.setReg_date(new Timestamp(System.currentTimeMillis()));	
		String pageNum = request.getParameter("pageNum");
		
		BoardUpdateProService boardUpdateProService = 
				new BoardUpdateProService();
						
		int updateCount = 
				boardUpdateProService.modifyArticle(article);
		ActionForward forward = null;
		if(updateCount > 0){
			forward = new ActionForward();
			forward.setUrl("boardList.bo");
			forward.setRedirect(true);
		}
		else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
