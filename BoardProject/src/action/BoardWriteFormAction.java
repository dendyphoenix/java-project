package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;
import vo.ReplyInfo;

public class BoardWriteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int num=0,ref=1,re_step=0,re_level=0;
		if(request.getParameter("num") != null){
			//답변하기 요청이 넘어왔으면...
			num = Integer.parseInt(request.getParameter("num"));
			ref = Integer.parseInt(request.getParameter("ref"));
			re_step = Integer.parseInt(request.getParameter("re_step"));
			re_level = Integer.parseInt(request.getParameter("re_level"));
		}
		ReplyInfo replyInfo = new ReplyInfo();
		replyInfo.setNum(num);
		replyInfo.setRe_step(re_step);
		replyInfo.setRe_level(re_level);
		replyInfo.setRef(ref);
		request.setAttribute("replyInfo", replyInfo);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("/writerForm.jsp");		
		return forward;
	}

}
