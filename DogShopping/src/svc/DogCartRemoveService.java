package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class DogCartRemoveService {

	public void removeCart(HttpServletRequest request, String[] deleteIdArray) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for (int i = 0; i < deleteIdArray.length; i++) {
			for (int j = 0; j < cartList.size(); j++) {
				if(Integer.parseInt(deleteIdArray[i]) == cartList.get(j).getId()){
					cartList.remove(cartList.get(j));
				}
				
			}
			
		}
		
	}

}
