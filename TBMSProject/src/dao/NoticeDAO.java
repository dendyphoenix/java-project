package dao;

import java.sql.Connection;
import java.util.ArrayList;

import vo.Notice;

import static db.jdbcUtil.*;

public class NoticeDAO {
	
	private Connection con;
	private static NoticeDAO instance;
	public NoticeDAO() {
		// TODO Auto-generated constructor stub
	}
	public void setConnection(Connection con){
		this.con=con;
	}
	public static NoticeDAO getInstance() {
		// TODO Auto-generated method stub
		if(instance==null){
			instance = new NoticeDAO();
		}
		return instance;
	}
	public ArrayList<Notice> selectNoticeList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
