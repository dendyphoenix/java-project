package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.NoticeListService;
import vo.ActionForward;
import vo.Notice;

public class NoticeListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		NoticeListService noticeListService = new NoticeListService();
		
		ArrayList<Notice> noticeList = noticeListService.getnotice();
		request.setAttribute("noticeList", noticeList);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("noticeList.jsp");
		return forward;
	}

}
