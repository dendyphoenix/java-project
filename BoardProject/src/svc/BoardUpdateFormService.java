package svc;

import vo.Article;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
public class BoardUpdateFormService {

	public static Article getUpdateArticle(int num) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		Article article = boardDAO.selectUpdateArticle(num);
		close(con);
		return article;
	}

}
