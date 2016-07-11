package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.NoticeDAO;

import static db.jdbcUtil.*;
import vo.Notice;

public class NoticeListService {

	public ArrayList<Notice> getnotice() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		 
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(con);
		
		ArrayList<Notice> noticeList = noticeDAO.selectNoticeList();
		close(con);
		
		return noticeList;
	}

}
