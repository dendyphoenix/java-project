package svc;

import static db.jdbcUtil.close;
import static db.jdbcUtil.commit;
import static db.jdbcUtil.getConnection;
import static db.jdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DogDAO;
import vo.Cart;
import vo.Dog;

public class DogCartAddService {
	
	public Dog getDog(int id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		DogDAO dogDAO = DogDAO.getInstance();
		dogDAO.setConnection(con);
		
		Dog dog = dogDAO.selectDog(id);
		close(con);
		return dog;
	}

	public void addCart(Dog dog, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		if(cartList == null){
			//아직 장바구니에 담긴 상품이 없으면~
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		
		//장바구니 담기
		//지금 장바구니에 담으려고 하는 상품이 이미 장바구니 항목에 있으면
		//수량만 증가
		//항목에 없으면 새로운 장바구니 항목을 추가
		Cart cart = null;
		boolean newCart = true;
		//우선 지금 장바구니에 담을 상품이 기존 장바구니 항목에 없다고 가정
		
		for(int i=0; i<cartList.size();i++){
			if(dog.getId() == cartList.get(i).getId()){
				newCart = false;
				cartList.get(i).setQty(cartList.get(i).getQty()+1);
			}
		}
		
		if(newCart){
			cart = new Cart();
			cart.setId(dog.getId());
			cart.setImage(dog.getImage());
			cart.setKind(dog.getKind());
			cart.setPrice(dog.getPrice());
			cart.setQty(1);
			
			cartList.add(cart);
			
		}
		
	}
	
	

}
