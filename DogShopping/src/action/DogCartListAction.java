package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DogCartListService;
import vo.ActionForward;
import vo.Cart;

public class DogCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		DogCartListService dogCartListService = new DogCartListService();
		
		ArrayList<Cart> cartList = dogCartListService.getCartList(request);
		
		//�� �����ؾ��� �ݾ� ���ϱ�
		int totalMoney = 0;
		for(int i =0; i<cartList.size();i++){
			totalMoney += cartList.get(i).getPrice() * cartList.get(i).getQty();
		}
		request.setAttribute("cartList", cartList);
		request.setAttribute("totalMoney", totalMoney);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("dogCartList.jsp");
		return forward;
	}

}
