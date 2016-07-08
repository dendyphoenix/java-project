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
			//트렌젝션 적용
			con.setAutoCommit(false);
		    System.out.println("connection success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			  Context initCtx = new InitialContext();
			  //Tomcat Server 자체의 Context(설정정보)를 얻어옴
			  Context envCtx= (Context)initCtx.lookup("java:comp/env");
			  //lookup 메소드의 리턴타입은 Object임
			  //Resource 정의에 관한 Context를 얻어옴
			  //여기까지는 무조건 접근해야 함.
			  
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
	
	//트렌젝션 부분
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
