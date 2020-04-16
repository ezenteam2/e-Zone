package ezone.model;

import java.sql.*;
import java.util.*;
import ezone.vo.*;

public class kb_MemberDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	ArrayList<Member> mlist;
	
	public kb_MemberDao() {};
	
	public void setCon() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String info = "jdbc:oracle:thin:@192.168.4.90:1521:xe";
		conn = DriverManager.getConnection(info, "scott", "tiger");
		System.out.println("정상 접속 성공!");
	}
	
	public String getfindId(String name, String email){
		String id = "";
		
		try {
			setCon();
			String Query = "select mem_id from p5member where mem_name = ? and mem_email=?";
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getString(1);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	
	public boolean findPass(String id, String email) {
	    boolean isExist = false;
	    
	    try {
	    	setCon();
	    	String Query = "select * from p5member where mem_id = ? and mem_email = ?";
	    	pstmt = conn.prepareStatement(Query);
	    	pstmt.setString(1,  id);
	    	pstmt.setString(2,  email);
	    	rs = pstmt.executeQuery();
	    	
	    	isExist = rs.next();
	    	rs.close();
	    	pstmt.close();
	    	conn.close();
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return isExist;
	}
	
	public void UpdatePass(String pass, String id) {
		try {
			setCon();
			String Query = "update p5member set mem_pw = ? where mem_id = ?";
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1,  pass);
			pstmt.setString(2,  id);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch(Exception el) {
				el.printStackTrace();
			}
		}
	}
	
	public String isLogin(String id, String pass) {
		String check = "";
		try {
			setCon();
			String Query = "select mem_id, mem_pw from p5member where mem_id = ?";
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1,  id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String idChk = rs.getString(1);
				String pwChk = rs.getString(2);
				if(id.equals(idChk) && pass.equals(pwChk)) {
					check = id;
				} else {
					check = "";
				}
				
			} else {
				check="";
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return check;
	}
}
