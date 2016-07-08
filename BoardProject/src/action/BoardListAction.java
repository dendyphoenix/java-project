package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import svc.BoardListService;
import vo.ActionForward;
import vo.Article;
import vo.PageInfo;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int pageSize = 10;
		//한 페이지당 출력될 글의 개수
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null){
				pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		
		//해당 페이지에 첫번째로 출력될 레코드 번호 구하기
		int startRow = (currentPage - 1) * pageSize + 1;
		//현재 페이지 : 1
		//(1 - 1) * 10 + 1 ---> 1
		
		//총 글의 개수를 저장할 변수 선언
		int count = 0;
		
		//해당 페이지에 첫번째로 출력되는 글의 번호를 저장할 변수 선언
		int number = 0;
		
		ArrayList<Article> articleList = null;
		BoardListService boardListService
		 = new BoardListService();
		
		count = boardListService.getArticleCount();
		
		if(count > 0){
			articleList = boardListService.getArticleList(startRow,pageSize);
		}
		
		number = count - (currentPage - 1) * pageSize;
		
		int pageCount = 0;
		int startPage = 0;
		int pageBlock = 0;
		int endPage = 0;
		if(count > 0){
			pageCount = 
					count / pageSize + (count % pageSize == 0 ? 0 : 1);
		

		startPage = ((currentPage - 1) / pageSize) * pageSize + 1;
		//하나의 페이지 그룹에서 첫 페이지 번호
		//페이지그룹 [1][2][3][4]...[9][10]
		//페이지그룹 [11][12][13][14][15]...[19][20]
				
		pageBlock = 10;
		endPage = startPage + pageBlock - 1;
		//하나의 페이지 그룹에서 마지막 페이지 번호
		
		if(endPage > pageCount) {
			//마지막 페이지 그룹인 경우는 endPage가 pageCount보다 클 수 있다.
			endPage = pageCount;
		}
		}
		
		request.setAttribute("articleList", articleList);
		PageInfo pageInfo = new PageInfo();
		pageInfo.setCount(count);
		pageInfo.setCurrentPage(currentPage);
		pageInfo.setEndPage(endPage);
		pageInfo.setNumber(number);
		pageInfo.setPageBlock(pageBlock);
		pageInfo.setStartPage(startPage);
		pageInfo.setPageCount(pageCount);
		
		request.setAttribute("pageInfo", pageInfo);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("/list.jsp");
		
		return forward;
	}

}
