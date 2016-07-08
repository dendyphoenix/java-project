package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DogDetailService;
import vo.ActionForward;
import vo.Dog;

public class DogDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		DogDetailService dogDetailService = new DogDetailService();
		Dog dog = dogDetailService.getDog(id);
		
		//강아지 상품의 이미지명을 쿠키에 저장
		Cookie cookie = new Cookie("today"+id, dog.getImage());
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		
		request.setAttribute("dog", dog);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("dogDetail.jsp");
		
		return forward;
	}

}
