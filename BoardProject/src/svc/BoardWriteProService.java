package svc;

import vo.Article;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
public class BoardWriteProService {

	public boolean writeArticle(Article article) {
		// TODO Auto-generated method stub
		boolean writeSucess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int insertCount = boardDAO.insertArticle(article);
		if(insertCount > 0){
			writeSucess = true;
			commit(con);
		}
		else{
			rollback(con);
		}
		close(con);
		return writeSucess;
	}

}
