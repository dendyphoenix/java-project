package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class DogCartListService {

	public ArrayList<Cart> getCartList(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		
		return (ArrayList<Cart>)session.getAttribute("cartList");
	}
	
	
	
	

}
