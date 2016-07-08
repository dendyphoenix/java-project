package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	/*static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public static Connection getConnection(){
    	Connection con = null;
		/*try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "dendyphoenix","pij1205");
			//Ʈ������ ����
			con.setAutoCommit(false);
		    System.out.println("connection success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			  Context initCtx = new InitialContext();
			  //Tomcat Server ��ü�� Context(��������)�� ����
			  Context envCtx= (Context)initCtx.lookup("java:comp/env");
			  //lookup �޼ҵ��� ����Ÿ���� Object��
			  //Resource ���ǿ� ���� Context�� ����
			  //��������� ������ �����ؾ� ��.
			  
			  DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
			  con = ds.getConnection();
			  con.setAutoCommit(false);
			  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	public static void close(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt){
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs){
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Ʈ������ �κ�
	public static void commit(Connection con){
		try {
			con.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void rollback(Connection con){
		try {
			con.rollback();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
