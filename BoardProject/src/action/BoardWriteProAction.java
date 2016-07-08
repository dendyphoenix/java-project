package action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardWriteProService;
import vo.ActionForward;
import vo.Article;

public class BoardWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Article article = new Article();
		article.setContent(request.getParameter("content"));
		article.setEmail(request.getParameter("email"));
		article.setIp(request.getRemoteAddr());
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setRef(Integer.parseInt(request.getParameter("ref")));
		article.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		article.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		article.setPasswd(request.getParameter("passwd"));
		article.setSubject(request.getParameter("subject"));
		article.setWriter(request.getParameter("writer"));
		article.setReg_date(new Timestamp(System.currentTimeMillis()));	
		//1970�� 1�� 1�� �������� ��������� �ð��� �и����� ������ ��ȯ
		
		BoardWriteProService boardWriteProService
		 = new BoardWriteProService();
		boolean writeSucess = boardWriteProService.writeArticle(article);
		ActionForward forward = null;
		if(writeSucess){
			forward = new ActionForward();
			forward.setUrl("boardList.bo");
			forward.setRedirect(true);
		}
		else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('��Ͻ���')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
