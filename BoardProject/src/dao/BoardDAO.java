package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static db.JdbcUtil.*;

import vo.Article;

public class BoardDAO {
	private Connection con;
private static BoardDAO instance;
private BoardDAO() {
	// TODO Auto-generated constructor stub
	
}
public void setConnection(Connection con) {
	// TODO Auto-generated method stub
	this.con = con;
}
public static BoardDAO getInstance(){
		if(instance == null){
				instance = new BoardDAO();
		}
		return instance;
}
public int insertArticle(Article article){
		int insertCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//��ۿ� �ʿ��� ������ ������ �Ҵ�
		int num = article.getNum();
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();
		
		//���ο� ���ñ� ��ȣ�� ������ ���� ����
		//������ �ۼ����� �� ���ο� ���ñ� ��ȣ�� �Ҵ��
		int number = 0;
		String sql = "";
		try {				
				//���ο� ���ñ� ��ȣ �����ϱ�
				//����Ʈ : ���� ���ñ� ��ȣ�� �ߺ����� �ʰ� ������ ��.
				pstmt = con.prepareStatement("SELECT MAX(num) FROM board");
				rs = pstmt.executeQuery();
				if(rs.next()){
					//���� �ۼ��� ���� ������
					number = rs.getInt(1) +1;
				}
				else{
					number = 0;{
						//�亯���̸�...		
					}
				}
				
				if(num != 0){
					sql = "UPDATE board SET re_step = re_step + 1 WHERE ref = ? AND re_step > ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1,ref);
					pstmt.setInt(2, re_step);
					pstmt.executeQuery();
					re_step = re_step + 1;
					re_level = re_level + 1;
				}
				else{
					//�����̸�
					ref = number;
					re_step = 0;
					re_level = 0;
				}
				
				sql = "INSERT INTO board(num,writer,email,subject,passwd,"
						+ "reg_date,ref,re_step,re_level,content,ip)"
						+ " VALUES(board_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, article.getWriter());
				pstmt.setString(2, article.getEmail());
				pstmt.setString(3, article.getSubject());
				pstmt.setString(4, article.getPasswd());
				pstmt.setTimestamp(5, article.getReg_date());
				pstmt.setInt(6, ref);
				pstmt.setInt(7, re_step);
				pstmt.setInt(8, re_level);
				pstmt.setString(9, article.getContent());
				pstmt.setString(10, article.getIp());
				
				insertCount = pstmt.executeUpdate();
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}
		
		return insertCount;
		
}
		public int selectArticleCount(){
			int articleCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {	
				//���ο� ���ñ� ��ȣ �����ϱ�
				//����Ʈ : ���� ���ñ� ��ȣ�� �ߺ����� �ʰ� ������ ��.
				pstmt = con.prepareStatement("SELECT COUNT(*) FROM board");
				rs = pstmt.executeQuery();
				if(rs.next()){
					articleCount = rs.getInt(1);
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}
			return articleCount;
		}
		public ArrayList<Article> selectArticleList(int startRow,int pageSize){
			ArrayList<Article> articleList = null;
			Article article = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = getConnection();
				
				//���ο� ���ñ� ��ȣ �����ϱ�
				//����Ʈ : ���� ���ñ� ��ȣ�� �ߺ����� �ʰ� ������ ��.
				pstmt = con.prepareStatement("SELECT list2.* FROM "
						+ "(SELECT rownum r,list1.* FROM "
						+ "(SELECT * FROM board ORDER BY ref DESC,re_step ASC) list1) list2 WHERE r BETWEEN ? AND ?");
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, startRow + pageSize - 1);
				rs = pstmt.executeQuery();
				if(rs.next()){
					articleList = new ArrayList<Article>();
					do{
						article = new Article();
						article.setNum(rs.getInt("num"));
						article.setWriter(rs.getString("writer"));
						article.setEmail(rs.getString("Email"));
						article.setSubject(rs.getString("Subject"));
						article.setPasswd(rs.getString("passwd"));
						article.setReg_date(rs.getTimestamp("reg_date"));
						article.setRef(rs.getInt("ref"));
						article.setRe_step(rs.getInt("re_step"));
						article.setRe_level(rs.getInt("re_level"));
						article.setReadcount(rs.getInt("readcount"));
						article.setContent(rs.getString("content"));
						article.setIp(rs.getString("ip"));
								
						articleList.add(article);
					}while(rs.next());
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
			close(con);
		}
			return articleList;
		}
		
		
		public Article selectArticle(int num){
			Article article = null;			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				//��ȸ�� ����
				pstmt = con.prepareStatement("UPDATE board SET readcount = readcount + 1 WHERE num = ?");
				pstmt.setInt(1, num);
				int updateCount = pstmt.executeUpdate();
				if(updateCount > 0){
					commit(con);
				}
				else{
					rollback(con);
				}
				
				pstmt = con.prepareStatement("SELECT * FROM board WHERE num = ?");
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();
				
				if(rs.next()){
						article = new Article();
						article.setNum(rs.getInt("num"));
						article.setWriter(rs.getString("writer"));
						article.setEmail(rs.getString("Email"));
						article.setSubject(rs.getString("Subject"));
						article.setPasswd(rs.getString("passwd"));
						article.setReg_date(rs.getTimestamp("reg_date"));
						article.setRef(rs.getInt("ref"));
						article.setRe_step(rs.getInt("re_step"));
						article.setRe_level(rs.getInt("re_level"));
						article.setReadcount(rs.getInt("readcount"));
						article.setContent(rs.getString("content"));
						article.setIp(rs.getString("ip"));
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}
			return article;
		}
		
		public Article selectUpdateArticle(int num){
			Article article = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				
				pstmt = con.prepareStatement("SELECT * FROM board WHERE num = ?");
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();
				
				if(rs.next()){
						article = new Article();
						article.setNum(rs.getInt("num"));
						article.setWriter(rs.getString("writer"));
						article.setEmail(rs.getString("Email"));
						article.setSubject(rs.getString("Subject"));
						article.setPasswd(rs.getString("passwd"));
						article.setReg_date(rs.getTimestamp("reg_date"));
						article.setRef(rs.getInt("ref"));
						article.setRe_step(rs.getInt("re_step"));
						article.setRe_level(rs.getInt("re_level"));
						article.setReadcount(rs.getInt("readcount"));
						article.setContent(rs.getString("content"));
						article.setIp(rs.getString("ip"));
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}
			return article;
		}
		public int updateArticle(Article article){
			int updateCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			//��񿡼� ������ ��й�ȣ�� ������ ���� ����
			 String dbPasswd = null;
			try {
				
				pstmt = con.prepareStatement("SELECT passwd"
						+ " FROM board WHERE num = ?");
				pstmt.setInt(1, article.getNum());
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					dbPasswd = rs.getString("passwd");
					
					//��񿡼� ������ ��й�ȣ�� ����ڰ� �Է��� ��й�ȣ�� ������
					//���� �۾� ����
					if(dbPasswd.equals(article.getPasswd())){
						pstmt = con.prepareStatement("UPDATE board SET email=?, "
								+ "subject=?, passwd=?, content=? WHERE num=?");
						pstmt.setString(1, article.getEmail());
						pstmt.setString(2, article.getSubject());
						pstmt.setString(3, article.getPasswd());
						pstmt.setString(4, article.getContent());
						pstmt.setInt(5, article.getNum());
						
						updateCount = pstmt.executeUpdate();				
				}
				}
			}
		 catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}
		return updateCount;
		}
		public int deleteArticle(int num,String passwd){
			int deleteCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			//��񿡼� ������ ��й�ȣ�� ������ ���� ����
			String dbPasswd = null;
			try {
				
				pstmt = con.prepareStatement("SELECT passwd"
						+ " FROM board WHERE num = ?");
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					dbPasswd = rs.getString("passwd");
					
					//��񿡼� ������ ��й�ȣ�� ����ڰ� �Է��� ��й�ȣ�� ������
					//���� �۾� ����
					if(dbPasswd.equals(passwd)){
						pstmt = con.prepareStatement("DELETE board WHERE num=?");
						pstmt.setInt(1, num);
						
						deleteCount = pstmt.executeUpdate();
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			finally{
				close(rs);
				close(pstmt);
			}
			return deleteCount;
		}

}
