package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DogCartQtyDownService;
import vo.ActionForward;

public class DogCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		
		DogCartQtyDownService dogCartQtyDownService = new DogCartQtyDownService();
		
		dogCartQtyDownService.downQty(request,id);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setUrl("dogCartList.dog");
		return forward;
	}

}
