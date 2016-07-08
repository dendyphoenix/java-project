package svc;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
public class BoardRemoveService {

	public int removeArticle(int num, String passwd) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int deleteCount = boardDAO.deleteArticle(num,passwd);
		if(deleteCount > 0){
			commit(con);
		}
		else{
			rollback(con);
		}
		close(con);
		return deleteCount;
	}

}
