package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class DogCartQtyDownService {

	public void downQty(HttpServletRequest request, String id) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for (int i = 0; i < cartList.size(); i++) {
			if(cartList.get(i).getId() == Integer.parseInt(id)){
				cartList.get(i).setQty(cartList.get(i).getQty()-1);
				break;
			}
		}
	}
}
