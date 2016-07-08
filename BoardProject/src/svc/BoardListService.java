package svc;
import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.Article;
public class BoardListService {

	public int getArticleCount() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int articleCount = boardDAO.selectArticleCount();
		close(con);
		return articleCount;
	}

	public ArrayList<Article> getArticleList(int startRow, int pageSize) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		ArrayList<Article> articleList = 
				boardDAO.selectArticleList(startRow, pageSize);
		close(con);
		return articleList;
	}

}
