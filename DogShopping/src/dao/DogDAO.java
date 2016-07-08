package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Dog;

import static db.jdbcUtil.*;


public class DogDAO {
	private Connection con;
	private static DogDAO instance;
	public DogDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con=con;
		
	}
	public static DogDAO getInstance(){
		if(instance == null){
			instance = new DogDAO();
		}
		return instance;
	}

	public ArrayList<Dog> selectDogList() {
		// TODO Auto-generated method stub
		ArrayList<Dog> dogList = null;
		Dog dog = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			pstmt = con.prepareStatement("SELECT * FROM dog");
			rs = pstmt.executeQuery();
			if(rs.next()){
				dogList = new ArrayList<Dog>();
				do{
					dog = new Dog();
					dog.setContent(rs.getString("content"));
					dog.setCountry(rs.getString("country"));
					dog.setHeight(rs.getInt("height"));
					dog.setId(rs.getInt("id"));
					dog.setImage(rs.getString("image"));
					dog.setKind(rs.getString("kind"));
					dog.setPrice(rs.getInt("price"));
					dog.setReadcount(rs.getInt("readcount"));
					dog.setWeight(rs.getInt("weight"));
					dogList.add(dog);
				}while(rs.next());
				
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return dogList;
	}

	public Dog selectDog(int id) {
		// TODO Auto-generated method stub
		Dog dog = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			pstmt = con.prepareStatement("SELECT * FROM dog"
					+ " WHERE id = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
					dog = new Dog();
					dog.setContent(rs.getString("content"));
					dog.setCountry(rs.getString("country"));
					dog.setHeight(rs.getInt("height"));
					dog.setId(rs.getInt("id"));
					dog.setImage(rs.getString("image"));
					dog.setKind(rs.getString("kind"));
					dog.setPrice(rs.getInt("price"));
					dog.setReadcount(rs.getInt("readcount"));
					dog.setWeight(rs.getInt("weight"));
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		
		return dog;
	}

	public int updateReadcount(int id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int updateCount = 0;
				
		try {
			
			//조회수 증가
			pstmt = con.prepareStatement("UPDATE dog SET readcount = readcount + 1"
					+ " WHERE id = ?");
			pstmt.setInt(1, id);
			
			updateCount = pstmt.executeUpdate();
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
}
