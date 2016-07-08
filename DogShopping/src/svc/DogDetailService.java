package svc;

import java.sql.Connection;

import dao.DogDAO;
import vo.Dog;

import static db.jdbcUtil.*;

public class DogDetailService {
	
	public Dog getDog(int id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		DogDAO dogDAO = DogDAO.getInstance();
		dogDAO.setConnection(con);
		
		//조회수 증가
		int updateCount = dogDAO.updateReadcount(id);
		if(updateCount > 0){
			commit(con);
		}
		else{
			rollback(con);
		}
		
		Dog dog = dogDAO.selectDog(id);
		close(con);
		return dog;
	}
	
	
}
