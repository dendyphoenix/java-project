package svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.BoardDAO;
import vo.Article;

public class BoardContentService {

	public Article getArticle(int num) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		Article article = boardDAO.selectArticle(num);
		close(con);
		return article;
	}

}
