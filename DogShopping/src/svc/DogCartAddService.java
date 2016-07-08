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
			//���� ��ٱ��Ͽ� ��� ��ǰ�� ������~
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		
		//��ٱ��� ���
		//���� ��ٱ��Ͽ� �������� �ϴ� ��ǰ�� �̹� ��ٱ��� �׸� ������
		//������ ����
		//�׸� ������ ���ο� ��ٱ��� �׸��� �߰�
		Cart cart = null;
		boolean newCart = true;
		//�켱 ���� ��ٱ��Ͽ� ���� ��ǰ�� ���� ��ٱ��� �׸� ���ٰ� ����
		
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
