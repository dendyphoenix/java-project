package action;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DogListService;
import vo.ActionForward;
import vo.Dog;

public class DogListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//쿠키정보 가져오기
		Cookie[] cookieArray = request.getCookies();
		ArrayList<String> todayImages = new ArrayList<String>();
		if(cookieArray != null){
			for(int i =0; i<cookieArray.length;i++){
				if(cookieArray[i].getName().startsWith("today")){
					todayImages.add(cookieArray[i].getValue());
				}
			}
		}
		request.setAttribute("todayImages", todayImages);
		
		DogListService dogListService = new DogListService();
		
		ArrayList<Dog> dogList = dogListService.getDogList();
		request.setAttribute("dogList", dogList);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("dogList.jsp");
		return forward;
		
	}

}
