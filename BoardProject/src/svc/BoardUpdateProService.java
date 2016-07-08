package svc;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
import vo.Article;
public class BoardUpdateProService {

	public int modifyArticle(Article article) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int updateCount = boardDAO.updateArticle(article);
		if(updateCount > 0){
			commit(con);
		}
		else{
			rollback(con);
		}
		close(con);
		return updateCount;
	}

}
