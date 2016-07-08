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
		//�� �������� ��µ� ���� ����
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null){
				pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		
		//�ش� �������� ù��°�� ��µ� ���ڵ� ��ȣ ���ϱ�
		int startRow = (currentPage - 1) * pageSize + 1;
		//���� ������ : 1
		//(1 - 1) * 10 + 1 ---> 1
		
		//�� ���� ������ ������ ���� ����
		int count = 0;
		
		//�ش� �������� ù��°�� ��µǴ� ���� ��ȣ�� ������ ���� ����
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
		//�ϳ��� ������ �׷쿡�� ù ������ ��ȣ
		//�������׷� [1][2][3][4]...[9][10]
		//�������׷� [11][12][13][14][15]...[19][20]
				
		pageBlock = 10;
		endPage = startPage + pageBlock - 1;
		//�ϳ��� ������ �׷쿡�� ������ ������ ��ȣ
		
		if(endPage > pageCount) {
			//������ ������ �׷��� ���� endPage�� pageCount���� Ŭ �� �ִ�.
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
